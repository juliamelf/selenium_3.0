package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by korotkovay on 22.12.2016.
 */
public class Application {

    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    private ProductsPage productsPage;
    private CartPage cartPage;

    public Application() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new EventFiringWebDriver(new ChromeDriver(cap));
        driver.register(new MyListener());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание
        wait = new WebDriverWait(driver, 10); //явное ожидание

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by +  " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }
    }

    public void quit() {
        driver.quit();
    }

    public void openIndexPage() {
        productsPage.openProductPage();
    }

    public void addProduct(int id) {
        productsPage.category.click();
        productsPage.products.get(id).click();
        productsPage.waitForButton();
        productsPage.addToCart.click();
    }

    public void checkCartQuantity(int id) {
        productsPage.checkCartQuantity(id);
    }

    public void openCart() {

        cartPage.openCart.click();
    }

    public void deleteProducts() {
        cartPage.removeItem.click();
        cartPage.waitUntilProductDisappear(0);
        cartPage.waitUntilShortcutQuantityToBe(2);
        cartPage.removeItem.click();
        cartPage.waitUntilProductDisappear(1);
        cartPage.waitUntilShortcutQuantityToBe(0);
        cartPage.removeItem.click();
        cartPage.assertNoItemsInCart();
    }

}
