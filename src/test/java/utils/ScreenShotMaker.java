package utils;

import driver.manager.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker {

    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public static byte[] makeScreenShot() {
        byte[] screenshotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }

    public void makeFastScreenShot(String fileName) {
        File screenshotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File("screenshots" + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save screenshot at location " + fileName);
        }
    }

}