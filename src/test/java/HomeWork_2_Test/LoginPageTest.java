package HomeWork_2_Test;

import HomeWork_2.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.List;

public class LoginPageTest extends TestElement{

    @BeforeEach
    void startChromeDriver(){
        authorization();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    void endChromeDriver(){
        driver.quit();
    }

    @Test
    void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInSystem(login, password);

        List<WebElement> searchElement = driver.findElements(By.partialLinkText("Hello, GB202307470f77"));
        System.out.println(searchElement);
        Assertions.assertEquals(searchElement.size(), 1);
        Thread.sleep(1000L);//явное ожидание для прогрузки страницы, иначи тест падает на проверке URL
        Assertions.assertEquals(driver.getCurrentUrl(),"https://test-stand.gb.ru/admin/student?page=1&limit=10");

    }

    @Test
    void negativeLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInSystem("", "");
        List<WebElement> searchElement = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1][text()=\"Invalid credentials.\"]"));
        Assertions.assertEquals(searchElement.size(), 1);

    }

}