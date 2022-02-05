package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPagesElementsSelenide {

    // Поле ввода имени
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='name']")
    public SelenideElement registrationNameInput;

    // Поле ввода email (input этого поля полностью совпадает с полем ввода Имени)
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input")
    public SelenideElement registrationEmailInput;

    // Поле ввода пароля
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='Пароль']")
    public SelenideElement registrationPasswordInput;

    // Кнопка регистрации после заполнения полей пользователя
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement registerButton;

    // Ссылка перехода на страницу авторизации с формы регистрации
    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement switchFromRegistrationToLoginPageLink;

    // Предупреждение о Некорректном пароле
    @FindBy(xpath = "//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    public SelenideElement notCorrectPassWarning;

    // Заполнение полей информации о пользователе
    public void fillUserRegistrationInfo(String name, String email, String password) {
        registrationNameInput.setValue(name);
        registrationEmailInput.setValue(email);
        registrationPasswordInput.setValue(password);
    }
}
