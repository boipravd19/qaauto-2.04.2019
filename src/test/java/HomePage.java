import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class HomePage {
    private WebDriver driver;
    private WebElement profileMenuItem;
    private WebElement userNameText;
    private WebElement searchField;
    
    public HomePage (WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        searchField = driver.findElement(By.xpath("//input[@aria-label='Search']")); //form@id=blabla]//input
    }

    public boolean isProfileMenuItemDisplayed (){
        return profileMenuItem.isDisplayed();

    }
    public void clickOnProfileMenu (){
        profileMenuItem.click();

    }

    public SearchResults search(String searchTerm) throws InterruptedException {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        sleep (3000);
        return new SearchResults(driver);

    }



    public String getUserNameTextDisplayed (){
        userNameText  = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
        return userNameText.getText();
    }
}


//        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
//        Assert.assertTrue(profileMenuItem.isDisplayed(), "Home page is not loaded");
//        profileMenuItem.click();
//
//
//        //li[contains(@class, "nav-settings__topcard")] - ищем в этом классе кучочек друг
//        //ul[@id='nav-settings__dropdown-options']
//        //ul[@id='nav-settings__dropdown-options']//h3 - нашли то, что находится под h3
//
//        WebElement userNameText  = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
//                Assert.assertEquals(userNameText.getText(), "dasha zakharchenko");
//        driver.close();