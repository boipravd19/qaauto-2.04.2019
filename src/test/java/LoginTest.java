import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {

    @DataProvider
    public Object[][] validDataProvider() { //метод возвращает массив массивов - матрицу
        return new Object[][]{
                { "autodasha1@gmail.com", "Shchorsa77" },
                { "AUTOdasha1@gmail.com", "Shchorsa77" }
        };
    }
    @Test (dataProvider = "validDataProvider") //берем данные с дата провайдера

    public void successfulLoginTest(String userEmail, String userPassword) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\darb\\Downloads\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");//открыть сайт
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up ");//проверить этот текст

        LoginPage loginPage = new LoginPage(driver); // создать физически в памяти экземпляр класса в переменной
        //loginPage.login("autodasha1@gmail.com","Shchorsa77" ); // передали 2 параметра в классе login
        loginPage.login(userEmail, userPassword);

        // loginPage - переменная
        // LoginPage()  - новый класс
        // LoginPage - тип данных


        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "Home page is not loaded");
        homePage.clickOnProfileMenu();
        Assert.assertEquals(homePage.getUserNameTextDisplayed(),"dasha zakharchenko" );

        driver.quit();

    }

}


