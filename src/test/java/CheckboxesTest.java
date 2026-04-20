import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxesTest {

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
        driver.get("https://the-internet.herokuapp.com/checkboxes");


//        2. Checkboxes - проверить, что первый чекбокс unchecked, отметить
//        первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
//        checked, сделать unheck, проверить, что он unchecked

        driver.findElements(By.cssSelector("[type=checkbox]")).get(0);
        boolean isCheck = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        softAssert.assertFalse(isCheck);
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        isCheck = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        softAssert.assertTrue(isCheck);

        boolean isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        softAssert.assertTrue(isCheck2);
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        softAssert.assertFalse(isCheck2);

        //закрываем браузер
        driver.quit();
        softAssert.assertAll();
    }
}
