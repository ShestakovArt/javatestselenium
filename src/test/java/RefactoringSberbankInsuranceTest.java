import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.InsurancePages;
import pages.InsuranceTravelPages;
import pages.MainPages;
import pages.ProductsTravelInsurancePages;

import static org.junit.Assert.assertEquals;

public class RefactoringSberbankInsuranceTest extends BaseTest{

    @Test
    public void newTestInsuranceFieldNotFilled() {
        driver.get(baseUrl);
        MainPages mainPages = new MainPages(driver);
        mainPages.selectMainMenu("Страхование");
        mainPages.selectSubMenu("Все страховые программы");

        InsurancePages insurancePages = new InsurancePages(driver);
        insurancePages.selectFilter("Путешествия");
        insurancePages.selectTitel("Страхование для путешественников");

        InsuranceTravelPages insuranceTravelPages = new InsuranceTravelPages(driver);
        assertEquals("Страхование путешественников", insuranceTravelPages.getTitelTravelPages());
        insuranceTravelPages.buttonClick();

        ProductsTravelInsurancePages productsTravelInsurancePages = new ProductsTravelInsurancePages(driver);
        assertEquals("Минимальная", productsTravelInsurancePages.getTitelTravelPages());
        productsTravelInsurancePages.buttonClick("Оформить");

        productsTravelInsurancePages.fillField("Фамилия(Застрахованные)", "Летов");
        productsTravelInsurancePages.fillField("Имя(Застрахованные)", "Июнь");
        productsTravelInsurancePages.fillField("Дата рождения(Застрахованные)", "01.06.1999");
        productsTravelInsurancePages.fillField("Фамилия(Страхователь)", "Пухов");
        productsTravelInsurancePages.fillField("Имя(Страхователь)", "Лезий");
        productsTravelInsurancePages.fillField("Отчество(Страхователь)", "Вглазавович");
        productsTravelInsurancePages.fillField("Дата рождения(Страхователь)", "14.06.1991");
        productsTravelInsurancePages.randomGender();
        productsTravelInsurancePages.fillField("Серия паспорта(Страхователь)", "2122");
        productsTravelInsurancePages.fillField("Номер паспорта(Страхователь)", "140621");
        productsTravelInsurancePages.fillField("Дата выдачи(Страхователь)", "15.06.2012");
        productsTravelInsurancePages.fillField("Кем выдан(Страхователь)", "УФМС России");

        assertEquals("Летов", productsTravelInsurancePages.getFieldAttribute("Фамилия(Застрахованные)"));
        assertEquals("Июнь", productsTravelInsurancePages.getFieldAttribute("Имя(Застрахованные)"));
        assertEquals("01.06.1999", productsTravelInsurancePages.getFieldAttribute("Дата рождения(Застрахованные)"));
        assertEquals("Пухов", productsTravelInsurancePages.getFieldAttribute("Фамилия(Страхователь)"));
        assertEquals("Лезий", productsTravelInsurancePages.getFieldAttribute("Имя(Страхователь)"));
        assertEquals("Вглазавович", productsTravelInsurancePages.getFieldAttribute("Отчество(Страхователь)"));
        assertEquals("14.06.1991", productsTravelInsurancePages.getFieldAttribute("Дата рождения(Страхователь)"));
        assertEquals("2122", productsTravelInsurancePages.getFieldAttribute("Серия паспорта(Страхователь)"));
        assertEquals("140621", productsTravelInsurancePages.getFieldAttribute("Номер паспорта(Страхователь)"));
        assertEquals("15.06.2012", productsTravelInsurancePages.getFieldAttribute("Дата выдачи(Страхователь)"));
        assertEquals("УФМС России", productsTravelInsurancePages.getFieldAttribute("Кем выдан(Страхователь)"));

        productsTravelInsurancePages.buttonClick("Продолжить");

        productsTravelInsurancePages.checkControlMessage("Мобильный телефон", "Поле не заполнено.");
        productsTravelInsurancePages.checkControlMessage("Электронная почта", "Поле не заполнено.");
        productsTravelInsurancePages.checkControlMessage("Повтор электронной почты", "Поле не заполнено.");
        productsTravelInsurancePages.checkErrorMesage("При заполнении данных произошла ошибка");
    }
}