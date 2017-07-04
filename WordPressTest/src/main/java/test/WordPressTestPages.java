package test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.WordPressPageLogin;
import pageobject.WordPressPagePages;

public class WordPressTestPages {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public WordPressPagePages wordPressPagePages;
  public WordPressPageLogin wordPressPageLogin;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://demosite.center/";
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.get(baseUrl + "wordpress/wp-admin/index.php");
    wordPressPageLogin = PageFactory.initElements(driver, WordPressPageLogin.class);
    wordPressPagePages = PageFactory.initElements(driver, WordPressPagePages.class);
    driver.get(baseUrl + "/wordpress/wp-login.php");
  }


  @Test
  public void testWordPressTestPages() throws Exception {

    wordPressPageLogin.login("admin", "demo123");
    wordPressPagePages.checkTest("TestPage", "This is a new page");

    // ERROR: Caught exception [unknown command []]
    // ERROR: Caught exception [unknown command []]
  }

  @Test
  public void testWordPressTestPages2() throws Exception {

    wordPressPageLogin.login("admin", "demo123");
    wordPressPagePages.checkTest("TestPage2", "This is a newer page");



    // ERROR: Caught exception [unknown command []]
    // ERROR: Caught exception [unknown command []]
  }

  @Test
  public void testWordPressTestPages3() throws Exception {

    wordPressPageLogin.login("admin", "demo123");
    wordPressPagePages.checkTest("TestPage", "This is a newer page");

    // ERROR: Caught exception [unknown command []]
    // ERROR: Caught exception [unknown command []]
  }

  @Test
  public void testWordPressTestPages4() throws Exception {

    wordPressPageLogin.login("admin", "demo123");
    wordPressPagePages.checkTest("TestPage", "This is a newer page");




    // ERROR: Caught exception [unknown command []]
    // ERROR: Caught exception [unknown command []]
  }

  @Test
  public void testWordPressTestPages5() throws Exception {

    wordPressPageLogin.login("admin", "demo123");
    wordPressPagePages.checkTest("TestPage", "This is a newer page");

    // ERROR: Caught exception [unknown command []]
    // ERROR: Caught exception [unknown command []]
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
