package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
    }
    public WebElement WaitForElementPresent(By by, String error_message, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement WaitForElementPresent(By by, String error_message){
        return WaitForElementPresent(by, error_message, 5);
    }
    public WebElement WaitForElementAndClick(By by, String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(by, error_message, 5);
        element.click();
        return element;
    }

    public WebElement WaitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(by, error_message, 5);
        element.sendKeys(value);
        return element;
    }

    public boolean WaitForElementNotPresent(By by, String error_message, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public WebElement WaitForElementAndClear(By by, String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public boolean assertElementHasText(By by, String s_text){
        boolean b_Search_Text = true;
        try {
            WebElement element = driver.findElement(by);
            String s_text_element = element.getText();
            if (s_text_element.contains(s_text)) {
                System.out.println("The element at this locator contains text " + s_text);
            } else {
                System.out.println("The element at this locator does not contains text " + s_text);
                b_Search_Text = false;
            }
        }
        catch (Exception e)
        {
            b_Search_Text = false;
            System.out.println(e.getMessage());
        }
        return b_Search_Text;
    }
    public int GetCountElementList(By by){
        int i_count_elements = 0;
        try {
            List<WebElement> ListElements   = driver.findElements(by);
            i_count_elements = ListElements.size();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return i_count_elements;
    }

    public void GetAndClickFirstElementList(By by, String s_text){
        try {
            List <WebElement> ListElements = driver.findElements(by);
            if (ListElements.size() == 0 )
                throw new AssertionError("Not found elements by locator "  + by.toString());
            else{
                ListElements.get(1).click();
                ListElements = driver.findElements(By.className("android.widget.TextView"));
                String s_TextElement = ListElements.get(0).getText() ;
                if (!s_TextElement.contains(s_text)){
                    String s_error_message = "Title not consist " + s_text;
                    throw new AssertionError(s_error_message);
                }
                else System.out.println( "TITLE " + s_text + " FOUND" );
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int GetSearchNameListElement(By by, String s_text){
        try {
            WebElement element = driver.findElement(by);
            String s_text_element = element.getText();
            List <WebElement> childrenElements   = driver.findElements(by);
            int count = 0;
            for(int i=0; i < childrenElements.size(); i++) {
                String s_TextElement = childrenElements.get(i).getText() ;
                if (s_TextElement.contains(s_text)) {
                    System.out.println("Element " + s_TextElement +" contains text " + s_text);
                } else {
                    System.out.println("Element " + s_TextElement +"does not contains text " + s_text);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int GetElementByTitleAndDescription(By byListArticle, By byTitle, By byDescription, String s_title, String  s_description){
        try {
            List <WebElement> childrenElements   = driver.findElements(byListArticle);
            if (childrenElements.size() == 0) System.out.println("NOT Title fount by " + byTitle.toString());
            int i_checkmatches = 0;
            for(int i=0; i < childrenElements.size(); i++) {
                List  <WebElement> childrenElements1 = childrenElements.get(i).findElements(byTitle);
                String s_TitleText = childrenElements1.get(0).getText();
                System.out.println(s_TitleText);
                childrenElements1 = childrenElements.get(i).findElements(byDescription);
                String s_DescriptionText = childrenElements1.get(0).getText();
                System.out.println(s_DescriptionText);
                if ((s_TitleText.contains(s_title))  & (s_DescriptionText.contains(s_description))) i_checkmatches ++;
            }
            if (i_checkmatches == 3) System.out.println("FOUND three matches by Title and description ");
            else System.out.println("NOT FOUND three matches by Title and description ");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public String waitForElementAndGetAttribute(By by,  String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getText() ;

    }

}
