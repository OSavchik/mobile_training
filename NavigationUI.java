package lib.UI;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject{
    private static final String
        My_LIST_LINK = "";
    public NavigationUI(AppiumDriver driver){
        super(driver);
    }
    public void ClickMyLists(){
        this.WaitForElementAndClick(My_LIST_LINK,
                "Cannot Skip",
                5);
    }
}
