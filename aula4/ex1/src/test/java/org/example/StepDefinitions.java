package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


class Ask {
    static String is_it_friday_question_mark(String today) {
        if (today.equals("Friday"))
            return "Parece-me que sim";
        return "Nope";
    }
}

public class StepDefinitions {

    private String today;
    private String answer;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @Given("today is Friday")
    public void today_is_Friday() {
        today = "Friday";
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        answer = Ask.is_it_friday_question_mark(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expected_answer) {
        assertEquals(expected_answer, answer);
    }
}
