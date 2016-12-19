package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import testBase.TestBase;

import java.util.List;
import java.util.Set;

/**
 * Created by korotkovay on 19.12.2016.
 */
public class adminCountryTest extends TestBase {

    String mainWindow;
    Set<String> oldWindows;

    @Test
    public void testCountryOpen() {
        //login to admin interface
        openAdmin();
        loginAdmin();

        //Go to Country Page
        openCountries();

        //Open Country for editing
        editCountry();

        //Open Code (ISO 3166-1 alpha-2)
        openNewWindow(By.cssSelector("input[name='iso_code_2'] + a"), "ISO 3166-1 alpha-2 - Wikipedia");

        //Open Code (ISO 3166-1 alpha-3)
        openNewWindow(By.cssSelector("a[href='http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3']"), "ISO 3166-1 alpha-3 - Wikipedia");

        //Open Tax ID Format
        openNewWindow(By.xpath("//strong[. = 'Tax ID Format']/../a"), "Regular expression - Wikipedia");

        //Open Address Format
        openNewWindow(By.cssSelector("a[href='http://www.addressdoctor.com/en/countries-data/address-formats.html']"), "International Proper Mailing Address Format | Informatica US");

        //Open Postcode Format
        openNewWindow(By.xpath("//strong[. = 'Postcode Format']/../a"), "Regular expression - Wikipedia");

        //Open Currency Code
        openNewWindow(By.cssSelector("a[href='https://en.wikipedia.org/wiki/List_of_countries_and_capitals_with_currency_and_language']"), "List of countries and capitals with currency and language - Wikipedia");

        //Open Phone Country Code
        openNewWindow(By.cssSelector("a[href='https://en.wikipedia.org/wiki/List_of_country_calling_codes']"), "List of country calling codes - Wikipedia");

    }

    private void openNewWindow(By locator, String title) {
        driver.findElement(locator).click();
        String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
        driver.switchTo().window(newWindow);
        Assert.assertEquals(title, driver.getTitle());
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    private void editCountry() {
        List<WebElement> countries = driver.findElements(By.xpath("//a[@title='Edit']"));
        countries.get(209).click(); //скоро отпуск!
        mainWindow = driver.getWindowHandle();
        oldWindows = driver.getWindowHandles();
    }

    private void openCountries() {
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'countries')]")).click();
    }

    private void loginAdmin() {
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    private void openAdmin() {
        driver.navigate().to("http://localhost/litecart/admin/");
    }

    public ExpectedCondition<String> thereIsWindowOtherThan(final Set<String> oldWindows) {
       return new ExpectedCondition<String>(){
           public String apply(WebDriver driver){
               Set<String> handles = driver.getWindowHandles();
               handles.removeAll(oldWindows);
               return handles.size() > 0 ? handles.iterator().next():null;
           }
       };
    }

}
