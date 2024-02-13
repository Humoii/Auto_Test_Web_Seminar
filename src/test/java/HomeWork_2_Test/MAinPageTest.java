//package HomeWork_2_Test;
//
//import HomeWork_2.LoginPage;
//import HomeWork_2.MainPage;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.io.*;
//import java.util.List;
//
//public class MAinPageTest extends TestElement{
//
//    @Test
//    void editingDummyFirstNameTest() throws IOException, InterruptedException {
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginInSystem(login, password);
//
//        File file = new File("C:\\Users\\serge\\Desktop\\Auto_test_web_seminar\\src\\test\\java\\HomeWork_2_Test\\firstName.txt");
//        FileReader reader = new FileReader(file);
//        int num;
//        StringBuilder s = new StringBuilder();
//        while((num=reader.read())!=-1){
//            s.append((char) num);
//        }
//        PrintWriter writer = new PrintWriter(file);
//        writer.write(s + "1");
//        String firstNameBeforeSaving = "Sergey"+s;
//        writer.close();
//        reader.close();
//        String firstNameSave = "Sergey"+s+1;
//        MainPage mainPage = new MainPage(driver);
//        mainPage.editingDummyFirstName("1");
//        List<WebElement> firstNameBefore = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[2][text()=\""+firstNameBeforeSaving+"\"]"));
//        Assertions.assertEquals(firstNameBefore.size(), 1);
//        List<WebElement> firstName = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div[1]/div[1]/table/tbody/tr[1]/td[2][text()=\""+firstNameSave+"\"]"));
//        Assertions.assertEquals(firstName.size(), 1);
//    }
//    @Test
//    void dummyCredentialsTest(){
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginInSystem(login, password);
//
//        MainPage mainPage = new MainPage(driver);
//        mainPage.dummyCredentials();
//        List<WebElement> dummyCredentialsTitle = driver.findElements(By.xpath("//*[@id=\"simple-title\"]"));
//        Assertions.assertEquals(dummyCredentialsTitle.size(), 1);
//        List<WebElement> loginCredentials = driver.findElements(By.xpath("//*[@id=\"simple-content\"][text()=\"Login: \"][text()=\"Ser15\"]"));
//        Assertions.assertEquals(loginCredentials.size(), 1);
//    }
//}
