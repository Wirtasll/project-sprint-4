package ru.qascooter.praktikumservices.pageobjects;

import com.codeborne.selenide.SelenideElement;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;

public class ScooterOrder {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //локатор кнопки "Заказать" наверху страницы
    //@FindBy(className = "Button_Button__ra12g")
    private final SelenideElement makeOrderByPageTopButton = $x(".//button[@class='Button_Button__ra12g']");
    //локатор кнопки "Заказать" в середине страницы
    //@FindBy(xpath = ".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']")
    private final SelenideElement makeOrderByPageMiddleButton = $x(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //локатор поля "Имя"
    //@FindBy(xpath = ".//input[@placeholder='* Имя']")
    private final SelenideElement nameField = $x(".//input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    //@FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private final SelenideElement surnameField = $x(".//input[@placeholder='* Фамилия']");
    //локатор поля Адрес
    //@FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private final SelenideElement addressField = $x(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля Телефон
    //@FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private final SelenideElement phoneField = $x(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор поля Станция метро
    //@FindBy(xpath = ".//input[@placeholder='* Станция метро']")
    private final SelenideElement stationField = $x(".//input[@placeholder='* Станция метро']");
    //локатор выбора станции
    //@FindBy(className = "select-search")
    private final SelenideElement selectedStation = $x(".//div[@class='select-search__select']");
    //локатор кнопки "Далее"
    //@FindBy(className = "Button_Middle__1CSJM")
    private final SelenideElement buttonNext = $x(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    //локатор поля "Когда привезти"
   // @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private final SelenideElement dataField = $x(".//input[@placeholder='* Когда привезти самокат']");
    //локатор поля срока аренды
    //@FindBy(xpath = ".//div[@class='Dropdown-placeholder']")
    private final SelenideElement buttonPeriodList = $x(".//div[@class='Dropdown-placeholder']");
    //локатор выпадающего списка
    //@FindBy(className = "Dropdown-menu")
    private final SelenideElement dropdownPeriodList = $x(".//div[@class='Dropdown-menu']");
    //локатор черного цвета самоката
    //@FindBy(id = "black")
    private final SelenideElement colorBlackField = $x(".//input[@id='black']");
    //локатор серого цвета самоката
    //@FindBy(id = "grey")
    private final SelenideElement colorGreyField = $x(".//input[@id='grey']");
    //локатор поля "Комментарий для курьера"
    //@FindBy(xpath = ".//input[@placeholder='Комментарий для курьера']")
    private final SelenideElement commentField = $x(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки Заказать на экране "Про аренду"
    //@FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")
    private final SelenideElement buttonOrderAboutRent = $x(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //локатор кнопки подтверждения заказа
    //@FindBy(xpath = ".//button[text()='Да']")
    private final SelenideElement buttonConfirmOrder = $x(".//button[text()='Да']");
    //локатор заголовка подтверждения заказа
    //@FindBy(className = "Order_ModalHeader__3FDaJ")
    private final SelenideElement orderTitle = $x(".//div[@class='Order_ModalHeader__3FDaJ]");



    //метод клика по верхней кнопке "Заказать"
    public void clickPageTopButton() {
        makeOrderByPageTopButton.click();
    }
    //метод клика на кнопку "Заказать" в середине экрана
    public void clickPageMiddleButton() {
        makeOrderByPageMiddleButton.click();
    }
    //метод заполнения полей формы
    public void setOrderFields(String name, String surname, String address, String phone) {
        nameField.setValue(name);
        surnameField.setValue(surname);
        addressField.setValue(address);
        phoneField.setValue(phone);
    }
    //метод клика на поле "Станция"
    public void clickStationInOrderForm() {
        stationField.click();
    }
    //метод клика на выбранную станцию
    public void clickSelectedStation(String station) {
        selectedStation.find(byText(station)).click();
    }
    //метод клика по кнопке "Далее"
    public void clickButtonNext() {
        buttonNext.click();
    }

    //метод клика по кнопке срока
    public void clickPeriodButtonOrderAboutRent() {
        buttonPeriodList.click();
    }
    //метод выбора срока аренды
    public void selectPeriodInOrderAboutRent(String period) {
        dropdownPeriodList.findAll(byText(period));
        dropdownPeriodList.click();
    }
    //метод выбора черного цвета самоката
    public void selectBlackColorOrderAboutRent() {
        colorBlackField.click();
    }
    //метод выбора серого цвета самоката
    public void selectGreyColorOrderAboutRent() {
        colorGreyField.click();
    }
    //метод заполнения полей формы аренды
    public void setOrderFieldsAboutRent (String data, String comment) {
        dataField.setValue(data).pressEnter();
        commentField.setValue(comment);
    }
    //метод клика на кнопку Заказать на форме аренды
    public void clickButtonOrderAboutRent() {
        buttonOrderAboutRent.click();
    }

    //метод клика по кнопке подтверждения заказа
    public void clickConfirmOrderButton() {
        buttonConfirmOrder.click();

    }
    //метод проверки заголовка "Заказ оформлен"
    public void orderTitleIsDisplayed() {
        orderTitle.shouldHave(text("Заказ оформлен"));
    }
}