package com.model;

import com.UserOperations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class GoToMainPageTest {

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
    public void goToMainPageFromAccountWithConstructionMenuButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        sleep(2000);
        homePage.constructorMenuButton.click();
        Assert.assertEquals("Construction menu header is incorrect", "Соберите бургер",homePage.constructorMenuHeader.getText());
    }

    @Test
    public void goToMainPageFromAccountWithLogo() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.fillUserLogin(data.get("email"), data.get("password"));
        homePage.accountButton.click();
        sleep(2000);
        homePage.logo.click();
        Assert.assertEquals("Construction menu header is incorrect", "Соберите бургер",homePage.constructorMenuHeader.getText());
    }

}
