package HomeWork_3_Test;

import HomeWork_3.LoginPage;
import HomeWork_3.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static com.codeborne.selenide.Selenide.$x;

public class MAinPageTest extends TestElement {

    @Test
    void editingDummyFirstNameTest() throws IOException{

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem(login, password);

        File file = new File("C:\\Users\\serge\\Desktop\\Auto_test_web_seminar\\src\\test\\java\\HomeWork_3_Test\\firstName.txt");
        FileReader reader = new FileReader(file);
        int num;
        StringBuilder s = new StringBuilder();
        while((num=reader.read())!=-1){
            s.append((char) num);
        }
        PrintWriter writer = new PrintWriter(file);
        writer.write(s + "1");
        String firstNameBeforeSaving = "Sergey"+s;
        writer.close();
        reader.close();
        String firstNameSave = "Sergey"+s+1;
        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.editingDummyFirstName("1");
        SelenideElement firstNameBefore = $x("//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[2][text()=\""+firstNameBeforeSaving+"\"]");
        Assertions.assertNotEquals(firstNameBefore.getText(),firstNameSave);
        SelenideElement firstName = $x("//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[2][text()=\""+firstNameSave+"\"]");
        Assertions.assertEquals(firstName.getText(), firstNameSave);
    }
    @Test
    void dummyCredentialsTest(){

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem(login, password);

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.dummyCredentials();

        SelenideElement dummyCredentialsTitle = $x("//*[@id=\"simple-title\"]");
        Assertions.assertEquals(dummyCredentialsTitle.should(Condition.visible).getText(),"Dummy credentials");
        SelenideElement loginCredentials = $x("//*[@id=\"simple-content\"][text()=\"Login: \"][text()=\"Ser15\"]");
        Assertions.assertEquals(loginCredentials.getText(), "Login: Ser15\n" + "PW: 8c4b7da4d9");
    }
}
