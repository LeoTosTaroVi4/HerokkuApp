import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {

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
        driver.get("https://the-internet.herokuapp.com/typos");

        //5. Typos - Проверить соответствие параграфа орфографии  Локатор: By.tagName(“p”)

        for (int i = 0; i < 10; i++){
            driver.navigate().refresh();
            String text = driver.findElement(By.xpath("(//p)[2]")).getText();
            softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
            System.out.println(text);
        }




        //закрываем браузер
        driver.quit();
        softAssert.assertAll();
    }
}
