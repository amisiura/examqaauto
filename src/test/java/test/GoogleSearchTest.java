package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest{


    @Test
    public void googleSearchTest (){
        String searchWord ="selenium";
        Assert.assertTrue(googlePage.isPageLoaded(),"googlePage page is not loaded");

        GoogleSearchPage googleSearchPage = googlePage.search(searchWord);
        Assert.assertTrue(googleSearchPage.isPageLoaded(),"First searching page is not loaded");
        Assert.assertEquals(googleSearchPage.getListSize(),10,"Search results count is wrong");

        List<String> searchResultList = googleSearchPage.getSearchResultsList();

        for (String searchResult:searchResultList) {
            System.out.println("searchResult is :" + searchResult);
            Assert.assertTrue(searchResult.toLowerCase().contains(searchWord), "There is no string " + "'" + searchWord + "'" + " in the next string : " + searchResult);
        }

        googleSearchPage.toNextPage();
        Assert.assertTrue(googleSearchPage.isPageLoaded(),"Second searching page is not loaded");
        Assert.assertEquals(googleSearchPage.getListSize(),10,"Search results count is wrong");

        for (String searchResult:searchResultList) {
            System.out.println("searchResult is :" + searchResult);
            Assert.assertTrue(searchResult.toLowerCase().contains(searchWord), "There is no string " + "'" + searchWord + "'" + " in the next string : " + searchResult);
        }


    }
}
