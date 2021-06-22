import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import pages.InsurancePages;
import pages.InsuranceTravelPages;
import pages.MainPages;
import pages.ProductsTravelInsurancePages;
import steps.*;

import java.util.HashMap;

public class SberbankInsuranceExampleStepsTest extends BaseTest {

    MainPages mainSteps = new MainPages();
    InsurancePages insuranceSteps = new InsurancePages();
    InsuranceTravelPages insuranceTravelSteps = new InsuranceTravelPages();
    ProductsTravelInsurancePages productsTravelInsuranceSteps= new ProductsTravelInsurancePages();

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

        mainSteps.selectMainMenu("Страхование");
        mainSteps.selectSubMenu("Все страховые программы");
        insuranceSteps.selectFilter("Путешествия");
        insuranceSteps.selectTitel("Страхование для путешественников");
        insuranceTravelSteps.checkPageTitle("Страхование путешественников");
        insuranceTravelSteps.buttonClick();

        productsTravelInsuranceSteps.amountInsuranceCoverage("Минимальнаа");
        productsTravelInsuranceSteps.buttonClick("Оформить");

        productsTravelInsuranceSteps.fillFields(testData);
        productsTravelInsuranceSteps.checkFillFields(testData);
        productsTravelInsuranceSteps.buttonClick("Продолжить");

        productsTravelInsuranceSteps.checkControlMessage("Мобильный телефон", "Поле не заполнено.");
        productsTravelInsuranceSteps.checkControlMessage("Электронная почта", "Поле не заполнено.");
        productsTravelInsuranceSteps.checkControlMessage("Повтор электронной почты", "Поле не заполнено.");
        productsTravelInsuranceSteps.checkErrorMesage("При заполнении данных произошла ошибка");
    }
}
