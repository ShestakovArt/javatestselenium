//package steps;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.qameta.allure.Step;
//
//import java.util.concurrent.TimeUnit;
//
//public class BaseSteps {
//    private static WebDriver driver;
//
//    public static WebDriver getDriver(){
//        return driver;
//    }
//
//    @Before
//    public void startScenario(){
//        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver .get("http://www.sberbank.ru/ru/person");
//        driver .manage().window().maximize();
//        driver .manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//    }
//
//    @After
//    public static void afterMethod(){
//        driver .quit();
//    }
//
//}
