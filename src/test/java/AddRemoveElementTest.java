import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddRemoveElementTest {

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
        driver.manage().window().maximize();
        //ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // открываем страницу с указаным url
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //ожидание

        //1. Add/Remove Elements - добавить 2 элемента, удалить элемент,проверить количество элементов DELETE
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        int size = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(size, 2);
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int size1 = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(size1, 1);
        //закрываем браузер
        driver.quit();
        softAssert.assertAll();
    }
}
