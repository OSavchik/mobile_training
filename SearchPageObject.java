package lib.UI;

import io.appium.java_client.MobileBy;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Arrays;

abstract public class SearchPageObject extends MainPageObject {
   protected static String
           BUTTON_ELEMENT,
           SEARCH_INIT_ELEMENT,
           SEARCH_PAGE_ELEMENT,
           SEARCH_INPUT,
           SEARCH_RESULT_BY_SUBSTRING_TPL,
           SEARCH_LINEARLAYOUT,
           SEARCH_HEADER_TEXTVIEW,
           SEARCH_FIRST_ARTICLE,
           SEARCH_DESCRIPTION_AND_TITLE,
           SEARCH_TEXT_VIEW,
           SEARCH_COUNT_ELEMENT,
           SEARCH_CLEAR_LIST_ELEMENT,
           SEARCH_ELEMENTS,
           CHOICE_TITLE_ELEMENT,
           CHOICE_INDEX_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver){
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

    private static String getTitleAndDescriptionIndexElement(String substring){
        return CHOICE_INDEX_ELEMENT.replace("{SUBSTRING}", substring);
    }


    /*TEMPLATES METHODS */

    public void initSearchAndClickButton(String substring){
        if(Platform.getInstance().IsAndroid()) {
            String search_result_xpath = getButtonElement(substring);
            this.WaitForElementPresent(search_result_xpath, "Cannot find Skip button");
            this.WaitForElementAndClick(search_result_xpath, "Cannot find and click Skip button", 5);
        }
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
        String search_result_id = "";
        if(Platform.getInstance().IsAndroid())  search_result_id = getPageElement(substring);
        if(Platform.getInstance().IsMW())  search_result_id = SEARCH_ELEMENTS;
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

    public void clickCLearListSearch(){
        this.WaitForElementAndClick (SEARCH_CLEAR_LIST_ELEMENT, "Cannot find and click search cancel button", 5);
    }

    public int GetCountLinearLayoutElements(){
        return this.GetCountElementList(SEARCH_LINEARLAYOUT);
    }

    public void GetFirstFindArticle(String s_text){
        this.GetAndClickFirstElementList(SEARCH_FIRST_ARTICLE, s_text);
       // this.GetAndClickFirstElementList(By.className(SEARCH_FIRST_ARTICLE), s_text);
    }

    public int GetCountElementsOnPage(String substring){
        String search_result_id = "";
        if(Platform.getInstance().IsAndroid())  search_result_id = getPageElement(substring);
        if(Platform.getInstance().IsMW())  search_result_id = SEARCH_COUNT_ELEMENT;
        return this.GetCountElementList(search_result_id);
    }

    public void typeSearchLine(String search_line){
        this.WaitForElementAndSendKeys(
                SEARCH_INPUT,
                search_line,
                "Cannot find and type into search input",
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


    public void clickIndexElement(String s){
        String search_result_id = getTitleAndDescriptionIndexElement(s);
        this.WaitForElementAndClick (search_result_id, "Cannot find Search Wikipedia input", 5);
    }

    public void waitForElementByMultipleTitleAndDescription(String s_id_title, String s_id_description, String[] s_array){
        String s_search_title = getTitleAndDescriptionElement(s_id_title);
        String s_search_description = getTitleAndDescriptionElement(s_id_description);
        int i = this.FindElementByArrayString(SEARCH_FIRST_ARTICLE, s_search_title,
                s_search_description,
                s_array);
        if (i != -1){
            i++;
            clickIndexElement(String.valueOf(i));
        }
    }

    public boolean checkAssertElementHasText(String s_text){
        return this.assertElementHasText(SEARCH_INPUT, s_text);
    }
    public void waitForElementByTitleAndDescription(String s_id_title, String s_id_description, String s_title, String s_description){
        String s_search_title = getTitleAndDescriptionElement(s_id_title);
        String s_search_description = getTitleAndDescriptionElement(s_id_description);
        this.GetElementByTitleAndDescription(SEARCH_FIRST_ARTICLE, s_search_title,
                s_search_description,
                s_title,
                s_description);
    }

    public void waitForElementByMultipleTitleAndDescriptionMW(int i_count, String[] s_array){
        int i = FindElementByArrayStringMW(CHOICE_TITLE_ELEMENT, CHOICE_INDEX_ELEMENT, i_count, s_array);
        if (i == -1)  System.out.println("NOT FOUND three matches by Title and description ");
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

    public void scrollTo(String text)
    {
        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
        element.click();
        System.out.println("RESULT");
    }

    protected void testSwipe(By by, String error_message) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = (int) (size.getWidth() * 0.25);
        int endY = startY;
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    }


}
