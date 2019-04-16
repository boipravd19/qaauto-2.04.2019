import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\darb\\Downloads\\chromedriver_win32/chromedriver.exe");
        //new ChromeDriver(); - open new browser window//
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

}
