package lib.UI.Android;

import io.appium.java_client.AppiumDriver;
import lib.UI.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static{
        TITLE = "xpath:(//android.widget.TextView[@text='JavaScript'])[1]";
    }

    public AndroidArticlePageObject(AppiumDriver driver){
        super(driver);
    }
}
