package app;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ProductsPage;

import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by korotkovay on 22.12.2016.
 */
public class Application {

    private WebDriver driver;
    private WebDriverWait wait;

    private ProductsPage productsPage;
    private CartPage cartPage;


    public Application() {
        driver = new ChromeDriver();
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void openIndexPage() {
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

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
