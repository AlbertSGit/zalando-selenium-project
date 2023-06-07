package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.ClothesMenuPage;
import page.objects.TargetClothesPage;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.APPLICATION_URL;


public class ChooseItemToBasketTests extends TestBase {

    @TmsLink("ID-2")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of this test is to add to cart cheapest hoodie" +
            " and check if Cart has one add element")
    public void asNotLoggedInUserIAddClothesToCart() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickAcceptBannerButton()
                .clickManButton()
                .clickClothesButton()
                .clickHoodieButton();

        ClothesMenuPage clothesMenuPage = new ClothesMenuPage();
        clothesMenuPage
                .clickSortButton()
                .cheapestPriceButton()
                .firstClothLinkButton();

        TargetClothesPage targetClothesPage = new TargetClothesPage();
        targetClothesPage
                .clickChooseSizeButton()
                .clickSizeXxlClothesButton()
                .clickAddToCartButton();
    }

}
