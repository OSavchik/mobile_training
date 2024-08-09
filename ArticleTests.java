package tests;
import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.SearchPageObject;
import lib.UI.factories.ArticlePageObjectFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("High-level programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();
        assertEquals(
                "We see unexpected title",
                "JavaScript",
                article_title
        );
    }

    @Test
    public void testSwipeArticle_Ex5() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        int i_count = SearchPageObject.GetCountLinearLayoutElements();
        for (int i = 0; i < i_count; i++) {
            WebElement element = SearchPageObject.waitForPrimaryTextView();
            if (i < (i_count - 1)) SearchPageObject.swipeElementToLeft(element, "" );
        }
        SearchPageObject.initSearchAndClickButton("acceptButton");
    };

    @Test
    public void testScroll(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.scrollTo("platform");
    }

}
