package factory;

import exceptions.BrowserNotSupportedException;
import factory.impl.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private String browserName = System.getProperty("browser").toLowerCase();

    public WebDriver create() {
        switch (browserName) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
            }
            default: {
                throw new BrowserNotSupportedException(browserName);
            }
        }
    }
}
