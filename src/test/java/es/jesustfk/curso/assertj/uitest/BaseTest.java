package es.jesustfk.curso.assertj.uitest;

import es.jesustfk.curso.assertj.assertion.PageAssert;
import es.jesustfk.curso.assertj.assertion.WebElementAssert;
import es.jesustfk.curso.assertj.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        this.driver = new ChromeDriver();
        this.driver = new FirefoxDriver();
    }

    protected WebElementAssert assertThat(WebElement element){
        return WebElementAssert.assertThat(element);
    }

    protected PageAssert assertThat(BasePage page){
        return PageAssert.assertThat(page);
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
