package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePageElementsSelenide {

    // Кнопка "Личный кабинет" в шапке сайта справа
    @FindBy(xpath = "//a[@href='/account']")
    public SelenideElement accountButton;

    // Кнопка "Войти в аккаунт" на главной странице
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']")
    public SelenideElement constructorAccountButton;

    // Кнопка перехода на Конструктор бургера
    @FindBy(xpath = "//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']")
    public SelenideElement constructorMenuButton;

    // Лого "Stellar burgers"
    @FindBy(className = "AppHeader_header__logo__2D0X2")
    public SelenideElement logo;

    // Заголовок конструктора "Соберите бургер"
    @FindBy(xpath = "//h1[@class='text text_type_main-large mb-5 mt-10']")
    public SelenideElement constructorMenuHeader;

    // Таб раздела "Булки"
    @FindBy(xpath = "//span[@class='text text_type_main-default' and text()='Булки']")
    public SelenideElement bunsTab;

    // Таб раздела "Соусы"
    @FindBy(xpath = "//span[@class='text text_type_main-default' and text()='Соусы']")
    public SelenideElement saucesTab;

    // Таб раздела "Начинки"
    @FindBy(xpath = "//span[@class='text text_type_main-default' and text()='Начинки']")
    public SelenideElement fillingsTab;

    // Активный таб
    @FindBy(xpath = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement currentTab;



    // Переход на страницу логинации
    public LoginPagesElementsSelenide login() {
        return page(LoginPagesElementsSelenide.class);
    }
}
