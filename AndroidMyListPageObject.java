package lib.UI.Android;

import lib.UI.MyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListPageObject {
    static{
        SEARCH_WATCH_BUTTON = "";
    }

    public AndroidMyListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
