package HomeWork_3_Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class TestElement {
    static WebDriver driver;
    String login = "GB202307470f77";
    String password = "bd86adca8d";

    private void authorization(){
        Selenide.open("https://test-stand.gb.ru/login");
        driver = WebDriverRunner.getWebDriver();
    }
    @BeforeEach
    void startChromeDriver(){
        authorization();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    void endChromeDriver(){
//        driver.quit();
        Configuration.holdBrowserOpen = true;//оставляет открытым браузер
//        WebDriverRunner.closeWebDriver();// закрывает браузер
    }
}
