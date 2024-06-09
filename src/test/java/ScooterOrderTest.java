import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.qascooter.praktikumservices.pageobjects.ScooterOrder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String date;
    private final String rentPeriod;
    private final String comment;

    // Конструктор для параметризованного теста
    public ScooterOrderTest(String firstName, String lastName, String address, String station, String phoneNumber, String date, String rentPeriod, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.comment = comment;
    }

    // Параметры для теста
    @Parameterized.Parameters
    public static List<Object[]> getTextData() {
        return List.of(
                new Object[]{"Докт","Минхауз", "За поворотом", "Сокольники", "+79999999999", "11.06.2024", "сутки", "Дароу!"},
                new Object[]{"Крот","Небесный", "Высоко на облаках", "Сокольники", "+71111111111", "12.06.2024", "двое суток", "Давай быстрее!"}
        );
    }

    WebDriver driver;
    // Тестовый метод для верхней кнопки
    @Test

    public void testPassedScooterOrderByPageTopButton() {
        ScooterOrder mainPageOrderByPageTopButton = open(ScooterOrder.URL, ScooterOrder.class);
        mainPageOrderByPageTopButton.clickPageTopButton();
        mainPageOrderByPageTopButton.setOrderFields(firstName, lastName, address, phoneNumber);
        mainPageOrderByPageTopButton.clickStationInOrderForm();
        mainPageOrderByPageTopButton.clickSelectedStation(station);
        mainPageOrderByPageTopButton.clickButtonNext();
        mainPageOrderByPageTopButton.clickPeriodButtonOrderAboutRent();
        mainPageOrderByPageTopButton.selectPeriodInOrderAboutRent(rentPeriod);
        mainPageOrderByPageTopButton.setOrderFieldsAboutRent(date, comment);
        mainPageOrderByPageTopButton.clickButtonOrderAboutRent();
        mainPageOrderByPageTopButton.clickConfirmOrderButton();
        mainPageOrderByPageTopButton.orderTitleIsDisplayed();
    }

    // Тестовый метод для нижней кнопки
    @Test

    public void testPassedScooterOrderByPageMiddleButton() {
        ScooterOrder mainPageOrderByPageMiddleButton = open(ScooterOrder.URL, ScooterOrder.class);
        mainPageOrderByPageMiddleButton.clickPageMiddleButton();
        mainPageOrderByPageMiddleButton.setOrderFields(firstName, lastName, address, phoneNumber);
        mainPageOrderByPageMiddleButton.clickStationInOrderForm();
        mainPageOrderByPageMiddleButton.clickSelectedStation(station);
        mainPageOrderByPageMiddleButton.clickButtonNext();
        mainPageOrderByPageMiddleButton.clickPeriodButtonOrderAboutRent();
        mainPageOrderByPageMiddleButton.selectPeriodInOrderAboutRent(rentPeriod);
        mainPageOrderByPageMiddleButton.setOrderFieldsAboutRent(date, comment);
        mainPageOrderByPageMiddleButton.clickButtonOrderAboutRent();
        mainPageOrderByPageMiddleButton.clickConfirmOrderButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPageOrderByPageMiddleButton.orderTitleIsDisplayed();
    }
    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
