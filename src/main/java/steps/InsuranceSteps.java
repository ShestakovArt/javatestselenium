package steps;

import pages.InsurancePages;
import pages.MainPages;
import io.qameta.allure.Step;

public class InsuranceSteps {


    public void selectFilter (String filterItem){
        new InsurancePages().selectFilter(filterItem);
    }


    public void selectTitel (String filterItem){
        new InsurancePages().selectTitel(filterItem);
    }
}
