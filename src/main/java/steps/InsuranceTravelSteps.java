package steps;

import io.qameta.allure.Step;
import pages.InsuranceTravelPages;

import static org.junit.Assert.assertTrue;

public class InsuranceTravelSteps {

    @Step("Получаем название страницы {0}")
    public void checkPageTitle (String expectedTitle){
        String actualTitle = new InsuranceTravelPages().getTitelTravelPages();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажимаем на кнопку \"Оформить онлайн\"")
    public void buttonClick (){
        new InsuranceTravelPages().buttonClick();
    }
}
