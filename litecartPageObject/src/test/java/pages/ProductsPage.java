package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by korotkovay on 22.12.2016.
 */
public class ProductsPage extends Page {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@id='box-category-tree']//a[@href='http://localhost/litecart/en/rubber-ducks-c-1/']")
    public WebElement category;

    @FindBy(xpath="//ul[@class='listing-wrapper products']//a[@class='link']")
    public List<WebElement> products;

    @FindBy(name="add_cart_product")
    public WebElement addToCart;

    public void openProductPage() {
        driver.navigate().to("http://localhost/litecart/");
    }

    public void waitForButton() {
        wait.until(elementToBeClickable(By.name("add_cart_product")));
    }

    public void checkCartQuantity(int id) {
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='cart']//span[text() = '" + id + "']")));
    }

}
