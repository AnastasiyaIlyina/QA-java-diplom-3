package com.model;

import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;


public class ConstructionMenuTest {

    @Test
    public void constructorMenuSwitchToBunsWithBunsTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.saucesTab.click();
        homePage.bunsTab.click();
        boolean result = homePage.bunsFocus.toString().contains("tab_tab_type_current");
        Assert.assertTrue(result);
    }

    @Test
    public void constructorMenuSwitchToBunsWithSaucesTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.saucesTab.click();
        boolean result = homePage.saucesFocus.toString().contains("tab_tab_type_current");
        Assert.assertTrue(result);
    }

    @Test
    public void constructorMenuSwitchToBunsWithFillingsTab() throws InterruptedException {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.fillingsTab.click();
        boolean result = homePage.fillingsFocus.toString().contains("tab_tab_type_current");
        Assert.assertTrue(result);
    }
}
