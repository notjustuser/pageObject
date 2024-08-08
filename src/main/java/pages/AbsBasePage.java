package pages;

import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import utils.AbsCommon;
import utils.waiters.Waiter;

public abstract class AbsBasePage extends AbsCommon {

    private String baseUrl = System.getProperty("main.page");

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public void open(String path) {
        path = !path.startsWith("/") ? "/" + path: path;
        driver.get(baseUrl);
    }

    public WebDriver setDriver() {
        driver = new WebDriverFactory().create();
     return driver;
     }
}
