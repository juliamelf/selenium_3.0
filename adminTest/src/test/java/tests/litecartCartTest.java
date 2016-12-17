package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;



/**
 * Created by korotkovay on 14.12.2016.
 */
public class litecartCartTest extends TestBase{

    @Test
    public void testAddToCart() {

        //Go to Index page
        openIndexPage();

        //Add first product
        addProduct(0);
        checkCartQuantity(1);

        //Add first product
        addProduct(1);
        checkCartQuantity(2);

        //Add first product
        addProduct(2);
        checkCartQuantity(3);

        //Go to Cart
        openCart();

        //Delete products from cart
        deleteProducts();
    }



    private void openIndexPage() {
        driver.navigate().to("http://localhost/litecart/");
    }

    public void addProduct(int id) {
        driver.findElement(By.xpath("//div[@id='box-category-tree']//a[@href='http://localhost/litecart/en/rubber-ducks-c-1/']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='listing-wrapper products']//a[@class='link']"));
        products.get(id).click();
        wait.until(elementToBeClickable(By.name("add_cart_product")));
        driver.findElement(By.name("add_cart_product")).click();
    }

    public void checkCartQuantity(int id) {
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='cart']//span[text() = '" + id + "']")));
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
