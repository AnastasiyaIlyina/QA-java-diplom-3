package com.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    private String email;
    private String password;
    private String name;
    private String incorrectPass;

    @Before
    public void beforeTest() {
        email = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        incorrectPass = RandomStringUtils.randomAlphabetic(5);
    }

    @Test
    public void userCanRegisteredStartAccountButton() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        RegistrationPagesElementsSelenide registrationPage = loginPage.register();
        homePage.accountButton.click();
        loginPage.goToRegistrationPageLink.click();
        registrationPage.fillUserRegistrationInfo(name, email, password);
        registrationPage.registerButton.click();
        loginPage.loginButton.shouldBe(visible, Duration.ofSeconds(2));
        loginPage.login(email, password);
        homePage.accountButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), name);
        loginPage.accountLogoutButton.click();
    }

    @Test
    public void userCanNotRegisteredWithWrongPassword() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        LoginPagesElementsSelenide loginPage = homePage.login();
        RegistrationPagesElementsSelenide registrationPage = loginPage.register();
        homePage.accountButton.click();
        loginPage.goToRegistrationPageLink.click();
        registrationPage.fillUserRegistrationInfo(name, email, incorrectPass);
        registrationPage.registerButton.click();
        Assert.assertEquals(registrationPage.notCorrectPassWarning.getText(), "Некорректный пароль");
    }
}
