package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by alexander on 02/07/17.
 */
public class WordPressPagePostValidate3 {
    WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Posts")
    WebElement lkPosts;

    @FindBy(how = How.LINK_TEXT, using = "Categories")
    WebElement lkCategories;

    @FindBy(how = How.LINK_TEXT, using = "Common News")
    WebElement lkEdit;

    @FindBy(id = "name")
    WebElement txtName;

    @FindBy(id = "slug")
    WebElement txtSlug;

    @FindBy(id = "description")
    WebElement txtDesc;

    @FindBy(id ="parent")
    WebElement slcParent;

    @FindBy(id = "submit")
    WebElement btUpdate;

    public WordPressPagePostValidate3(WebDriver driver) {
        this.driver = driver;
    }

    public void editCategory(String name, String slug) {
        this.lkPosts.click();
        this.lkCategories.click();
        this.lkEdit.click();
        this.txtName.clear();
        this.txtName.sendKeys(name);
        this.txtSlug.clear();
        this.txtSlug.sendKeys(slug);
        this.slcParent.click();
    }

    public void editCat(String desc) {
        this.txtDesc.clear();
        this.txtDesc.sendKeys(desc);
        this.btUpdate.click();
    }
}
