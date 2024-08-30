package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.UI.SearchPageObject;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

import static lib.UI.MainPageObject.screenshot;

@Epic("Test for search")
public class SearchTests extends CoreTestCase {
    @Test
    @DisplayName("Search article by description")
    @Description("Search for found article by description - Object-oriented programming language")
    @Step("Starting test testSearch")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearch(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        screenshot(SearchPageObject.takeScreenShot("SearchPage") );
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("2");
        screenshot(SearchPageObject.takeScreenShot("Search Panel") );
    }

    @Test
    @Features(value={@Feature(value = "Search article"), @Feature(value = "Found Elements")})
    @DisplayName("Multiple search")
    @Description("Searching the input array")
    @Step("Starting testmultiplesearch")
    @Severity(value = SeverityLevel.MINOR)
    public void testmultiplesearchMW_Ex18() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        String s_Search = "java script";
        SearchPageObject.typeSearchLine(s_Search);
        String[] s_array = s_Search.split(" ");

        int i_count = SearchPageObject.GetCountElementsOnPage("");
        if (i_count > 0) {
            SearchPageObject.waitForElementByMultipleTitleAndDescriptionMW( i_count,  s_array);
        } else System.out.println("NOT FOUND ELEMENTS BY INPUT SEARCH " + s_Search);

    }

  /*   @Test
    public void testCancelSearch(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear("search_close_btn");
        SearchPageObject.clickCancelSearch("search_close_btn");
        SearchPageObject.waitForCancelButtonToDisappear("search_close_btn");
    }

@Test
    public void testCheckSearchArticleInBackground() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("High-level programming language");
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult("High-level programming language");
    }

    @Test
    public void testSearchWiki_Ex2(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        if (SearchPageObject.checkAssertElementHasText("Java"))
            SearchPageObject.clickIndexElement("1");
    }

    @Test
    public void testSearchWikiList_Ex3(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        int i_count = SearchPageObject.GetCountElementsOnPage("page_list_item_title");
        if (i_count > 0) {
            SearchPageObject.clickCLearListSearch();
            i_count = 0;
            i_count = SearchPageObject.GetCountElementsOnPage("page_list_item_title");
            if (i_count == 0) System.out.println("list items not found");
            else System.out.println("list items found and not reset");
        }
    }

    @Test
    public void testSearchWikiListAndSearchText_Ex4(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.SearchNameListElement("page_list_item_title", "Java");
    }

 /* @Test
    public void testAssertTitle_Ex6() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Title");
        String s_search_title = "Title";
        SearchPageObject.GetFirstFindArticle(s_search_title);
    }

    @Test
    public void testChangeScreenOrientationSearchResult_EX7() {
        driver.rotate(ScreenOrientation.PORTRAIT);

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("High-level programming language");

        ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenPortrait();
        String title_after_rotation = ArticlePageObject.getArticleTitle();
        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
        this.rotateScreenLandscape();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();
        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }
    @Test
    public void testTemplaterefactoring_Ex9() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForElementByTitleAndDescription( "page_list_item_title",
                "page_list_item_description",
                "Appium",
                "Roman");

    }



    @Test
    public void testmultiplesearch_Ex12() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        String s_Search = "skills task course";
        SearchPageObject.typeSearchLine(s_Search);
        String[] s_array = s_Search.split(" ");
        SearchPageObject.waitForElementByMultipleTitleAndDescription( "page_list_item_title",
                "page_list_item_description",
                s_array);
    }





   */


}
