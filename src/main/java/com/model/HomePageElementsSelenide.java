package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementsSelenide {
    // Главная страница

    // Кнопка "Личный кабинет" в шапке сайта справа
    @FindBy(xpath = "//a[@href='/account']")
    public SelenideElement accountButton;

    // Кнопка "Войти в аккаунт" на главной странице
    @FindBy(xpath = "//main/section[2]/div/button")
    public SelenideElement constructorAccountButton;

    // Кнопка перехода на Конструктор бургера
    @FindBy(xpath = "//ul[@class='AppHeader_header__list__3oKJj']/li[1]/a")
    public SelenideElement constructorMenuButton;

    // Лого "Stellar burgers"
    @FindBy(className = "AppHeader_header__logo__2D0X2")
    public SelenideElement logo;

    // Заголовок конструктора "Соберите бургер"
    @FindBy(xpath = "//main[@class='App_componentContainer__2JC2W']/section[1]/h1")
    public SelenideElement constructorMenuHeader;



    // Раздел конструктор

    // Таб раздела "Булки"
    @FindBy(xpath = "//main[@class='App_componentContainer__2JC2W']/section[1]/div[1]/div[1]")
    public SelenideElement bunsTab;

    // Заголовок раздела "Булки"
    @FindBy(xpath = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[1]")
    public SelenideElement bunsHeader;

    // Таб раздела "Соусы"
    @FindBy(xpath = "//main[@class='App_componentContainer__2JC2W']/section[1]/div[1]/div[2]")
    public SelenideElement saucesTab;

    // Заголовок раздела "Соусы"
    @FindBy(xpath = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[2]")
    public SelenideElement saucesHeader;

    // Таб раздела "Начинки"
    @FindBy(xpath = "//main[@class='App_componentContainer__2JC2W']/section[1]/div[1]/div[3]")
    public SelenideElement fillingsTab;

    // Заголовок раздела "Начинки"
    @FindBy(xpath = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[3]")
    public SelenideElement fillingsHeader;


    // Страница авторизации

    // Поле ввода email для авторизации
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]/div/div/input")
    public SelenideElement loginEmailInput;

    // Поле ввода пароля для авторизации
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input")
    public SelenideElement loginPasswordInput;

    // Кнопка входа в аккаунт пользователя
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/button[text()='Войти']")
    public SelenideElement loginButton;

    // Ссылка перехода на форму регистрации
    @FindBy(xpath = "//a[@href='/register']")
    public SelenideElement goToRegistrationPageLink;

    // Ссылка перехода на форму восстановления пароля
    @FindBy(xpath = "//a[@href='/forgot-password']")
    public SelenideElement goToPasswordRecoveryPageLink;

    // Вход в личный кабинет пользователя с заполнением полей
    public void fillUserLogin(String email, String password) {
        loginEmailInput.setValue(email);
        loginPasswordInput.setValue(password);
        loginButton.click();
    }


    // Страница регистрации

    // Поле ввода имени
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]/div/div/input")
    public SelenideElement registrationNameInput;

    // Поле ввода email
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input")
    public SelenideElement registrationEmailInput;

    // Поле ввода пароля
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]/div/div/input")
    public SelenideElement registrationPasswordInput;

    // Кнопка регистрации после заполнения полей пользователя
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement registerButton;

    // Ссылка перехода на страницу авторизации с формы регистрации
    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement switchFromRegistrationToLoginPageLink;

    // Предупреждение о Некорректном пароле
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]/div/p")
    public SelenideElement notCorrectPassWarning;

    // Заполнение полей информации о пользователе
    public void fillUserRegistrationInfo(String name, String email, String password) {
        registrationNameInput.setValue(name);
        registrationEmailInput.setValue(email);
        registrationPasswordInput.setValue(password);
    }


    //Страница восстановления пароля

    // Ссылка перехода на страницу авторизации со страницы восстановления пароля
    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement switchFromPassRecoveryToLoginPageLink;


    //Страница Личного кабинета

    // Заполненное поле с именем пользователя
    @FindBy(xpath = "//ul[@class='Profile_profileList__3vTor']/li[1]/div/div/input")
    public SelenideElement accountUserNameInput;

    // Кнопка выхода из аккаунта
    @FindBy(xpath = "//ul[@class='Account_list__3KQQf mb-20']/li[3]/button")
    public SelenideElement accountLogoutButton;

}
