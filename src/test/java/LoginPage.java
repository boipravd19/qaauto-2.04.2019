import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class LoginPage {

    //названия переменных, в которыми будем работать
    //1)
    private WebDriver driver;

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;
    private WebElement userEmailField1;
    private WebElement userEmailFieldPlaceholder;

    //2)
    public LoginPage (WebDriver driver){  //конструктор,экземпляр класса LoginPage, "драйвер" из теста
        this.driver = driver; // передать значение переменной "драйвер", "зис" - обратиться к переменной, которая объявлена именно в этом классе
        initElements(); //метод класса
    }

    //присваиваем переменным значения
    private void initElements () {
        userEmailField  = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField  = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton  = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userEmailField1 = driver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailFieldPlaceholder = driver.findElement(By.xpath("//input[@placeholder='Email']"));
    }

    public void login(String userEmail, String userPassword) { // to change parameters // ДЕЙСТВИЯ..вызываем метод при = new login
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();



        try {
            sleep(3000);
        } catch (InterruptedException e) { //ждать 3сек
            e.printStackTrace();
        }

    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().contains("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed();

        // get current url - у нас уже есть строка и мы хотим ее сравнить с
        // через  точку мы работаем с метолами этого объекта, //методы объекта класса String = тип данных


    }

}

