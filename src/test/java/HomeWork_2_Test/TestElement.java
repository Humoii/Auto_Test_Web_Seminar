package HomeWork_2_Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class TestElement {
    static WebDriver driver;
    String login = "GB202307470f77";
    String password = "bd86adca8d";

    private void authorization(){
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        chromeOptions.addArguments("--start-maximized");// режим полного экрана
        //        chromeOptions.addArguments("--headless"); //неявная функция
        driver.get("https://test-stand.gb.ru/login");
    }
    @BeforeEach
    void startChromeDriver(){
        authorization();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    void endChromeDriver(){
        driver.quit();
    }
}
