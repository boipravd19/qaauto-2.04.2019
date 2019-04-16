import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\darb\\Downloads\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");//открыть сайт
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up ");//проверить этот текст

        WebElement userEmailField  = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField  = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton  = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("autodasha1@gmail.com");
        userPasswordField.sendKeys("Shchorsa77");
        signInButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) { //ждать 3сек
            e.printStackTrace();
        }


        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        Assert.assertTrue(profileMenuItem.isDisplayed(), "Home page is not loaded");
        profileMenuItem.click();


        //li[contains(@class, "nav-settings__topcard")] - ищем в этом классе кучочек друг
        //ul[@id='nav-settings__dropdown-options']
        //ul[@id='nav-settings__dropdown-options']//h3 - нашли то, что находится под h3

        WebElement userNameText  = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
                Assert.assertEquals(userNameText.getText(), "dasha zakharchenko");
        driver.close();
    }

    @Test
    public void negativeLoginTest() {

    }

}

