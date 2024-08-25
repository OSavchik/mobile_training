package lib.UI.mobile_web;

import lib.UI.MyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWListPageObject  extends MyListPageObject {

    static{
        SEARCH_WATCH_BUTTON = "css:#ca-watch";
        OPEN_WATCH_LIST = "css:.minerva-icon.minerva-icon--watchlist";
        SEARCH_COUNT_WATCHLIST = "css:#mw-content-text a.cdx-button.cdx-button";
        SEARCH_FIRST_WATCH_ELEMENT = "xpath://*[@id=\"mw-content-text\"]/ul/li[1]/a[2]";
        SEARCH_LOGIN_PAGE = "css:.firstHeading";
        SEARCH_NAVIGATOR = "css:#p-navigation";
        SEARCH_ITEM_BY_INDEX = "xpath:/html/body/div[4]/div/div[2]/div/div[3]/div/ul/li[{SUBSTRING}]/a[1]";
    }

    public MWListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
