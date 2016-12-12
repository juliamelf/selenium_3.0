package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import testBase.TestBase;

/**
 * Created by korotkovay on 07.12.2016.
 */
public class litecartUserRegistrationTest extends TestBase{

    @Test
     public void testUserRegistration() {

        //open index page
        driver.navigate().to("http://localhost/litecart/");

        //go to registration page
        driver.findElement(By.xpath("//form//a[contains(@href, 'create_account')]")).click();

        //fill registration fields
        int userId = (int)(Math.random()*100);
        driver.findElement(By.name("firstname")).sendKeys("firstname" + userId);
        driver.findElement(By.name("lastname")).sendKeys("lastname" + userId);
        driver.findElement(By.name("address1")).sendKeys("Street 1");
        driver.findElement(By.name("postcode")).sendKeys("123456");
        driver.findElement(By.name("city")).sendKeys("City");

        driver.findElement(By.xpath("//span[contains(@id,'select')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'select')]")).sendKeys("Angola" + Keys.ENTER);

        String email = "email" + userId + "@mail.ru";
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+79991234556");
        String password = "test123456";
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);

        //confirm registration
        driver.findElement(By.name("create_account")).click();


        //logout
        driver.findElement(By.xpath("//div[@id='box-account']//a[contains(@href,'logout')]")).click();

        //login and logout
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//div[@id='box-account']//a[contains(@href,'logout')]")).click();

    }
}
