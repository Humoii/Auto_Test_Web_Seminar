package HomeWork_3_Test;

import HomeWork_3.LoginPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest extends TestElement {

    @Test
    void loginTest() throws InterruptedException {
        LoginPage loginPage = Selenide.page(LoginPage.class);

        loginPage.loginInSystem(login, password);

        SelenideElement nameLoginPage = $x("//*[@id=\"app\"]/main/nav/ul/li[3]/a[text()='Hello, '][text()='GB202307470f77']");
        Assertions.assertEquals(nameLoginPage.getText(),("Hello, GB202307470f77"));
    }

    @Test
    void negativeLoginTest(){
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem("","");

        SelenideElement searchElement = $x("//*[@id=\"app\"]/main/div/div/div[2]/p[1][text()=\"Invalid credentials.\"]");
        Assertions.assertEquals("Invalid credentials.", searchElement.getText());
    }

}
