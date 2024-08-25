package lib.UI.mobile_web;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static{
        BUTTON_ELEMENT = "xpath://android.widget.Button[@resource-id='org.wikipedia:id/{SUBSTRING}']";
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_PAGE_ELEMENT = "css:button.clear";
        SEARCH_INPUT = "css:input.search.mf-icon-search";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "css:.results li:nth-child({SUBSTRING}) a.cdx-button";
        SEARCH_LINEARLAYOUT = "className:android.widget.LinearLayout";
        SEARCH_HEADER_TEXTVIEW = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/primaryTextView']";
        SEARCH_FIRST_ARTICLE = "className:android.view.ViewGroup";
        SEARCH_TEXT_VIEW = "className:android.widget.TextView";
        SEARCH_DESCRIPTION_AND_TITLE = "id:org.wikipedia:id/{SUBSTRING}";
        CHOICE_TITLE_ELEMENT = "css:.mw-mf-page-list li:nth-child({SUBSTRING})";
        SEARCH_COUNT_ELEMENT = "css:.page-summary a.title";
        SEARCH_ELEMENTS = "css:.page-summary";
        SEARCH_CLEAR_LIST_ELEMENT = "css:.header-action button span.mf-icon.mf-icon-close";
    }

    public MWSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
