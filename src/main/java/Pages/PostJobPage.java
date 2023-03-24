package Pages;

public class PostJobPage extends BasePage{
    public static final String POST_JOB_HEADER = "//h2[text()='Post Job']";

    public boolean isPageTitleVisible(){
        return elementExists(POST_JOB_HEADER);
    }
}
