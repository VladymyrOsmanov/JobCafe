import Pages.FindJobPage;
import Pages.MainPage_LogInPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Pages.FindJobPage.Location_Option;
import static Pages.FindJobPage.Search_Option;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigateToTheJobsPageTests extends UseCaseBase {
    private static MainPage_LogInPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPage_LogInPageTest.class);

    @BeforeAll
    public static void classSetup(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        mainPage =new MainPage_LogInPage(); }
    @BeforeEach
    public void beforeTest(){ mainPage.navigateToMainPage(); }

    @Test
    public void openFindJobPageTest(){
        logger.info("Find Job page load test");
        FindJobPage findJobPage = mainPage.openFindJobPage();
        boolean isLoaded = findJobPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
    @Test
    public void useLocationTextBox_Toronto() throws InterruptedException {
        logger.info("Search for a location in the Location Text Box");
        //Get to the Job page.
        FindJobPage findJobPage = mainPage.openFindJobPage();
        boolean isLoaded = findJobPage.isPageTitleVisible();
        assertTrue(isLoaded);
        //Find the element (text box).
        boolean isLocationTextBoxLoaded = FindJobPage.isLocationTextBoxVisible();
        assertTrue(isLocationTextBoxLoaded);
        WebElement LocationTextBox =webDriver.findElement(By.xpath(Location_Option));
        //Send the text to the element.
        LocationTextBox.sendKeys("Toronto");
        //Confirm that the element got the text.
        String textBoxAttribute = LocationTextBox.getAttribute("value") ;
        assertEquals("Toronto", textBoxAttribute);
        //Click on the Submit button.
        WebElement SearchButton = webDriver.findElement(By.xpath(Search_Option));
        Thread.sleep(2000);
        SearchButton.click();
        // Give it a moment.
        Thread.sleep(3000);
        // The results list is displayed.

    }
    @ParameterizedTest
    @ValueSource(strings = {"Toronto", "Tel Aviv", "Chicago", "New York"})
    public void useLocationTextBox_Parametrized(String location) throws InterruptedException {
        logger.info("Search for a location in the Location Text Box");
        //Get to the Job page.
        FindJobPage findJobPage = mainPage.openFindJobPage();
        boolean isLoaded = findJobPage.isPageTitleVisible();
        assertTrue(isLoaded);
        //Find the element (text box).
        boolean isLocationTextBoxLoaded = FindJobPage.isLocationTextBoxVisible();
        assertTrue(isLocationTextBoxLoaded);
        WebElement LocationTextBox = webDriver.findElement(By.xpath(Location_Option));
        //Send the text to the element.
        LocationTextBox.sendKeys(location);
        //Confirm that the element got the text.
        String textBoxAttribute = LocationTextBox.getAttribute("value");
        assertEquals(location, textBoxAttribute);
        //Click on the Submit button.
        WebElement SearchButton = webDriver.findElement(By.xpath(Search_Option));
        Thread.sleep(2000);
        SearchButton.click();
        // Give it a moment.
        Thread.sleep(3000);
        // The results list is displayed.
    }
}
