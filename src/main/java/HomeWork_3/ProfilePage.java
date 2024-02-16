package HomeWork_3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Date;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private SelenideElement helloClick = $x("//*[@class='svelte-1rc85o5 mdc-menu-surface--anchor']");
    private SelenideElement profileClick = $x("//*[@class='mdc-deprecated-list-item__text'][text()='Profile']");
    private SelenideElement editingClick = $x("//*[@title='More options']");
    private SelenideElement birthdateClick = $x("//*[@type='date'][1]");
    private SelenideElement saveButton = $x("//*[@form='update-item']");
    private SelenideElement closeButton = $x("//*[@data-mdc-dialog-action='close'][1]");
    public void goToProfile(){
        helloClick.should(Condition.visible).click();
        profileClick.should(Condition.visible).click();
    }
    public void editing(){
        editingClick.should(Condition.visible).click();
    }
    public  void birthdate (String date){
        birthdateClick.should(Condition.visible).sendKeys(String.valueOf(date));
    }
    public void save(){
        saveButton.should(Condition.visible).click();
    }
    public void close(){
        closeButton.should(Condition.visible).click();
    }
}
