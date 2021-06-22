package util;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import managers.DriverManager;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure){
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
