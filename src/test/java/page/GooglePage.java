package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

    @FindBy(xpath = "//input[@name=\"q\"]")
    private WebElement searchInputField;


    public GooglePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsVisible(searchInputField, 5);
    }
    public boolean isPageLoaded (){
        return searchInputField.isDisplayed();
    }


    public GoogleSearchPage search(String searchWorld) {
        searchInputField.sendKeys(searchWorld);
        searchInputField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage(driver);
        }
}
