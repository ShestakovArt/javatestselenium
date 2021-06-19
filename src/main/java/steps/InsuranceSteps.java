package steps;

import pages.InsurancePages;
import pages.MainPages;
import io.qameta.allure.Step;

public class InsuranceSteps {

    @Step("Выбран пункт фильтра {0}")
    public void selectFilter (String filterItem){
        new InsurancePages().selectFilter(filterItem);
    }

    @Step("Выбор продукта {0}")
    public void selectTitel (String filterItem){
        new InsurancePages().selectTitel(filterItem);
    }
}
