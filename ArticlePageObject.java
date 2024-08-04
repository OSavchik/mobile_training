package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{
    private static final String
        TITLE = "xpath:(//android.widget.TextView[@text='JavaScript'])[1]";

    public ArticlePageObject(AppiumDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){
        return this.WaitForElementPresent(TITLE,
                "Cannot find article title on page !",
                15);
    }

    public String getArticleTitle(){
        WebElement  title_element = waitForTitleElement();
        String s = title_element.getText();
        return title_element.getText();
    }
}

