package com.model;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;


public class ConstructionMenuTest {

    @Before
    public void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void constructorMenuSwitchToBunsWithBunsTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.saucesTab.click();
        homePage.bunsTab.click();
        String actualCurrentTabText = homePage.currentTab.getText().trim();
        Assert.assertEquals("Булки", actualCurrentTabText);
    }

    @Test
    public void constructorMenuSwitchToBunsWithSaucesTab() {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.saucesTab.click();
        String actualCurrentTabText = homePage.currentTab.getText().trim();
        Assert.assertEquals("Соусы", actualCurrentTabText);
    }

    @Test
    public void constructorMenuSwitchToBunsWithFillingsTab() throws InterruptedException {
        HomePageElementsSelenide homePage = open("https://stellarburgers.nomoreparties.site/", HomePageElementsSelenide.class);
        homePage.fillingsTab.click();
        String actualCurrentTabText = homePage.currentTab.getText().trim();
        Assert.assertEquals("Начинки", actualCurrentTabText);
    }
}
