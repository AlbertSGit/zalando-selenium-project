package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class SubscriptionToTheNewsletterTests extends TestBase {

    @TmsLink("ID-3")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of this test is enter email join to the newsletter" +
            " and check if we signed up correctly")
    public void asNotLoggedInUserIAddClothesToCart() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickAcceptBannerButton()
                .newsletterEmailButton()
                .maleFashionButton()
                .saveMeButton();
        topMenuPage
                .assertThatMessageNewsletterIsDisplayed("Sprawdż swoją pocztę. Wysłaliśmy do Ciebie e-maila z prośbą o potwierdzenie Twojego adresu e-mail.");

    }


}
