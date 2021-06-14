import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

// Задание №1.

public class SberbankInsuranceTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsuranceFieldNotFilled(){
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id = 'kitt-top-menu-8']/../a[contains(text(), 'Страхование')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Все страховые программы')]")).click();

        driver.findElement(By.xpath("//label[contains(text(), 'Путешествия')]")).click();
        driver.findElement(By.xpath("//div[@class='uc-full__item']//*[contains(text(), 'Страхование для путешественников')]")).click();

        assertEquals("Страхование путешественников", driver.findElement(By.xpath("//h1[@data-test-id = 'PageTeaserDict_header']")).getText());
        driver.findElement(By.xpath("//a[@data-test-id ='PageTeaserDict_button']")).click();

        assertEquals("Минимальная", driver.findElement(By.xpath("//fieldset[@class = 'no-offset non-border']//h3[@_ngcontent-c11]")).getText());
        driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]")).click();

        fillField(By.id("surname_vzr_ins_0"), "Автотестов");
        fillField(By.id("name_vzr_ins_0"), "Тест");
        fillField(By.id("birthDate_vzr_ins_0"), ("12.06.1990" + Keys.TAB));
        fillField(By.id("person_lastName"), "Селениумов");
        fillField(By.id("person_firstName"), "Автотест");
        fillField(By.id("person_middleName"), "Явович");
        fillField(By.id("person_birthDate"), ("21.01.1996" + Keys.TAB));

        Random random = new Random();
        int rand = random.nextInt(2);
        if (rand == 1) driver.findElement(By.xpath("//label[contains(text(), 'Женский')]")).click();

        fillField(By.id("passportSeries"), "1106");
        fillField(By.id("passportNumber"), "125811");
        fillField(By.id("documentDate"), ("21.01.2018" + Keys.TAB));
        fillField(By.id("documentIssue"), "УФМС России");

        assertEquals("Автотестов", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Тест", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("12.06.1990", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("Селениумов", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Автотест", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Явович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("21.01.1996", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1106", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("125811", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("21.01.2018", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("УФМС России", driver.findElement(By.id("documentIssue")).getAttribute("value"));

        driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]")).click();

        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//*[@name ='phone']//*[@class = 'invalid-validate form-control__message']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//*[@name ='email']//*[@class = 'invalid-validate form-control__message']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//*[@name ='repeatEmail']//*[@class = 'invalid-validate form-control__message']")).getText());
        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[@class ='alert-form alert-form-error']")).getText());
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    private void fillField(By locator, String str){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(str);
    }
}