package com.model;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class AuthenticationTest {

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
    public void userCanLoginBeginWithConstructorAccountButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        homePage.constructorAccountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }

    @Test
    public void userCanLoginBeginWithAccountButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        homePage.accountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }

    @Test
    public void userCanLoginBeginWithRegistrationForm() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        RegistrationPagesElementsSelenide registrationPage = loginPage.register();
        homePage.accountButton.click();
        loginPage.goToRegistrationPageLink.click();
        registrationPage.switchFromRegistrationToLoginPageLink.click();
        loginPage.login(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }

    @Test
    public void userCanLoginBeginWithPasswordRecoveryForm() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        homePage.accountButton.click();
        loginPage.goToPasswordRecoveryPageLink.click();
        loginPage.switchFromPassRecoveryToLoginPageLink.click();
        loginPage.login(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }
}
