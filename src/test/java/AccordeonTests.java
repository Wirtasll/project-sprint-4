import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.qascooter.praktikumservices.pageobjects.Accordeon;
import ru.qascooter.praktikumservices.pageobjects.ScooterOrder;
import java.util.Arrays;
import java.util.Collection;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)


public class AccordeonTests {


    public SelenideElement questionLocator;
    public String expectedAnswer;

    // Конструктор для параметризованного теста
    public AccordeonTests(SelenideElement questionLocator, String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.expectedAnswer = expectedAnswer;
    }


    // Провайдер данных для параметризованного теста
    @Parameterized.Parameters
    public static Collection<Object[]> questionAnswerData() {
        //Accordeon mainPage = open(ScooterOrder.URL, Accordeon.class);
        return Arrays.asList(new Object[][]{
                {Accordeon.questionOneAboutCost, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {Accordeon.questionTwoAboutNumber, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {Accordeon.questionThreeAboutTime, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {Accordeon.questionFourAboutScooterToday, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {Accordeon.questionFiveAboutCharger, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {Accordeon.questionFiveAboutPeriodChange, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {Accordeon.questionSixAboutOrderCancel, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {Accordeon.questionSevenAboutMoscowRegions, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }



    @Test
    public void testQuestionAnswerMatch() {
        open(ScooterOrder.URL, Accordeon.class);
        String actualAnswer = Accordeon.getAnswerTextByQuestionLocator(questionLocator);
        assertEquals("Ответ не соответствует ожидаемому", expectedAnswer, actualAnswer);
    }


    WebDriver driver;
    @After
    public void tearDown() {
        driver.quit();
    }
}

