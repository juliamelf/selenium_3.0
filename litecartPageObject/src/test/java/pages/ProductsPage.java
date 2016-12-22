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


}
