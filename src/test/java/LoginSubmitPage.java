import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginSubmitPage {

    WebDriver driver;

    WebElement userPasswordFieldError;

    public LoginSubmitPage(WebDriver driver) {  //экземпляр класса LoginPage
        this.driver = driver; //
        initElements(); //метод класса
    }

    private void initElements() {
        userPasswordFieldError = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isUserEmailFieldError() {
        return userPasswordFieldError.isDisplayed();
    }
}