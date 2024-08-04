package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class SearchPageObject extends MainPageObject {
    private static final String
            BUTTON_ELEMENT = "xpath://android.widget.Button[@resource-id='org.wikipedia:id/{SUBSTRING}']",
            SEARCH_INIT_ELEMENT = "xpath://androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']",
            SEARCH_PAGE_ELEMENT = "id:org.wikipedia:id/{SUBSTRING}",
            SEARCH_INPUT = "xpath://android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']",
            SEARCH_LINEARLAYOUT = "android.widget.LinearLayout",
            SEARCH_HEADER_TEXTVIEW = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/primaryTextView']",
            SEARCH_FIRST_ARTICLE = "android.view.ViewGroup",
            SEARCH_DESCRIPTION_AND_TITLE = "org.wikipedia:id/{SUBSTRING}",
            CHOICE_FIRST_ELEMENT = "xpath://androidx.recyclerview.widget.RecyclerView[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup[1]";

    public SearchPageObject(AppiumDriver driver){
        super(driver);
    }
    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    private static String getButtonElement(String substring){
        return BUTTON_ELEMENT.replace("{SUBSTRING}", substring);
    }
    private static String getPageElement(String substring){
        return SEARCH_PAGE_ELEMENT.replace("{SUBSTRING}", substring);
    }
    private static String getTitleAndDescriptionElement(String substring){
        return SEARCH_DESCRIPTION_AND_TITLE.replace("{SUBSTRING}", substring);
    }

    /*TEMPLATES METHODS */

    public void initSearchAndClickButton(String substring){
        String search_result_xpath = getButtonElement(substring);
        this.WaitForElementPresent(search_result_xpath, "Cannot find Skip button");
        this.WaitForElementAndClick(search_result_xpath, "Cannot find and click Skip button", 5);
    }

    public void initSearchInput(){
        this.WaitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.WaitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonToAppear(String substring){
        String search_result_id = getPageElement(substring);
        this.WaitForElementPresent(search_result_id, "Cannot find search cancel button !", 5);
    }

    public void SearchNameListElement(String substring, String s_text){
        String search_result_id = getPageElement(substring);
        this.GetSearchNameListElement(search_result_id, s_text);
    }

    public WebElement waitForPrimaryTextView(){
        WebElement element =  this.WaitForElementPresent(SEARCH_HEADER_TEXTVIEW, "PrimaryTextView for swipe not found", 5);
        return element;
    }

    public void waitForCancelButtonToDisappear(String substring){
        String search_result_id = getPageElement(substring);
        this.WaitForElementNotPresent(search_result_id, "Search cancel button is still present !", 5);
    }

    public void clickCancelSearch(String substring){
        String search_result_id = getPageElement(substring);
        this.WaitForElementAndClick (search_result_id, "Cannot find and click search cancel button", 5);
    }

    public void clickFirstFindElement(){
        this.WaitForElementAndClick (CHOICE_FIRST_ELEMENT, "Cannot find Search Wikipedia input", 5);
    }

    public int GetCountLinearLayoutElements(){
        return this.GetCountElementList(SEARCH_LINEARLAYOUT);
       // return this.GetCountElementList(By.className(SEARCH_LINEARLAYOUT));
    }

    public void GetFirstFindArticle(String s_text){
        this.GetAndClickFirstElementList(By.className(SEARCH_FIRST_ARTICLE), s_text);
    }

    public int GetCountElementsOnPage(String substring){
        String search_result_id = getPageElement(substring);
        return this.GetCountElementList(search_result_id);
    }

    public void typeSearchLine(String search_line){
        this.WaitForElementAndSendKeys(
                SEARCH_INPUT,
                search_line,
                "Cannot find and type into serach input",
                5);
    }
    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.WaitForElementPresent(
                search_result_xpath,
                "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.WaitForElementAndClick (
                search_result_xpath,
                "Cannot find and click search result with substring " + substring, 10);
    }

    public boolean checkAssertElementHasText(String s_text){
        return this.assertElementHasText(SEARCH_INPUT, s_text);
    }
    public void waitForElementByTitleAndDescription(String s_id_title, String s_id_description, String s_title, String s_description){
        String s_search_title = getTitleAndDescriptionElement(s_id_title);
        String s_search_description = getTitleAndDescriptionElement(s_id_description);
        this.GetElementByTitleAndDescription(By.className(SEARCH_FIRST_ARTICLE), By.id(s_search_title),
                                             By.id(s_search_description),
                                             s_title,
                                             s_description);
    }

    public void swipeElementToLeft(WebElement element, String error_message) {

        Point location = element.getLocation();
        Dimension size = element.getSize();

        int left_x = location.getX();
        int right_x = left_x + size.getWidth();
        int upper_y = location.getY();
        int lower_y = upper_y + size.getHeight();
        int middle_y = upper_y + (size.getHeight() / 2);

        int start_x = right_x - 20;
        int end_x = left_x + 20;
        int start_y = middle_y;
        int end_y = middle_y;

        this.swipe(
                new Point(start_x, start_y),
                new Point(end_x, end_y),
                Duration.ofMillis(550)
        );
    }


    public void swipe(Point start, Point end, Duration duration) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.driver.perform(Arrays.asList(swipe));
    }
}
