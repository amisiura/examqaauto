package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends BasePage {



    @FindBy (xpath = "//h3[@class=\"LC20lb\"]")
    List<WebElement>  searchResults;

    @FindBy (xpath = "//a[@aria-label=\"Page 2\"]")
    WebElement linkToNextPage;

    @FindBy (xpath = "//div[@class=\"rc\"]")
    WebElement showResults;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsVisible(showResults, 5);
    }

    public boolean isPageLoaded (){
      return showResults.isDisplayed();
}

    public List<String>  getSearchResultsList(){
        List<String> searchListResultTexts = new ArrayList<String>();
        for (WebElement searchResult:searchResults){
            searchListResultTexts.add(searchResult.getText());
        }
        return searchListResultTexts;
}

    public int getListSize(){
        return searchResults.size();
    }

        public GoogleSearchPage toNextPage() {
            linkToNextPage.click();
            return new GoogleSearchPage(driver);
    }
}
