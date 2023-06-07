package page.objects;

import assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waits.WaitForElement.waitUntilElementIsVisible;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='login.email']")
    private WebElement usernameField;

    @FindBy(css = "input[name='login.secret']")
    private WebElement passwordField;

    @FindBy(css = "button[data-testid='login_button']")
    private WebElement signOnButton;

    @FindBy(css = "span[class='goVnUa FxZV-M KxHAYs S3xARh _9bYLON DpImHu _3LATVU _3laWWw _3SrjVh']")
    private WebElement messageLabel;

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Typed into User Name Field {}", username);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public LoginPage clickOnLoginButton() {
        signOnButton.click();
        log().info("Clicked on Login Button");
        return this;
    }
    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }
}
