package pages;

import io.qameta.allure.Step;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertTrue;

public class InsuranceTravelPages extends BasePage{

    @FindBy(xpath = "//h1[@data-test-id = 'PageTeaserDict_header']")
    WebElement titelTravelPages;

    @FindBy(xpath = "//a[@data-test-id ='PageTeaserDict_button']")
    WebElement buttonApplyOnline;

    @Step("Получаем название страницы {0}")
    public String getTitelTravelPages (){
        return titelTravelPages.getText();
    }

    @Step ("Проверка титульного названия страницы")
    public void checkPageTitle (String expectedTitle){
        String actualTitle = getTitelTravelPages();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажимаем на кнопку \"Оформить онлайн\"")
    public void buttonClick (){
        buttonApplyOnline.click();
    }
}
