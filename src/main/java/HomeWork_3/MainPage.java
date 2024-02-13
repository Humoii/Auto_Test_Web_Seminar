package HomeWork_3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement editButton = $x("//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[7]/button[2]");

    private SelenideElement inputFirstName = $x("/html/body/div/main/div/div/div[3]/div[2]/div/div[2]/div/form/div[1]/label/input");

    private SelenideElement buttonSave = $x("//*[@id=\"upsert-item\"]/div[8]/button");

    private SelenideElement keyButton = $x("//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[7]/button[1]");

    public void editingDummyFirstName(String newName){
        editButton.click();
        inputFirstName.sendKeys(newName);
        buttonSave.should(Condition.visible).click();
    }

    public void dummyCredentials(){
        keyButton.should(Condition.visible).click();
    }
}
