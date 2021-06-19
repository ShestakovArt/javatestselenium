import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.*;

import java.util.HashMap;

public class SberbankInsuranceExampleStepsTest extends BaseSteps {

    MainSteps mainSteps = new MainSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    InsuranceTravelSteps insuranceTravelSteps = new InsuranceTravelSteps();
    ProductsTravelInsuranceSteps productsTravelInsuranceSteps= new ProductsTravelInsuranceSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Test
    @DisplayName("Сбербанк - страхование путешественников не все поля заполнены")
    public void exampleStepsTest(){
        testData.put("Фамилия(Застрахованные)", "Кабачков");
        testData.put("Имя(Застрахованные)", "Баклажан");
        testData.put("Дата рождения(Застрахованные)", "01.08.1988");
        testData.put("Фамилия(Страхователь)", "Тепличный");
        testData.put("Имя(Страхователь)", "Помидор");
        testData.put("Отчество(Страхователь)", "Патисонович");
        testData.put("Дата рождения(Страхователь)", "15.07.1997");
        testData.put("Серия паспорта(Страхователь)", "0958");
        testData.put("Номер паспорта(Страхователь)", "180621");
        testData.put("Дата выдачи(Страхователь)", "15.08.2017");
        testData.put("Кем выдан(Страхователь)", "УФМС России");

        mainSteps.selectMenuItem("Страхование");
        mainSteps.selectSubMenu("Все страховые программы");
        insuranceSteps.selectFilter("Путешествия");
        insuranceSteps.selectTitel("Страхование для путешественников");
        insuranceTravelSteps.checkPageTitle("Страхование путешественников");
        insuranceTravelSteps.buttonClick();

        productsTravelInsuranceSteps.amountInsuranceCoverage("Минимальная");
        productsTravelInsuranceSteps.buttonClick("Оформить");

        productsTravelInsuranceSteps.fillFields(testData);
        productsTravelInsuranceSteps.checkFillFields(testData);
        productsTravelInsuranceSteps.buttonClick("Продолжить");

        productsTravelInsuranceSteps.checkErrorMessageField("Мобильный телефон", "Поле не заполнено.");
        productsTravelInsuranceSteps.checkErrorMessageField("Электронная почта", "Поле не заполнено.");
        productsTravelInsuranceSteps.checkErrorMessageField("Повтор электронной почты", "Поле не заполнено.");
        productsTravelInsuranceSteps.checkError("При заполнении данных произошла ошибка");


    }
}
