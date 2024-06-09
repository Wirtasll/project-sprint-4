package ru.qascooter.praktikumservices.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;


public class Accordeon {


    //локатор вопроса 1
    //@FindBy(id = "accordion__heading-0")
    public static SelenideElement questionOneAboutCost = $x(".//div[@id='accordion__heading-0']");
    //локатор текста ответа на 1 вопрос
   // @FindBy(id = "accordion__panel-0")
    public  SelenideElement answerOneAboutCost = $x(".//div[@id='accordion__panel-0']");
    //локатор вопроса 2
    //@FindBy(id = "accordion__heading-1")
    public static SelenideElement questionTwoAboutNumber = $x(".//div[@id='accordion__heading-1']");
    //локатор текста ответа на 2 вопрос
    //@FindBy(id = "accordion__panel-1")
    public  SelenideElement answerTwoAboutNumber = $x(".//div[@id='accordion__panel-1']");
    //локатор вопроса 3
    //@FindBy(id = "accordion__heading-2")
    public static SelenideElement questionThreeAboutTime = $x(".//div[@id='accordion__heading-2']");
    //локатор текста ответа на 3 вопрос
    //@FindBy(id = "accordion__panel-2")
    public SelenideElement answerThreeAboutTime = $x(".//div[@id='accordion__panel-2']");
    //локатор вопроса 4
   // @FindBy(id = "accordion__heading-3")
    public static SelenideElement questionFourAboutScooterToday = $x(".//div[@id='accordion__heading-3']");
    //локатор текста ответа на 4 вопрос
   // @FindBy(id = "accordion__panel-3")
    public SelenideElement answerFourAboutScooterToday = $x(".//div[@id='accordion__panel-3']");
    //локатор вопроса 5
   // @FindBy(id = "accordion__heading-4")
    public static SelenideElement questionFiveAboutPeriodChange = $x(".//div[@id='accordion__heading-4']");
    //локатор текста ответа на 5 вопрос
   // @FindBy(id = "accordion__panel-4")
    public SelenideElement answerFiveAboutPeriodChange = $x(".//div[@id='accordion__panel-4']");
    //локатор вопроса 6
  //  @FindBy(id = "accordion__heading-5")
    public static SelenideElement questionFiveAboutCharger = $x(".//div[@id='accordion__heading-5']");
    //локатор текста ответа на 6 вопрос
    //@FindBy(id = "accordion__panel-5")
    public SelenideElement answerFiveAboutCharger = $x(".//div[@id='accordion__panel-5']");
    //локатор вопроса 7
   // @FindBy(id = "accordion__heading-6")
    public static SelenideElement questionSixAboutOrderCancel = $x(".//div[@id='accordion__heading-6']");
    //локатор текста ответа на 7 вопрос
   // @FindBy(id = "accordion__panel-6")
    public SelenideElement answerSixAboutOrderCancel = $x(".//div[@id='accordion__panel-6']");
    //локатор вопроса 8
   // @FindBy(id = "accordion__heading-7")
    public static SelenideElement questionSevenAboutMoscowRegions = $x(".//div[@id='accordion__heading-7']");
    //локатор текста ответа на 8 вопросл
    //@FindBy(id = "accordion__panel-7")
    public SelenideElement answerSevenAboutMoscowRegions = $x(".//div[@id='accordion__panel-7']");



    //все методы клика на вопросы и получения текста ответов

    public void clickOnQuestionsAndHaveAnswersTexts() {
        questionOneAboutCost.scrollTo().click();
        answerOneAboutCost.shouldHave(text("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
        questionTwoAboutNumber.click();
        answerTwoAboutNumber.shouldHave(text("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
        questionThreeAboutTime.click();
        answerThreeAboutTime.shouldHave(text("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
        questionFourAboutScooterToday.click();
        answerFourAboutScooterToday.shouldHave(text("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
        questionFiveAboutPeriodChange.click();
        answerFiveAboutPeriodChange.shouldHave(text("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
        questionFiveAboutCharger.click();
        answerFiveAboutCharger.shouldHave(text("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
        questionSixAboutOrderCancel.click();
        answerSixAboutOrderCancel.shouldHave(text("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
        questionSevenAboutMoscowRegions.click();
        answerSevenAboutMoscowRegions.shouldHave(text("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }
    public static String getAnswerTextByQuestionLocator(SelenideElement questionLocator) {
        // Открываем вопрос, чтобы увидеть ответ
        questionLocator.click();
        // Текст ответа, который является следующим элементом после вопроса
        SelenideElement answer = questionLocator.sibling(0);
        return answer.text();
    }
}