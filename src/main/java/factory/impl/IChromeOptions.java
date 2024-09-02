package factory.impl;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IChromeOptions {
    WebDriver settings() throws MalformedURLException;
}
