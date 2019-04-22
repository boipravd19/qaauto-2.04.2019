import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest {
    @Test
    public void DashaTest1 () {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\darb\\Downloads\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");//открыть сайт
        driver.manage().window().maximize();

        WebElement userEmailField  = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField  = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton  = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("autodasha1@gmail.com");
        userPasswordField.sendKeys("Shchor5sa77");
        signInButton.click();

        //div[@id='error-for-password']
        WebElement userPasswordFieldError  = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        Assert.assertTrue(userPasswordFieldError.isDisplayed(), "Hmm, that's not the right password. Please try again or request a new one.");
        driver.close();
    }

    @Test
    public void DashaTest2 () {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\darb\\Downloads\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");//открыть сайт
        driver.manage().window().maximize();

        WebElement userEmailField  = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField  = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton  = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("");
        userPasswordField.sendKeys("");
        signInButton.click();

        //input[@placeholder='Email']
        WebElement userEmailField1  = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userEmailFieldPlaceholder  = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/");
        driver.quit();
    }
}
