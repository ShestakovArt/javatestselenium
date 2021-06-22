package steps;

import pages.InsuranceTravelPages;
import pages.ProductsTravelInsurancePages;
import io.qameta.allure.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ProductsTravelInsuranceSteps {




    public void buttonClick (String value){
        new ProductsTravelInsurancePages().buttonClick(value);
    }




    public void fillField(String field, String value){
        new ProductsTravelInsurancePages().fillField(field, value);
    }




    public void checkErrorMessageField(String field, String value){
        new ProductsTravelInsurancePages().checkControlMessage(field, value);
    }


    public void checkError(String value){
        new ProductsTravelInsurancePages().checkErrorMesage(value);
    }
}
