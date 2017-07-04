package test;
/**
 * Created by alexander on 24/06/17.
 */

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.WordPressPageLogin;
import pageobject.WordPressPagePostValidate1;

public class WordPressTestLogin {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private WordPressPageLogin wordPressPageLogin;
    private WordPressPagePostValidate1 wordPressPagePostValidate1;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wordPressPageLogin = PageFactory.initElements(driver, WordPressPageLogin.class);
        wordPressPagePostValidate1 = PageFactory.initElements(driver, WordPressPagePostValidate1.class);
    }

    @Test
    public void testWordPressTest1() throws Exception {
        driver.get(baseUrl + "/wordpress/wp-login.php");
        wordPressPageLogin.login("admin", "demo123");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
