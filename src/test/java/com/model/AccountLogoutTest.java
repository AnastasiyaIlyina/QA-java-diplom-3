package com.model;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;


public class AccountLogoutTest {

    private UserOperations userOperations;
    private Map<String, String> data;

    @Before
    public void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized=true;
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
        loginPage.accountLogoutButton.click();
        Assert.assertEquals("Войти", loginPage.loginButton.getText());
    }

}
