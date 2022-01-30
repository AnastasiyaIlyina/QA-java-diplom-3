package com.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationTest {

    @Test
    public void userCanRegisteredStartAccountButton() {
        String email = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.goToRegistrationPageLink.click();
        homePage.fillUserRegistrationInfo(name, email, password);
        homePage.registerButton.click();
        sleep(1000);
        homePage.fillUserLogin(email, password);
        homePage.accountButton.click();
        Assert.assertEquals(homePage.accountUserNameInput.getValue(), name);
    }

    @Test
    public void userCanNotRegisteredWithWrongPassword() {
        String email = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        String password = "wrong";
        String name = RandomStringUtils.randomAlphabetic(10);
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.accountButton.click();
        homePage.goToRegistrationPageLink.click();
        homePage.fillUserRegistrationInfo(name, email, password);
        homePage.registerButton.click();
        sleep(1000);
        Assert.assertEquals(homePage.notCorrectPassWarning.getText(), "Некорректный пароль");
    }
}
