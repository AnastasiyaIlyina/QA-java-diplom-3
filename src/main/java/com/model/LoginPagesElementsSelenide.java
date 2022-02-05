package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPagesElementsSelenide {

    // Поле ввода email для авторизации
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='name']")
    public SelenideElement loginEmailInput;

    // Поле ввода пароля для авторизации
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='Пароль']")
    public SelenideElement loginPasswordInput;

    // Кнопка входа в аккаунт пользователя
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']")
    public SelenideElement loginButton;

    // Ссылка перехода на форму регистрации
    @FindBy(xpath = "//a[@href='/register']")
    public SelenideElement goToRegistrationPageLink;

    // Ссылка перехода на форму восстановления пароля
    @FindBy(xpath = "//a[@href='/forgot-password']")
    public SelenideElement goToPasswordRecoveryPageLink;

    // Вход в личный кабинет пользователя с заполнением полей
    public void login(String email, String password) {
        loginEmailInput.setValue(email);
        loginPasswordInput.setValue(password);
        loginButton.click();
    }

    //Страница восстановления пароля

    // Ссылка перехода на страницу авторизации со страницы восстановления пароля
    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement switchFromPassRecoveryToLoginPageLink;


    //Страница Личного кабинета

    // Заполненное поле с именем пользователя
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default input__textfield-disabled' and @name='Name']")
    public SelenideElement accountUserNameInput;

    // Кнопка выхода из аккаунта
    @FindBy(xpath = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    public SelenideElement accountLogoutButton;

    // Переход на страницу регистрации
    public RegistrationPagesElementsSelenide register() {
        return page(RegistrationPagesElementsSelenide.class);
    }
}
