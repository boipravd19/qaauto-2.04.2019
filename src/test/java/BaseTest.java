import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\darb\\Downloads\\chromedriver_win32/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
