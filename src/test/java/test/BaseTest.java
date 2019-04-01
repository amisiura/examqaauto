package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GooglePage;

/** BaseTest is a kit of common action are used in each test
 *
 */
public class BaseTest {
    WebDriver driver;
    GooglePage googlePage;

    /**beforeTest does actions that are needed to be done before each test
     *
     */
    @BeforeMethod// задаем прекондишены
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\misiura_o\\IdeaProjects\\qaauto5022019\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); /* объявление переменной (имя - driver, тип - Webdriver) и задание значения - создание нового объекта хром драйвера, new - создание нового объекта */
        driver.get("https://www.google.com/");// переходим на заданную страницу
        googlePage = new GooglePage(driver);
    }

    /**afterTest does actions that are needed to be done after each test
     */
    @AfterMethod  // задаем посткондишены
    public void afterMethod()  {
        driver.quit();
    }

}
