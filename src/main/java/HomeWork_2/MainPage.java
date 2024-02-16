package HomeWork_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[7]/button[2]")
    private WebElement editButton;

    @FindBy(xpath = "/html/body/div/main/div/div/div[3]/div[2]/div/div[2]/div/form/div[1]/label/input")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[8]/button")
    private WebElement buttonSave;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[7]/button[1]")
    private WebElement keyButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void editingDummyFirstName(String newName){
        editButton.click();
        inputFirstName.sendKeys(newName);
        buttonSave.click();
    }

    public void dummyCredentials(){
        keyButton.click();
    }
}
