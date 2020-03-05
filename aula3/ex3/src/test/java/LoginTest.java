// Generated by Selenium IDE
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gyftedstore.core.scrapper.config.SeleniumConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class LoginTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    private SeleniumConfig config = ;

    @FindBy(linkText = "Sign in")
    private WebElement sign_in_text;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://demo.redmine.org/");
        driver.manage().window().setSize(new Dimension(1920, 1030));

        sign_in_text.click();

        driver.findElement(By.id("username")).sendKeys("escaleira@ua.pt");
        driver.findElement(By.id("password")).sendKeys("M2HAQYcYux28BbM8bA3Cn");
        driver.findElement(By.name("login")).click();
        assertThat(driver.findElement(By.xpath("//div[2]/a")).getText(), is("escaleira@ua.pt"));
        driver.findElement(By.linkText("Sign out")).click();
        assertThat(driver.findElement(By.linkText("Sign in")).getText(), is("Sign in"));
    }
}
