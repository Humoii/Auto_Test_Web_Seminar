package HomeWork_3_Test;

import HomeWork_3.LoginPage;
import HomeWork_3.ProfilePage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePageTest extends TestElement{
    @Test
    void editingDateOfBirth() throws IOException {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem(login, password);

        ProfilePage profilePage = Selenide.page(ProfilePage.class);
        profilePage.goToProfile();
        profilePage.editing();
        File file = new File("C:\\Users\\serge\\Desktop\\Auto_test_web_seminar\\src\\test\\java\\HomeWork_3_Test\\uniqueDate.txt");
        FileReader reader = new FileReader(file);
        int num;
        StringBuilder uniqueDate = new StringBuilder();
        while((num=reader.read())!=-1){
            uniqueDate.append((char) num);
        }
        String date = String.valueOf(uniqueDate);
        date = String.valueOf(Integer.parseInt(date) + 1);
        PrintWriter writer = new PrintWriter(file);
        writer.write(date);
        writer.close();
        reader.close();

        String dateDM = "11.11.";
        String fullDate = dateDM + uniqueDate;
        profilePage.birthdate(fullDate);
        profilePage.save();
        profilePage.close();

        Selenide.sleep(1000L);
        SelenideElement dateOfBirth = $x("//*[@id=\"app\"]/main/div/div/div[1]/div/div[2]/div/div[2]/div[2]");
        Assertions.assertEquals(fullDate, dateOfBirth.getText());

    }
}
