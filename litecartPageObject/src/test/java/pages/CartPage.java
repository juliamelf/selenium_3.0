package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by korotkovay on 22.12.2016.
 */
public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='cart']/a[@class='link']")
    public WebElement openCart;

    @FindBy(xpath = "//div[@id='box-checkout-cart']//li[@class='item']")
    public List<WebElement> products;

    @FindBy(name="remove_cart_item")
    public WebElement removeItem;

    public void waitUntilProductDisappear(int id) {
        wait.until(stalenessOf(products.get(id)));
    }

    public void waitUntilShortcutQuantityToBe(int id) {
        wait.until(numberOfElementsToBe(By.xpath("//div[@id='box-checkout-cart']//li[@class='shortcut']"), id));
    }

    public void assertNoItemsInCart() {
        Assert.assertEquals("There are no items in your cart.", driver.findElement(By.cssSelector("div[id='checkout-cart-wrapper']>p>em")).getText());
    }

}
