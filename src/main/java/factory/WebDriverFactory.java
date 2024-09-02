package factory;

import data.BrowserNameData;
import exceptions.BrowserNotSupportedException;
import factory.impl.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;

public class WebDriverFactory {

    private BrowserNameData browserNameData = BrowserNameData.valueOf(System.getProperty("browser").toUpperCase());

    public WebDriver create() throws MalformedURLException {
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
