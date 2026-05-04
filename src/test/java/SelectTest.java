import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SelectTest {


    @Test
    public void checkDropdown() {
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
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //3. Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
        //Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что
        //он выбран
        //Локатор: By.id(“dropdown”)

        Select select = new Select(driver.findElement(By.id("dropdown"))) ;

        //Первый элемент по умолчанию
        WebElement option = select.getFirstSelectedOption();
        String currentText = option.getText();
        softAssert.assertEquals(currentText, "Please select an option");

        //первая опция
        select.selectByIndex(1);
        boolean selectOption = Boolean.parseBoolean(driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).getAttribute("selected"));
        softAssert.assertTrue(selectOption);

        //Вторая опция
        select.selectByIndex(2);
        selectOption = Boolean.parseBoolean(driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).getAttribute("selected"));
        softAssert.assertTrue(selectOption);

        //закрываем браузер
        driver.quit();
        softAssert.assertAll();
    }
}