package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.Android.AndroidArticlePageObject;

public class ArticlePageObjectFactory {
    public static AndroidArticlePageObject get(AppiumDriver driver){
        if (Platform.getInstance().IsAndroid()){
            return new AndroidArticlePageObject(driver);
        } else {
            return new AndroidArticlePageObject(driver);
        }
    }
}
