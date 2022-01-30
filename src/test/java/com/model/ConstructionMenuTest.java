package com.model;

import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ConstructionMenuTest {

    @Test
    public void constructorMenuSwitchToBunsWithBunsTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.saucesTab.click();
        sleep(500);
        homePage.bunsTab.click();
        Assert.assertEquals("Булки", homePage.bunsHeader.getText());
    }

    @Test
    public void constructorMenuSwitchToBunsWithSaucesTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.saucesTab.click();
        Assert.assertEquals("Соусы", homePage.saucesHeader.getText());
    }

    @Test
    public void constructorMenuSwitchToBunsWithFillingsTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.fillingsTab.click();
        Assert.assertEquals("Начинки", homePage.fillingsHeader.getText());
    }



}
