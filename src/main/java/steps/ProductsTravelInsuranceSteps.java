package steps;

import pages.InsuranceTravelPages;
import pages.ProductsTravelInsurancePages;
import io.qameta.allure.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ProductsTravelInsuranceSteps {

    @Step("Выбираем сумму страховой защиты \"{0}\"")
    public void amountInsuranceCoverage (String expectedTitle){
        String actualTitle = new ProductsTravelInsurancePages().getTitelTravelPages();
        assertTrue(String.format("Сумма страховой защиты [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажимаем на кнопку \"{0}\"")
    public void buttonClick (String value){
        new ProductsTravelInsurancePages().buttonClick(value);
    }

    @Step("Заполняется поле")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("Поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new ProductsTravelInsurancePages().fillField(field, value);
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new ProductsTravelInsurancePages().getFieldAttribute(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value){
        new ProductsTravelInsurancePages().checkControlMessage(field, value);
    }

    @Step("На странице присутствует сообщение об ошибке {0}")
    public void checkError(String value){
        new ProductsTravelInsurancePages().checkErrorMesage(value);
    }
}
