import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest { //наследуем Basetest


    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"autodasha1@gmail.com", "Shchorsa77", "HR"}
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void SearchResultTest(String userEmail, String userPassword, String searchTerm) throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not displayed");
        HomePage homePage = loginPage.login(userEmail, userPassword);

        SearchResults searchResults = homePage.search(searchTerm); //метод fillForms вернет новую страницу SearchResults
        Assert.assertTrue(searchResults.isSearchPageLoaded(), "Search page is not displayed");

        Assert.assertEquals(searchResults.getSearchResultsNumber(), 10, "Incorrect number of search results");

        List<String> searchResultList = searchResults.getSearchResultsText();
        for (String searchResult : searchResultList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term: " + searchTerm + " not found in: \n" + searchResult);
        }

    }

}



