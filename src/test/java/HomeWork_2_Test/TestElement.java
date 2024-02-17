package HomeWork_2_Test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class TestElement {
    static WebDriver driver;
    String login = "GB202307470f77";
    String password = "bd86adca8d";

    private void authorization() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("121");
        capabilities.setCapability("enableVnc", true);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
        driver.get("https://test-stand.gb.ru/login");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new ChromeDriver(chromeOptions);
//        chromeOptions.addArguments("--start-maximized");// режим полного экрана
        //        chromeOptions.addArguments("--headless"); //неявная функция
    }
    @BeforeEach
    void startChromeDriver() throws MalformedURLException {
        authorization();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    void endChromeDriver(){
        driver.quit();
    }
}
