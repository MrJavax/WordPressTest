package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Created by alexander on 24/06/17.
 */
public class WordPressPagePages {
    WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Pages")
    WebElement lkPages;

    @FindBy (how = How.CLASS_NAME, using = "a.add-new-h2")
    WebElement clAddPage;

    @FindBy (id = "title")
    WebElement txtTitle;

    @FindBy (how = How.TAG_NAME, using = "p")
    WebElement txtDesc;

    @FindBy (id = "save-post")
    WebElement btSavePage;

    @FindBy (how = How.TAG_NAME, using = "#message > p")
    WebElement lblPreview;

    @FindBy(how = How.LINK_TEXT, using = "New page")
    WebElement lkCheckTitle;

    public WordPressPagePages(WebDriver driver) {
        this.driver = driver;
    }

    public void linkToPost () {
        this.lkPages.click();
        this.clAddPage.click();
    }

    public  void typeTitle (String title) {
        this.txtTitle.sendKeys(title);
    }

    public void typeDesc (String desc) {
        this.txtDesc.sendKeys(desc);
    }

    //public void checkPreview (String preview) {this.lblPreview.sendKeys(preview);}

    //public void checkTitle (String title2) {this.lkCheckTitle.sendKeys(title2);}

    public void savePage() {
        this.btSavePage.click();
    }

    public void checkTest(String title, String desc) {
        linkToPost();
        typeTitle(title);
        typeDesc(desc);
        savePage();
    }


}