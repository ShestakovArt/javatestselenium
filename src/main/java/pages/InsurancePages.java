package pages;

import io.qameta.allure.Step;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePages extends BasePage {

    @FindBy (xpath = "//div[@aria-label='Фильтрация карт']")
    WebElement filter;

    @FindBy (xpath = "//div[@class='uc-full__item']")
    WebElement titelFilter;

    @Step("Выбран пункт фильтра {0}")
    public void selectFilter (String filterItem){
        filter.findElement(By.xpath(".//label[contains(text(), '" + filterItem + "')]")).click();
    }

    @Step("Выбор продукта {0}")
    public void selectTitel (String filterItem){
        titelFilter.findElement(By.xpath(".//*[contains(text(), '" + filterItem + "')]")).click();
    }
}
