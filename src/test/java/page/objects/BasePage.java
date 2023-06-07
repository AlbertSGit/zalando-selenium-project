package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import tests.TestBase;

public abstract class BasePage {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    protected Logger log() {
        return logger;
    }


}