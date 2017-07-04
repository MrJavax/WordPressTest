package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by alexander on 24/06/17.
 */
public class WordPressPagePostValidate1 {
    WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Posts")
    WebElement lkPosts;

    @FindBy(how = How.CLASS_NAME, using = "add-new-h2")
    WebElement clAddNew;

    @FindBy(id = "title")
    WebElement txtTitle;

    @FindBy(id = "content")
    WebElement txtDesc;

    @FindBy(id = "save-post")
    WebElement btSavePost;

    @FindBy(how = How.LINK_TEXT, using = "Preview post")
    WebElement lkPreview;

    public WordPressPagePostValidate1(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewPost1(String title, String desc) {
        this.lkPosts.click();
        this.clAddNew.click();
        this.txtTitle.sendKeys(title);
        this.txtDesc.sendKeys(desc);
        this.btSavePost.click();
        this.lkPreview.click();
    }

    public void addNewPost2(String title, String desc) {
        this.lkPosts.click();
        this.clAddNew.click();
        this.txtTitle.sendKeys(title);
        this.txtDesc.sendKeys(desc);
        this.btSavePost.click();
        this.lkPosts.click();
    }
}
