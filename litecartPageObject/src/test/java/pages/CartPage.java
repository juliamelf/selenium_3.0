package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private void openCart() {
        driver.findElement(By.xpath("//div[@id='cart']/a[@class='link']")).click();
    }

    private void deleteProducts() {
        List<WebElement> products = driver.findElements(By.xpath("//div[@id='box-checkout-cart']//li[@class='item']"));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(stalenessOf(products.get(0)));
        wait.until(numberOfElementsToBe(By.xpath("//div[@id='box-checkout-cart']//li[@class='shortcut']"), 2));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(stalenessOf(products.get(1)));
        wait.until(numberOfElementsToBe(By.xpath("//div[@id='box-checkout-cart']//li[@class='shortcut']"), 0));
        driver.findElement(By.name("remove_cart_item")).click();
        Assert.assertEquals("There are no items in your cart.", driver.findElement(By.cssSelector("div[id=\"checkout-cart-wrapper\"]>p>em")).getText());
    }

}
