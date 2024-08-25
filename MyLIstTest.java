package tests;

import lib.CoreTestCase;
import lib.UI.AuthorizationPageObject;
import lib.UI.SearchPageObject;
import lib.UI.MyListPageObject;
import lib.UI.factories.MyListPageObjectFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyLIstTest extends CoreTestCase {
    private static final String
        login = "okssav",
        password = "Denis2002!";

    @Test
    public void test_Ex17() {
        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        Auth.clickMenuButton();
        MyListPageObject.InitNavigatorPage();
        Auth.clickAuthButton();
        MyListPageObject.InitLoginPage();
        Auth.enterLoginData(login, password);
        Auth.submitForm();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");


        if (SearchPageObject.checkAssertElementHasText("Java")) {
            for(int i=1; i <= 2; i++) {
                MyListPageObject.clickListElementByIndex(String.valueOf (i));
                MyListPageObject.clickAndAddToWatchList();
                if (i < 2) {
                    SearchPageObject.initSearchInput();
                    SearchPageObject.typeSearchLine("Java");
                }
            }
            Auth.clickMenuButton();
            MyListPageObject.OpenWatchList();
            int i_count = MyListPageObject.GetCountElementsOnWatch();
            if (i_count > 0 ) {
                MyListPageObject.clickAndDeleteToWatchList();
                Auth.clickMenuButton();
                MyListPageObject.OpenWatchList();
                int i_count_finish = MyListPageObject.GetCountElementsOnWatch();
                if (i_count_finish == i_count - 1) System.out.println("Watch element was deleted successful !!");
            }

        }

    }
}
