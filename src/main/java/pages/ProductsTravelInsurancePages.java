package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class ProductsTravelInsurancePages extends BasePage{

    @FindBy(xpath = "//fieldset[@class = 'no-offset non-border']//h3[@_ngcontent-c11]")
    WebElement titelTravelPages;

    @FindBy(xpath = "//button[contains(text(), 'Оформить')]")
    WebElement buttonApply;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surname_vzr;

    @FindBy(id = "name_vzr_ins_0")
    WebElement name_vzr;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDate_vzr;

    @FindBy(id = "person_lastName")
    WebElement person_lastName;

    @FindBy(id = "person_firstName")
    WebElement person_firstName;

    @FindBy(id = "person_middleName")
    WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    WebElement person_birthDate;

    @FindBy(xpath = "//label[contains(text(), 'Женский')]")
    WebElement person_gender;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    WebElement buttonContinue;

    @FindBy(name = "phone")
    WebElement modulePhone;

    @FindBy(name = "email")
    WebElement moduleEmail;

    @FindBy(name = "repeatEmail")
    WebElement moduleRepeatEmail;

    @FindBy(xpath = "//div[@class ='alert-form alert-form-error']")
    WebElement moduleErrorMessage;

    public ProductsTravelInsurancePages(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getTitelTravelPages (){
        return titelTravelPages.getText();
    }

    public void buttonClick (String buttonName){
        switch (buttonName){
            case("Оформить"):
                buttonApply.click();
                break;
            case ("Продолжить"):
                buttonContinue.click();
                break;
        }
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case("Фамилия(Застрахованные)"):
                fillField(surname_vzr, value);
                break;
            case("Имя(Застрахованные)"):
                fillField(name_vzr, value);
                break;
            case("Дата рождения(Застрахованные)"):
                fillField(birthDate_vzr, (value+ Keys.TAB));
                break;
            case("Фамилия(Страхователь)"):
                fillField(person_lastName, value);
                break;
            case("Имя(Страхователь)"):
                fillField(person_firstName, value);
                break;
            case("Отчество(Страхователь)"):
                fillField(person_middleName, value);
                break;
            case("Дата рождения(Страхователь)"):
                fillField(person_birthDate, (value+ Keys.TAB));
                break;
            case("Серия паспорта(Страхователь)"):
                fillField(passportSeries, value);
                break;
            case("Номер паспорта(Страхователь)"):
                fillField(passportNumber, value);
                break;
            case("Дата выдачи(Страхователь)"):
                fillField(documentDate, (value+ Keys.TAB));
                break;
            case("Кем выдан(Страхователь)"):
                fillField(documentIssue, value);
                break;
        }
    }

    public void randomGender() {
        Random random = new Random();
        int rand = random.nextInt(2);
        if (rand == 1) person_gender.click();
    }

    public String getFieldAttribute (String fieldName){
        String valueAttribute = new String();
        switch (fieldName){
            case("Фамилия(Застрахованные)"):
                valueAttribute = surname_vzr.getAttribute("value");
                break;
            case("Имя(Застрахованные)"):
                valueAttribute = name_vzr.getAttribute("value");
                break;
            case("Дата рождения(Застрахованные)"):
                valueAttribute = birthDate_vzr.getAttribute("value");
                break;
            case("Фамилия(Страхователь)"):
                valueAttribute = person_lastName.getAttribute("value");
                break;
            case("Имя(Страхователь)"):
                valueAttribute = person_firstName.getAttribute("value");
                break;
            case("Отчество(Страхователь)"):
                valueAttribute = person_middleName.getAttribute("value");
                break;
            case("Дата рождения(Страхователь)"):
                valueAttribute = person_birthDate.getAttribute("value");
                break;
            case("Серия паспорта(Страхователь)"):
                valueAttribute = passportSeries.getAttribute("value");
                break;
            case("Номер паспорта(Страхователь)"):
                valueAttribute = passportNumber.getAttribute("value");
                break;
            case("Дата выдачи(Страхователь)"):
                valueAttribute = documentDate.getAttribute("value");
                break;
            case("Кем выдан(Страхователь)"):
                valueAttribute = documentIssue.getAttribute("value");
                break;
        }
        return valueAttribute;
    }

    public void checkControlMessage(String nameField,String controlMessage){
        String checkField = new String();
        switch (nameField){
            case("Мобильный телефон"):
                checkField = modulePhone.findElement(By.xpath(".//*[@class = 'invalid-validate form-control__message']")).getText();
                break;
            case("Электронная почта"):
                checkField = moduleEmail.findElement(By.xpath(".//*[@class = 'invalid-validate form-control__message']")).getText();
                break;
            case("Повтор электронной почты"):
                checkField = moduleRepeatEmail.findElement(By.xpath(".//*[@class = 'invalid-validate form-control__message']")).getText();
                break;
        }
        assertEquals(controlMessage, checkField);
    }

    public void checkErrorMesage (String errorMessage){
        assertEquals(errorMessage, moduleErrorMessage.getText());
    }
}
