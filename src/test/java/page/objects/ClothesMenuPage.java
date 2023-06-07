package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import waits.WaitForElement;



public class ClothesMenuPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"collection_view_catalog-filters\"]/div[1]/div/div/button")
    private WebElement sortButton;

    @FindBy(css = "label[for='sorting-PRICE_ASC']")
    private WebElement cheapestPriceButton;

    @FindBy(css = "div[data-zalon-partner-target='true']>div:first-of-type>div:first-of-type")
    private WebElement firstClothLink;

    @Step("Click on Sort Button")
    public ClothesMenuPage clickSortButton() {
        WaitForElement.waitUntilVisibilityOfElementLocated(By.xpath("//*[@id=\"collection_view_catalog-filters\"]/div[1]/div/div/button"));
        sortButton.click();
        log().info("Clicked on Sort Button");
        return this;
    }

    @Step("Click on Cheapest Price Button")
    public ClothesMenuPage cheapestPriceButton() {
        WaitForElement.waitUntilElementIsClickable(cheapestPriceButton);
        cheapestPriceButton.click();
        log().info("Clicked on Cheapest Price Button");
        return this;
    }

    @Step("Click on First Cloth Link Button")
    public ClothesMenuPage firstClothLinkButton() {
        try{
            firstClothLink.click();
        }
        catch(StaleElementReferenceException staleElementReferenceException){
            firstClothLink = DriverManager.getWebDriver().findElement(By.cssSelector("div[data-zalon-partner-target='true']>div:first-of-type>div:first-of-type"));
            firstClothLink.click();
        }
        log().info("Clicked on First Cloth Link Button");
        return this;
    }

}
