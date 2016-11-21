import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by korotkovay on 21.11.2016.
 */
public class simpleTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void simpleTest() {
        driver.get("https://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("selenium - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}
