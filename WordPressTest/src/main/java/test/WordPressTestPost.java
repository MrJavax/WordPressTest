package test;
/**
 * Created by alexander on 24/06/17.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageobject.WordPressPageLogin;
import pageobject.WordPressPagePostValidate1;
import pageobject.WordPressPagePostValidate2;
import pageobject.WordPressPagePostValidate3;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class WordPressTestPost {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private WordPressPagePostValidate1 wordPressPagePostValidate1;
    private WordPressPageLogin wordPressPageLogin;
    private WordPressPagePostValidate2 wordPressPagePostValidate2;
    private WordPressPagePostValidate3 wordPressPagePostValidate3;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center/wordpress/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wordPressPageLogin = PageFactory.initElements(driver, WordPressPageLogin.class);
        wordPressPagePostValidate1 = PageFactory.initElements(driver, WordPressPagePostValidate1.class);
        wordPressPagePostValidate2 = PageFactory.initElements(driver, WordPressPagePostValidate2.class);
        wordPressPagePostValidate3 = PageFactory.initElements(driver, WordPressPagePostValidate3.class);
    }

    @Test
    public void testWordPressTest1() throws Exception {
        driver.get(baseUrl + "wp-admin/index.php");
        wordPressPageLogin.login("admin", "demo123");
        wordPressPagePostValidate1.addNewPost1("TestCase01", "This is a test case number 1.");
        try {
            driver.get(driver.findElement(By.linkText("Preview post")).getAttribute("href"));
            assertEquals("TestCase01", driver.findElement(By.linkText("TestCase01")).getText());
            assertEquals("This is a test case number 1.", driver.findElement(By.xpath("//div[@class='entry']/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testWordPressTest2() throws Exception {
        driver.get(baseUrl + "wp-admin/index.php");
        wordPressPageLogin.login("admin", "demo123");
        wordPressPagePostValidate1.addNewPost2("TestCase02", "This is a test case number 2.");
        try {
            assertEquals("TestCase02", driver.findElement(By.linkText("TestCase02")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void testWordPressTest3() throws Exception {
        driver.get(baseUrl + "wp-admin/index.php");
        wordPressPageLogin.login("admin", "demo123");
        wordPressPagePostValidate2.addNewTag("TestCase3", "testcase-tag", "This is a test number 03.");
        try {
            driver.get(baseUrl + "wp-admin/edit-tags.php?taxonomy=post_tag");
            isElementPresent(By.name("delete_tags[]"));
            assertEquals("TestCase3", driver.findElement(By.linkText("TestCase3")).getText());
            assertEquals("This is a test number 03.", driver.findElement(By.xpath("//tbody[@id='the-list']/tr/td[2]")).getText());
            assertEquals("testcase-tag", driver.findElement(By.xpath("//tbody[@id='the-list']/tr/td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testWordPressTest4() throws Exception {
        driver.get(baseUrl + "wp-admin/index.php");
        wordPressPageLogin.login("admin", "demo123");
        wordPressPagePostValidate2.deleteTag("TestCase4", "testcase-tag2", "This is a test number 04.");
        new Select(driver.findElement(By.name("action"))).selectByVisibleText("Delete");
        wordPressPagePostValidate2.clickDelete();
        try {
            isElementPresent(By.id("message"));
            assertEquals("Items deleted.", driver.findElement(By.xpath("//div[@id='message']/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testWordPressTest5() throws Exception {
        driver.get(baseUrl + "wp-admin/index.php");
        wordPressPageLogin.login("admin", "demo123");
        wordPressPagePostValidate3.editCategory("Test Category", "test-cat-tag");
        new Select(driver.findElement(By.id("parent"))).selectByVisibleText("None");
        wordPressPagePostValidate3.editCat("This category has been updated.");
        try {
            isElementPresent(By.id("message"));
            //assertEquals("Item updated.", driver.findElement(By.xpath("//div[@id='message']/p")).getText());
            assertEquals("Test Category", driver.findElement(By.linkText("Test Category")).getText());
            assertEquals("This category has been updated.", driver.findElement(By.xpath("//tbody[@id='the-list']/tr/td[2]")).getText());
            assertEquals("test-cat-tag", driver.findElement(By.xpath("//tbody[@id='the-list']/tr/td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
