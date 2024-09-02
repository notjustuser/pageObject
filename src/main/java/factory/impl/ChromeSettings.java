package factory.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeSettings implements IChromeOptions {

    private final String remoteUrl = System.getProperty("remote.url", "http://193.104.57.173");

    @Override
    public WebDriver settings() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "true")));


        if (remoteUrl.startsWith("http")) {
            return new RemoteWebDriver(new URL(remoteUrl + "/wd/hub"), chromeOptions);
        }
        return new ChromeDriver(chromeOptions);
    }
}
