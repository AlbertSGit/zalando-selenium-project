package page.objects;

import driver.listeners.TestListener;
import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import waits.WaitForElement;


@Listeners(TestListener.class)
public class TargetClothesPage extends BasePage {

    @FindBy(css = "span[class='ODGSbs _99qBVG gaJRiA BaerYO JCuRr_ KxHAYs _2kjxJ6 FxZV-M']")
    private WebElement chooseSizeButton;

    @FindBy(css = "div.F8If-J.mZoZK2.KLaowZ.hj1pfK._8n7CyI.JCuRr_ > div > form > div > div:nth-child(5) > div > label")
    private WebElement sizeClothesButton;

    @FindBy(css = "div[data-testid='pdp-add-to-cart']>button")
    private WebElement addToCartButton;

    @FindBy(css = "h2[id='pdp_size-reminder-dialog_title']")
    private WebElement itemSoldOutMessageLabel;
    @Step("Click on Choose Size Button")
    public TargetClothesPage clickChooseSizeButton() {
        WaitForElement.waitUntilElementIsVisible(chooseSizeButton);
        chooseSizeButton.click();
        log().info("Clicked on Choose Size");
        return this;
    }

    @Step("Click on Size Xxl Clothes Button")
    public TargetClothesPage clickSizeXxlClothesButton() {
        try{
            WaitForElement.waitUntilElementIsVisible(sizeClothesButton);
            sizeClothesButton.click();
            log().info("Clicked on Size Xxl Clothes");}
        catch (TimeoutException timeoutException){
            log().info("There is no size Xxl");
            throw new SkipException("Test is skipped");
        }
        catch (NoSuchElementException noSuchElementException){
            log().info("There is no size Xxl");
            throw new SkipException("Test is skipped");
}
        return this;
}

    @Step("Click on Add To Cart Button")
    public TargetClothesPage clickAddToCartButton() {
        try {
        WaitForElement.waitUntilElementIsVisible(addToCartButton);
        addToCartButton.click();
        log().info("Clicked on Add To Cart");}
        catch (ElementClickInterceptedException elementClickInterceptedException){
            itemSoldOutMessageLabel.isDisplayed();
        }
        return this;
    }

}
