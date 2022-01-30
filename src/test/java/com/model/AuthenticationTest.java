package com.model;

import com.UserOperations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AuthenticationTest {

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
    public void userCanLoginBeginWithConstructorAccountButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.constructorAccountButton.click();
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(homePage.accountUserNameInput.getValue(), data.get("name"));
    }

    @Test
    public void userCanLoginBeginWithAccountButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(homePage.accountUserNameInput.getValue(), data.get("name"));
    }

    @Test
    public void userCanLoginBeginWithRegistrationForm() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.goToRegistrationPageLink.click();
        homePage.switchFromRegistrationToLoginPageLink.click();
        sleep(2000);
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(homePage.accountUserNameInput.getValue(), data.get("name"));
    }

    @Test
    public void userCanLoginBeginWithPasswordRecoveryForm() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.goToPasswordRecoveryPageLink.click();
        homePage.switchFromPassRecoveryToLoginPageLink.click();
        sleep(2000);
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(homePage.accountUserNameInput.getValue(), data.get("name"));
    }
}
