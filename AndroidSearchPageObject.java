package lib.UI.Android;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
    static{
                BUTTON_ELEMENT = "xpath://android.widget.Button[@resource-id='org.wikipedia:id/{SUBSTRING}']";
                SEARCH_INIT_ELEMENT = "xpath://androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']";
                SEARCH_PAGE_ELEMENT = "id:org.wikipedia:id/{SUBSTRING}";
                SEARCH_INPUT = "xpath://android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']";
                SEARCH_LINEARLAYOUT = "className:android.widget.LinearLayout";
                SEARCH_HEADER_TEXTVIEW = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/primaryTextView']";
                SEARCH_FIRST_ARTICLE = "className:android.view.ViewGroup";
                SEARCH_TEXT_VIEW = "className:android.widget.TextView";
                SEARCH_DESCRIPTION_AND_TITLE = "id:org.wikipedia:id/{SUBSTRING}";
                CHOICE_INDEX_ELEMENT = "xpath://androidx.recyclerview.widget.RecyclerView[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup[{SUBSTRING}]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }

}
