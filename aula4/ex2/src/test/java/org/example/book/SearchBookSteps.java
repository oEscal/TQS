package org.example.book;

import book.Book;
import book.Library;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SearchBookSteps {

    private Library library = new Library();
    private List<Book> books_list;

    @Given("a book with the title {string}, written by {string}, published in {date_iso_local_date_time}")
    public void a_book_with_the_title_written_by_published_in_March(String title, String author, LocalDateTime publish_date) {
        library.addBook(new Book(title, author, publish_date));
    }

    @Given("another book with the title {string}, written by {string}, published in {date_iso_local_date_time}")
    public void another_book_with_the_title_written_by_published_in_August(String title, String author, LocalDateTime publish_date) {
        library.addBook(new Book(title, author, publish_date));
    }

    @When("the customer searches for books published between {date_iso_local_date_time} and {date_iso_local_date_time}")
    public void the_customer_searches_for_books_published_between_and(LocalDateTime from, LocalDateTime to) {
        books_list = library.findBooks(from, to);
    }

    @Then("{int} books should have been found")
    public void books_should_have_been_found(Integer number_books) {
        assertEquals(number_books.intValue(), books_list.size());
    }

    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title1(Integer index, String title) {
        assertEquals(title, books_list.get(index - 1).getTitle());
    }
}
