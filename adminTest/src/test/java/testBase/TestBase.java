package testBase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.util.logging.Level;

/**
 * Created by korotkovay on 29.11.2016.
 */
public class TestBase {

    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
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


    @Before
    public void start() throws Exception {

        //Remote
        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        String hubURL = "http://10.1.1.118:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(hubURL), dc);
*/

        // Chrome

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


        // System.out.println(((HasCapabilities) driver).getCapabilities());

        // Firefox
/*
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
       // System.out.println(((HasCapabilities) driver).getCapabilities());

*/
        // Firefox Nightly
/*
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "C:\\temp\\marionette.exe");
        capabilities.setCapability("marionette", true);
        capabilities.setCapability("binary", "C:\\Program Files\\Nightly\\firefox.exe");
        driver = new FirefoxDriver(capabilities);


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("binary", "C:\\Program Files\\Nightly\\firefox.exe");
        driver = new FirefoxDriver(caps);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        System.out.println(((HasCapabilities) driver).getCapabilities());
*/
        // Firefox-old
/*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(caps);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        System.out.println(((HasCapabilities) driver).getCapabilities());
*/
        // IE
/*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        driver = new InternetExplorerDriver(caps);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        System.out.println(((HasCapabilities) driver).getCapabilities());
*/

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
