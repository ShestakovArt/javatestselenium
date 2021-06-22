import managers.DriverManager;
import managers.TestProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver = DriverManager.getDriver();
    public static Properties properties = TestProperties.getInstance().getProperties();
    protected static String baseUrl;

    @BeforeClass
    public static void setUp() {
        baseUrl = "http://www.sberbank.ru/ru/person";
        DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        DriverManager.getDriver().quit();
    }

    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }

    private void assertEquals(String value, String value1) {
    }
}
