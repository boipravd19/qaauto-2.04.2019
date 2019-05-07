import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResults {
    private WebDriver driver;
    private WebElement searchResultPage;
    private List<WebElement> searchResults;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        searchResults = driver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));
        searchResultPage = driver.findElement(By.xpath("//div[@class='search-results-container']"));
    }

    public int getSearchResultsNumber() {
        return searchResults.size();
    }



    public boolean isSearchPageLoaded() {
        return searchResultPage.isDisplayed();
    }

    public List<String> getSearchResultsText() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResultElement : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultList.add(searchResultText);
        }

        return searchResultList;
    }
}