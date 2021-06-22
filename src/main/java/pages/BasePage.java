package pages;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver = DriverManager.getDriver();

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public BasePage(){
        PageFactory.initElements(driver, this);
    }
}