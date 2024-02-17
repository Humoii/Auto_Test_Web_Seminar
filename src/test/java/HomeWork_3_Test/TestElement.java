package HomeWork_3_Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

public abstract class TestElement {
    static WebDriver driver;
    String login = "GB202307470f77";
    String password = "bd86adca8d";

    private void authorization(){

        Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.browser = "firefox";
        Configuration.browser = "chrome";
//        Configuration.browserVersion = "121.0";
//        Configuration.browser = "opera";//TODO не работает OPERA .brawser
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
        Selenide.sleep(5000L);
//        driver.quit();
//        Configuration.holdBrowserOpen = true;//оставляет открытым браузер
//        WebDriverRunner.closeWebDriver();// закрывает браузер
    }

    public String uniqueDateFile (String pathFile) throws IOException {
        File file = new File(pathFile);
        FileReader reader = new FileReader(file);
        int num;
        StringBuilder uniqueDate = new StringBuilder();
        while ((num = reader.read()) != -1) {
            uniqueDate.append((char) num);
        }
        String date = String.valueOf(uniqueDate);
        date = String.valueOf(Integer.parseInt(date) + 1);
        PrintWriter writer = new PrintWriter(file);
        writer.write(date);
        writer.close();
        reader.close();
        return String.valueOf(uniqueDate);
    }
}
