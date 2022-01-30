package com.model;

import com.UserOperations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

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
        homePage.accountButton.click();
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(homePage.accountUserNameInput.getValue(), data.get("name"));
    }

}
