package tests;

import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }


    @Test
    public void testCancelSearch(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear("search_close_btn");
        SearchPageObject.clickCancelSearch("search_close_btn");
        SearchPageObject.waitForCancelButtonToDisappear("search_close_btn");
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("High-level programming language");
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult("High-level programming language");
    }

    @Test
    public void testSearchWiki_Ex2(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        if (SearchPageObject.checkAssertElementHasText("Java"))
            SearchPageObject.clickFirstFindElement();
    }

    @Test
    public void testSearchWikiList_Ex3(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        int i_count = SearchPageObject.GetCountElementsOnPage("page_list_item_title");
        if (i_count > 0) {
            SearchPageObject.clickCancelSearch("search_close_btn");
            i_count = SearchPageObject.GetCountElementsOnPage("page_list_item_title");
            if (i_count == 0) System.out.println("list items not found");
            else System.out.println("list items found and not reset");
        }
    }

    @Test
    public void testSearchWikiListAndSearchText_Ex4(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.SearchNameListElement("page_list_item_title", "Java");
    }

    @Test
    public void testAssertTitle_Ex6() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Title");
        String s_search_title = "Title";
        SearchPageObject.GetFirstFindArticle(s_search_title);
    }

    @Test
    public void testChangeScreenOrientationSearchResult_EX7() {
        driver.rotate(ScreenOrientation.PORTRAIT);

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("High-level programming language");

        ArticlePageObject ArticlePageObject =new ArticlePageObject(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenPortrait();
        String title_after_rotation = ArticlePageObject.getArticleTitle();
        assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
        this.rotateScreenLandscape();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();
        assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }
    @Test
    public void testTemplaterefactoring_Ex9() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForElementByTitleAndDescription( "page_list_item_title",
                "page_list_item_description",
                "Appium",
                "Roman");

    }

}
