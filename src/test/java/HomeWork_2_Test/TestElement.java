package HomeWork_2_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class TestElement {
    static WebDriver driver;
    String login = "GB202307470f77";
    String password = "bd86adca8d";

    public  void authorization(){
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        chromeOptions.addArguments("--start-maximized");// режим полного экрана
        //        chromeOptions.addArguments("--headless"); //неявная функция
        driver.get("https://test-stand.gb.ru/login");
    }
}
