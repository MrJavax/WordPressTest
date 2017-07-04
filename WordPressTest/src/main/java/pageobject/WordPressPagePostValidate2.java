package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by alexander on 02/07/17.
 */
public class WordPressPagePostValidate2 {
    WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Posts")
    WebElement lkPosts;

    @FindBy(how = How.LINK_TEXT, using = "Tags")
    WebElement lkTags;

    @FindBy(id = "tag-name")
    WebElement txtName;

    @FindBy(id = "tag-slug")
    WebElement txtSlug;

    @FindBy(id = "tag-description")
    WebElement txtDesc;

    @FindBy(id = "submit")
    WebElement btSubmit;

    @FindBy(name = "delete_tags[]")
    WebElement chkAction;

    @FindBy(name = "action")
    WebElement slcAction;

    @FindBy (id = "doaction")
    WebElement btDelete;

    public WordPressPagePostValidate2(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewTag(String name, String slug, String desc) {
        this.lkPosts.click();
        this.lkTags.click();
        this.txtName.sendKeys(name);
        this.txtSlug.sendKeys(slug);
        this.txtDesc.sendKeys(desc);
        this.btSubmit.click();
    }

    public void deleteTag(String name, String slug, String desc) {
        this.lkPosts.click();
        this.lkTags.click();
        this.txtName.sendKeys(name);
        this.txtSlug.sendKeys(slug);
        this.txtDesc.sendKeys(desc);
        this.btSubmit.click();
        this.chkAction.click();
    }

    public void clickDelete() {
        this.btDelete.click();
    }
}
