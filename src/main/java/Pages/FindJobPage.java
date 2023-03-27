package Pages;

public class FindJobPage extends BasePage {
    public static final String FIND_JOB_HEADER = "//h2[text()='Jobs']";

    //Filters.
    public static final String Position_Option = "//input[@name ='position']";
    public static final String Location_Option = "//input[@name = 'location']";
    public static final String Company_Option = "//input[@name ='company']";
    public static final String Search_Option = "//button[@class ='search-butom' and text() = 'search']";

    public static boolean isPageTitleVisible(){
        return elementExists(FIND_JOB_HEADER);
    }
    public static boolean isPositionTextBoxVisible(){ return elementExists(Position_Option); }
    public static boolean isLocationTextBoxVisible(){ return elementExists(Location_Option); }
    public static boolean isCompanyTextBoxVisible(){ return elementExists(Company_Option); }
}
