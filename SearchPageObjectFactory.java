package lib.UI.factories;

import lib.Platform;
import lib.UI.Android.AndroidSearchPageObject;
import lib.UI.SearchPageObject;
import lib.UI.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver){
        if(Platform.getInstance().IsAndroid()){
            return new AndroidSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}
