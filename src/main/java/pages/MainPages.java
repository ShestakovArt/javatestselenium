package pages;

import io.qameta.allure.Step;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPages extends BasePage{

    @FindBy (xpath = "//ul[contains(@class, 'list_center')]")
    WebElement mainMenu;

    @FindBy (xpath = "//div[@id ='kitt-top-menu-8-5']/../../../../div[contains(@class, 'subaction')]/ul")
    WebElement subMenu;

    @Step("Выбран пункт меню {0}")
    public void selectMainMenu (String menuItem){
        mainMenu.findElement(By.xpath(".//a[@aria-label = '" + menuItem + "']")).click();
    }

    @Step("Выбран подпункт меню {0}")
    public void selectSubMenu (String menuItem){
        subMenu.findElement(By.xpath("./li/a[contains(text(), '" + menuItem + "')]")).click();
    }
}
