package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

/**
 * Created by korotkovay on 29.11.2016.
 */
public class adminMenuTest extends TestBase {


    @Test
    public void testAdminMenu() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        String title;

        // Appearance
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'appearance')]")).click();

        // Template
        title = driver.findElement(By.xpath("//li[@id='doc-template']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-template']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        // Logotype
        title = driver.findElement(By.xpath("//li[@id='doc-logotype']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-logotype']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Catalog
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'catalog')]")).click();
        //Catalog
        title = driver.findElement(By.xpath("//li[@id='doc-catalog']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-catalog']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Product Groups
        title = driver.findElement(By.xpath("//li[@id='doc-product_groups']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-product_groups']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Option Groups
        title = driver.findElement(By.xpath("//li[@id='doc-option_groups']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-option_groups']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Manufacturers
        title = driver.findElement(By.xpath("//li[@id='doc-manufacturers']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-manufacturers']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Suppliers
        title = driver.findElement(By.xpath("//li[@id='doc-suppliers']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-suppliers']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Delivery Statuses
        title = driver.findElement(By.xpath("//li[@id='doc-delivery_statuses']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-delivery_statuses']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Sold out Statuses
        title = driver.findElement(By.xpath("//li[@id='doc-sold_out_statuses']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-sold_out_statuses']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Quantity Units
        title = driver.findElement(By.xpath("//li[@id='doc-quantity_units']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-quantity_units']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //CSV Import/Export
        title = driver.findElement(By.xpath("//li[@id='doc-csv']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-csv']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Countries
        title = driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'countries')]/span[2]")).getText();
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'countries')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Currencies
        title = driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'currencies')]/span[2]")).getText();
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'currencies')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Customers
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'customers')]")).click();
        //Customers
        title = driver.findElement(By.xpath("//li[@id='doc-customers']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-customers']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //CSV Import/Export
        title = driver.findElement(By.xpath("//li[@id='doc-csv']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-csv']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Newsletter
        title = driver.findElement(By.xpath("//li[@id='doc-newsletter']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-newsletter']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Geozones
        title = driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'geo_zones')]/span[2]")).getText();
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'geo_zones')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Languages
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'languages')]")).click();
        //Languages
        title = driver.findElement(By.xpath("//li[@id='doc-languages']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-languages']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Storage Encoding
        title = driver.findElement(By.xpath("//li[@id='doc-storage_encoding']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-storage_encoding']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Modules
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'modules')]")).click();
        //Background Jobs
        title = "Job Modules";
        driver.findElement(By.xpath("//li[@id='doc-jobs']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Customer
        title = "Customer Modules";
        driver.findElement(By.xpath("//li[@id='doc-customer']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Shipping
        title = "Shipping Modules";
        driver.findElement(By.xpath("//li[@id='doc-shipping']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Payment
        title = "Payment Modules";
        driver.findElement(By.xpath("//li[@id='doc-payment']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Order Total
        title = "Order Total Modules";
        driver.findElement(By.xpath("//li[@id='doc-order_total']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Order Success
        title = "Order Success Modules";
        driver.findElement(By.xpath("//li[@id='doc-order_success']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Order Action
        title = "Order Action Modules";
        driver.findElement(By.xpath("//li[@id='doc-order_action']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Orders
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'orders')]")).click();
        //Orders
        title = driver.findElement(By.xpath("//li[@id='doc-orders']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-orders']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Order Statuses
        title = driver.findElement(By.xpath("//li[@id='doc-order_statuses']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-order_statuses']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Pages
        title = driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'pages')]/span[2]")).getText();
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'pages')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Reports
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'reports')]")).click();
        //Monthly Sales
        title = driver.findElement(By.xpath("//li[@id='doc-monthly_sales']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-monthly_sales']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Most sold products
        title = driver.findElement(By.xpath("//li[@id='doc-most_sold_products']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-most_sold_products']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Most shopping customers
        title = driver.findElement(By.xpath("//li[@id='doc-most_shopping_customers']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-most_shopping_customers']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Settings
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'settings')]")).click();
        title = "Settings";
        //Store Info
        driver.findElement(By.xpath("//li[@id='doc-store_info']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Defaults
        driver.findElement(By.xpath("//li[@id='doc-defaults']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //General
        driver.findElement(By.xpath("//li[@id='doc-general']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Listings
        driver.findElement(By.xpath("//li[@id='doc-listings']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Images
        driver.findElement(By.xpath("//li[@id='doc-images']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Checkout
        driver.findElement(By.xpath("//li[@id='doc-checkout']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Advanced
        driver.findElement(By.xpath("//li[@id='doc-advanced']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Security
        driver.findElement(By.xpath("//li[@id='doc-security']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Slides
        title = driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'slides')]/span[2]")).getText();
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'slides')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Tax
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'tax')]")).click();
        //Tax Classes
        title = driver.findElement(By.xpath("//li[@id='doc-tax_classes']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-tax_classes']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Tax Rates
        title = driver.findElement(By.xpath("//li[@id='doc-tax_rates']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-tax_rates']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Translations
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'translations')]")).click();
        //Search Translations
        title = driver.findElement(By.xpath("//li[@id='doc-search']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-search']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //Scan Files
        title = "Scan Files For Translations";
        driver.findElement(By.xpath("//li[@id='doc-scan']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);
        //CSV Import/Export
        title = driver.findElement(By.xpath("//li[@id='doc-csv']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-csv']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //Users
        title = driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'users')]/span[2]")).getText();
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'users')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);

        //vQmods
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'vqmods')]")).click();
        //vQmods
        title = driver.findElement(By.xpath("//li[@id='doc-vqmods']//span")).getText();
        driver.findElement(By.xpath("//li[@id='doc-vqmods']/a")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), title);









    }
}
