package page.objects;

import assertions.AssertWebElement;
import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ScreenShotMaker;
import waits.WaitForElement;

import static waits.WaitForElement.waitUntilElementIsVisible;

public class TopMenuPage extends BasePage {

    Actions action = new Actions(DriverManager.getWebDriver());
    ScreenShotMaker screenShotMaker = new ScreenShotMaker();
    @FindBy(id = "uc-btn-accept-banner")
    private WebElement acceptBannerButton;

    @FindBy(css = "a[href='/mezczyzni-home/']")
    private WebElement manButton;

    @FindBy(css = "a[href='/odziez-meska/']>span")
    private WebElement clothesButton;

    @FindBy(css = "a[class][href='/odziez-meska-swetry-bluzy/']")
    private WebElement hoodieButton;

    @FindBy(css = "input[id='email-input']")
    private WebElement newsletterEmailButton;

    @FindBy(css = "label[for='category-2']")
    private WebElement maleFashionButton;

    @FindBy(css = "button[type='submit']")
    private WebElement saveMeButton;

    @FindBy(css = "div._5qdMrS._2hG8pA.tVhZiy.Wn-EjT._6sX1Gm > span")
    private WebElement messageNewsletterLabel;

    @Step("Click on Accept Banner Button")
    public TopMenuPage clickAcceptBannerButton() {
        screenShotMaker.makeFastScreenShot("1BannerButtonTest.png");
        WaitForElement.waitUntilElementIsVisible(acceptBannerButton);
        acceptBannerButton.click();
        log().info("Clicked on Accept Banner Button");
        return this;
    }

    @Step("Click on Man Button")
    public TopMenuPage clickManButton() {
        screenShotMaker.makeFastScreenShot("2ManButtonTest.png");
        WaitForElement.waitUntilElementIsVisible(manButton);
        manButton.click();
        log().info("Clicked on Man Button");
        return this;
    }

    @Step("Click on Clothes Button")
    public TopMenuPage clickClothesButton() {
        screenShotMaker.makeFastScreenShot("3ClothesButtonTest.png");
        try {
            WaitForElement.waitUntilElementIsVisible(clothesButton);
            action.moveToElement(clothesButton).clickAndHold().perform();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            clothesButton = DriverManager.getWebDriver().findElement(By.cssSelector("a[href='/odziez-meska/']>span"));
            action.moveToElement(clothesButton).clickAndHold().perform();
        }
        if (!clothesButton.isDisplayed()) {
            action.moveToElement(clothesButton).clickAndHold().perform();
        }
        log().info("Clicked on Clothes Button");
        return this;
    }

    @Step("Click on Hoodie Button")
    public TopMenuPage clickHoodieButton() {
        screenShotMaker.makeFastScreenShot("4HoodieButtonTest.png");
        WaitForElement.waitUntilElementIsClickable(hoodieButton);
        hoodieButton.click();
        log().info("Clicked on Hoodie Button");
        return this;
    }

    @Step("Click on Man Button")
    public TopMenuPage newsletterEmailButton() {
        action.moveToElement(newsletterEmailButton).perform();
        newsletterEmailButton.sendKeys("xyzxyzxyz@xyz.pl");
        log().info("Clicked on Man Button");
        return this;
    }

    @Step("Click on Man Button")
    public TopMenuPage maleFashionButton() {
        maleFashionButton.click();
        log().info("Clicked on Man Button");
        return this;
    }

    @Step("Click on Man Button")
    public TopMenuPage saveMeButton() {
        saveMeButton.click();
        log().info("Clicked on Man Button");
        return this;
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public TopMenuPage assertThatMessageNewsletterIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        waitUntilElementIsVisible(messageNewsletterLabel);
        AssertWebElement.assertThat(messageNewsletterLabel).isDisplayed().hasText(warningMessage);
        return this;
    }
}