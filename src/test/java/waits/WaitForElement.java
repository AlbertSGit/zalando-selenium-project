package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilVisibilityOfElementLocated(By element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitUntilVisibilityOfElementToBeSelected(By element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitUntilVisibilityOfElementPresence(By element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}