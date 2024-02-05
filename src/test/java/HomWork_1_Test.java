
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.time.Duration;
import java.util.List;

public class HomWork_1_Test extends TestElement{
    @BeforeAll
    static void initElement(){
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver();
        chromeOptions.addArguments("--start-maximized");// режим полного экрана
        //        chromeOptions.addArguments("--headless"); //неявная функция
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void startTest(){
        System.out.println("Начало теста");
    }
    @AfterEach
    void endTest(){
        System.out.println("Конец теста");
    }

    @Test
    void testAuthorization() throws InterruptedException {
        WebElement loginTest = driver.findElement(By.xpath("//*[@type='text']"));// через XPath
        WebElement pass = driver.findElement(By.xpath("//*[@type='password']"));// через XPath
//        WebElement usernameField = driver.findElement(By.cssSelector("form#login input[type='text']"));// через cssSelector
//        WebElement passwordField = driver.findElement(By.cssSelector("form#login input[type='password']"));// через cssSelector
//        WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));// через XPath
        WebElement button = driver.findElement(By.cssSelector("form#login button"));// через cssSelector
        loginTest.sendKeys(login);
        pass.sendKeys(password);
        button.click();
        List<WebElement> searchElement = driver.findElements(By.partialLinkText("GB202307470f77"));
        Assertions.assertEquals(searchElement.size(), 1);
        Thread.sleep(1000L);
        Assertions.assertEquals(driver.getCurrentUrl(),"https://test-stand.gb.ru/admin/student?page=1&limit=10");
    }

    @Test
    void creating_DummyTest() {
        WebElement button = driver.findElement(By.xpath("//*[@id='create-btn']"));
        button.click();
        List<WebElement> searchElement = driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div[2]/div/div[1]/h2/span"));
        Assertions.assertEquals(searchElement.size(),1);
    }

    @Test
    void inputNameAndLoginDummy() throws InterruptedException, IOException {
        WebElement firstName = driver.findElement(By.xpath("//*[@class='mdc-text-field__input']"));
        firstName.sendKeys("Sergey");
        WebElement loginDummy = driver.findElement(By.xpath("//*[@id=\"upsert-item\"]/div[5]/label/input"));
        File file = new File("C:\\Users\\serge\\Desktop\\Auto_test_web_seminar\\src\\test\\java\\uniqueLogin.txt");
        FileReader reader = new FileReader(file);
        int num;
        String s = "";
        while((num=reader.read())!=-1){
            s = s+((char)num);
        }
        num = Integer.valueOf(s);
        PrintWriter writer = new PrintWriter(file);
        writer.write(String.valueOf(num+1));
        writer.close();
        reader.close();
        String uniqueLogin = "Ser"+(num+1);
        loginDummy.sendKeys(uniqueLogin);
        WebElement buttonSAVE = driver.findElement(By.xpath("//*[@class=\"button mdc-button mdc-button--raised mdc-ripple-upgraded\"]"));
        buttonSAVE.click();
        Thread.sleep(2000L);
        buttonSAVE.click();
        Thread.sleep(2000L);
        List<WebElement> provided = driver.findElements(By.xpath("//*[@id=\"upsert-item\"]/div[5]/div"));
        Assertions.assertEquals(provided.size(),1);
    }

    @AfterAll
    static  void  closeApp(){
        driver.quit();
    }
}
