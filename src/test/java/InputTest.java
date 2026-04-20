import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputTest {

    @Test
    public void checkAddRemoveElement() {
        //Задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //options.addArguments("--headless");
        //определяем браузер с которым хотим работать
        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        //ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // открываем страницу с указаным url
        driver.get("https://the-internet.herokuapp.com/inputs");


        //4. Inputs - Проверить на возможность ввести различные цифровые и
        //нецифровые значения, используя Keys.ARROW_UP И
        //Keys.ARROW_DOWN
        driver.findElement(By.tagName("input")).sendKeys("10");
        String text = driver.findElement(By.xpath("input")).getAttribute("value");
        softAssert.assertEquals(text, "10");
        driver.findElement(By.tagName("input")).sendKeys("10");
        String text1 = driver.findElement(By.xpath("input")).getAttribute("value");
        softAssert.assertEquals(text1, "10");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String text2 = driver.findElement(By.xpath("input")).getAttribute("value");
        softAssert.assertEquals(text1, "11");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String text3 = driver.findElement(By.xpath("input")).getAttribute("value");
        softAssert.assertEquals(text1, "10");

        //закрываем браузер
        driver.quit();
        softAssert.assertAll();
    }
}
