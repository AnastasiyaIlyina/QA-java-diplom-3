package com.model;

import com.UserOperations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class AccountEnterTest {

    private UserOperations userOperations;
    private Map<String, String> data;

    @Before
    public void beforeTest() {
        userOperations = new UserOperations();
        data = userOperations.register();
    }

    @After
    public void afterTest() {
        userOperations.delete();
    }

    @Test
    public void userCanEnterAccountWithAccountButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        homePage.accountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }
}
