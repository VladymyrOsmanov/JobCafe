import Pages.*;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Pages.MainPage_LogInPage.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainPage_LogInPageTest extends UseCaseBase {
    private static MainPage_LogInPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPage_LogInPageTest.class);

    @BeforeAll
    public static void classSetup(){ mainPage =new MainPage_LogInPage(); }
    @BeforeEach
    public void beforeTest(){ mainPage.navigateToMainPage(); }

    @Test
    public void mainPageLoadTest(){
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }
    @Test
    public void openLoginPageTest(){
        logger.info("Login page load test");
        MainPage_LogInPage mainPage_LogInPage = mainPage.openLoginPage();
        boolean isLoaded = mainPage_LogInPage.isLogoVisible();
        assertTrue(isLoaded);
    }
    @Test
    public void openFindJobPageTest(){
        logger.info("Find Job page load test");
        FindJobPage findJobPage = mainPage.openFindJobPage();
        boolean isLoaded = findJobPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
    @Test
    public void openPostJobPageTest(){
        logger.info("Post Job page load test");
        PostJobPage postJobPage = mainPage.openPostJobPage();
        boolean isLoaded = postJobPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
    @Test
    public void openAboutUsPageTest(){
        logger.info("About Us page load test");
        AboutUsPage aboutUsPage = mainPage.openAboutUsPage();
        boolean isLoaded = aboutUsPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    //Search for a location.
    @Test
    public void useLocationTextBox() throws InterruptedException {
        logger.info("Search for a location in the Location Text Box");
        //Find the element (text box).
        WebElement LocationTextBox =webDriver.findElement(By.xpath(Location_TextBox));
        assertNotNull(LocationTextBox);
        //Send the text to the element.
        LocationTextBox.sendKeys("Toronto, Tel-Aviv, Chicago, New-York");
        //Confirm that the element got the text.
        String textBoxAttribute = LocationTextBox.getAttribute("value") ;
        assertEquals("Toronto, Tel-Aviv, Chicago, New-York", textBoxAttribute);
        //Click on the Submit button.
        WebElement SubmitButton = webDriver.findElement(By.xpath(Submit_Button));
        Thread.sleep(3000);
        SubmitButton.click();
        // Give it a moment.
        Thread.sleep(3000);
        // The results list is displayed.
        boolean isLoaded = FindJobPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
}
