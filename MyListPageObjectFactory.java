package lib.UI.factories;

import lib.Platform;
import lib.UI.Android.AndroidMyListPageObject;
import lib.UI.MyListPageObject;
import lib.UI.mobile_web.MWListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory {
    public static MyListPageObject get(RemoteWebDriver driver){
        if(Platform.getInstance().IsAndroid()){
            return new AndroidMyListPageObject(driver);
        } else {
            return new MWListPageObject(driver);
        }
    }
}
