package steps;

import pages.MainPages;
import io.qameta.allure.Step;

public class MainSteps {

    @Step("Выбран пункт меню {0}")
    public void selectMenuItem (String mainMenu){
        new MainPages().selectMainMenu(mainMenu);
    }

    @Step("Выбран подпункт меню {0}")
    public void selectSubMenu (String mainMenu){
        new MainPages().selectSubMenu(mainMenu);
    }
}
