package Pages;

public class FindJobPage extends BasePage {
    public static final String FIND_JOB_HEADER = "//h2[text()='Jobs']";

    public static boolean isPageTitleVisible(){
        return elementExists(FIND_JOB_HEADER);
    }
}
