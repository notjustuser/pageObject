package factory;

import data.BrowserNameData;
import exceptions.BrowserNotSupportedException;
import factory.impl.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public WebDriver create(BrowserNameData browserNameData) {
        switch (browserNameData) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
            }
            default: {
                throw new BrowserNotSupportedException(browserNameData);
            }
        }
    }
}
