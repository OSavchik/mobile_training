package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
    }
    public WebElement WaitForElementPresent(String locator, String error_message, long timeoutInSeconds){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement WaitForElementPresent(String locator, String error_message){
        return WaitForElementPresent(locator, error_message, 5);
    }
    public WebElement WaitForElementAndClick(String locator, String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(locator, error_message, 5);
        element.click();
        return element;
    }

    public WebElement WaitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(locator, error_message, 5);
        element.sendKeys(value);
        return element;
    }

    public boolean WaitForElementNotPresent(String locator, String error_message, long timeoutInSeconds){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public WebElement WaitForElementAndClear(String locator, String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public boolean assertElementHasText(String locator, String s_text){
        By by = this.getLocatorByString(locator);
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
    public int GetCountElementList(String locator){
        By by = this.getLocatorByString(locator);
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

    public int GetSearchNameListElement(String locator, String s_text){
        By by = this.getLocatorByString(locator);
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

    public String waitForElementAndGetAttribute(String locator,  String error_message, long timeoutInSeconds){
        WebElement element = WaitForElementPresent(locator, error_message, timeoutInSeconds);
        return element.getText() ;

    }

    private By getLocatorByString(String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];
        if (by_type.equals("xpath")){
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Can not get type of locator " + locator_with_type);
        }
    }


}
