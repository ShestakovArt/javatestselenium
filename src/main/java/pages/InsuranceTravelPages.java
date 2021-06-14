package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.constant.Constable;

public class InsuranceTravelPages {

    @FindBy(xpath = "//h1[@data-test-id = 'PageTeaserDict_header']")
    WebElement titelTravelPages;

    @FindBy(xpath = "//a[@data-test-id ='PageTeaserDict_button']")
    WebElement buttonApplyOnline;

    public InsuranceTravelPages(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public Constable getTitelTravelPages (){
        return titelTravelPages.getText();
    }

    public void buttonClick (){
        buttonApplyOnline.click();
    }
}
