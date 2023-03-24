package Pages;
import Consts.Consts;


public class MainPage_LogInPage extends BasePage {
    private static final String LOGO_IMG = "//img[@src = '/img/site_bg.jpg']";
    private static final String LOGIN_OPTION = "//a[@name = 'Log in/Register']";
    private static final String FIND_JOB_OPTION = "//a[@name = 'Find Job']";
    private static final String POST_JOB_OPTION = "//a[@name = 'Post Job']";
    private static final String ABOUT_US_OPTION = "//a[@name = 'About Us']";

    //Search jobs & location part.
    public static final String Location_TextBox = "//input[@placeholder = 'Location']";
    public static final String Submit_Button = "//a[text() = ' Submit ']";



    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoVisible() {
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public MainPage_LogInPage openLoginPage() {
        clickElementByXpath(LOGIN_OPTION);
        return new MainPage_LogInPage();
    }
    public FindJobPage openFindJobPage() {
        clickElementByXpath(FIND_JOB_OPTION);
        return new FindJobPage();
    }
    public PostJobPage openPostJobPage() {
        clickElementByXpath(POST_JOB_OPTION);
        return new PostJobPage();
    }
    public AboutUsPage openAboutUsPage() {
        clickElementByXpath(ABOUT_US_OPTION);
        return new AboutUsPage();
    }

}