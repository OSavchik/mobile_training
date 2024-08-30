package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.UI.AuthorizationPageObject;
import lib.UI.SearchPageObject;
import lib.UI.MyListPageObject;
import lib.UI.factories.MyListPageObjectFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

import static lib.UI.MainPageObject.screenshot;

public class MyLIstTest extends CoreTestCase {
    private static final String
        login = "okssav",
        password = "Denis2002!";

    @Test
    @Features(value={@Feature(value = "Authorization"), @Feature(value = "add Article"), @Feature(value = "Delete Article") })
    @DisplayName("Work with watchlist")
    @Description("full cycle of passing through watchlist")
    @Step("Starting test watchlist")
    public void test_Ex17() {
        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        screenshot(MyListPageObject.takeScreenShot("Main Page wIKI") );
        Auth.clickMenuButton();
        screenshot(MyListPageObject.takeScreenShot("Menu Page") );
        MyListPageObject.InitNavigatorPage();
        Auth.clickAuthButton();
        screenshot(MyListPageObject.takeScreenShot("Auth Page") );
        MyListPageObject.InitLoginPage();
        Auth.enterLoginData(login, password);
        screenshot(MyListPageObject.takeScreenShot("Auth detail Page") );
        Auth.submitForm();
        screenshot(MyListPageObject.takeScreenShot("Login result Page") );

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchAndClickButton("fragment_onboarding_skip_button");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        screenshot(MyListPageObject.takeScreenShot("Search Panel"));

        if (SearchPageObject.checkAssertElementHasText("Java")) {
            for(int i=1; i <= 2; i++) {
                MyListPageObject.clickListElementByIndex(String.valueOf (i));
                screenshot(MyListPageObject.takeScreenShot("Choice and open article"));
                MyListPageObject.clickAndAddToWatchList();
                screenshot(MyListPageObject.takeScreenShot("add element in wachlist"));
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
                screenshot(MyListPageObject.takeScreenShot("delete element from wachlist"));
                Auth.clickMenuButton();
                MyListPageObject.OpenWatchList();
                int i_count_finish = MyListPageObject.GetCountElementsOnWatch();
                if (i_count_finish == i_count - 1) System.out.println("Watch element was deleted successful !!");
            }

        }

    }
}
