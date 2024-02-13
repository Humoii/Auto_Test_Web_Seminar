package HomeWork_3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private  SelenideElement loginField = $x("//*[@type='text']");

    private  SelenideElement passwordFilde = $x("//*[@type='password']");

    private SelenideElement button = $x("//*[@type='submit']");//$x-xpath $-css $$-список колекции

    public void loginInSystem(String login, String password) {

        loginField.should(Condition.visible).sendKeys(login);
        passwordFilde.should(Condition.visible).sendKeys(password);
//        button.click();
        button.should(Condition.visible).click();// .should(Condition.visible)- ожидание на появление элемента
    }
}
