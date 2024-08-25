package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListPageObject extends MainPageObject {
    protected static String
            SEARCH_WATCH_BUTTON,
            OPEN_WATCH_LIST,
            SEARCH_COUNT_WATCHLIST,
            SEARCH_FIRST_WATCH_ELEMENT,
            SEARCH_LOGIN_PAGE,
            SEARCH_NAVIGATOR,
            SEARCH_ITEM_BY_INDEX;

    public MyListPageObject(RemoteWebDriver driver){
        super(driver);
    }

    private static String getElementByIndex(String substring){
        return SEARCH_ITEM_BY_INDEX.replace("{SUBSTRING}", substring);
    }

    public void clickAndAddToWatchList(){
        this.WaitForElementAndClick (
                SEARCH_WATCH_BUTTON,
                "Cannot find and add element to watch list.", 10);

    }
    public void OpenWatchList(){
        this.WaitForElementPresent(OPEN_WATCH_LIST, "Cannot find button for open watch list");
        this.WaitForElementAndClick(OPEN_WATCH_LIST, "Cannot find and click button for open watch list", 5);
    }

    public int GetCountElementsOnWatch(){
        return this.GetCountElementByWatch(SEARCH_COUNT_WATCHLIST);
    }

    public void clickAndDeleteToWatchList(){
        this.WaitForElementAndClick (
                SEARCH_FIRST_WATCH_ELEMENT,
                "Cannot find and delete element from watch list.", 10);

    }

    public void InitLoginPage(){
        this.WaitForElementPresent(SEARCH_LOGIN_PAGE, "Cannot find Login page");
    }

    public void InitNavigatorPage(){
        this.WaitForElementPresent(SEARCH_NAVIGATOR, "Cannot find Navigator page");
    }

    public void clickListElementByIndex(String s){
        String search_result_id = getElementByIndex(s);
        this.WaitForElementAndClick (search_result_id, "Cannot find Search Wikipedia input", 5);
    }




}
