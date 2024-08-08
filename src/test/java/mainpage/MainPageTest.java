package mainpage;

import components.DropDownListComponent;
import components.popups.SignInPopup;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AboutMePage;
import pages.AbsBasePage;
import pages.MainPage;
import pages.PersonalAccountPage;
import utils.waiters.Waiter;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private Waiter waiter;

    @BeforeEach
    public void setup() {
        driver = new WebDriverFactory().create();
        waiter = new Waiter(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkContacts() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open("/");

        mainPage.clickAuthButton()
                .popupShouldBeVisible();

        SignInPopup signInPopup = new SignInPopup(driver);
        signInPopup.authorize()
                .popupShouldNotBeVisible();


        DropDownListComponent dropDownListComponent = new DropDownListComponent(driver, "Abra");
        dropDownListComponent.clickLKButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickAboutMeButton();

        AboutMePage aboutMePage = new AboutMePage(driver);
        aboutMePage.fullInput();
        aboutMePage.clickSaveButton();

        driver.quit();

        driver = new WebDriverFactory().create();
        mainPage.open("/");
        mainPage.clickAuthButton()
                .popupShouldBeVisible();

        signInPopup.authorize()
                .popupShouldNotBeVisible();

        dropDownListComponent.clickLKButton();
        personalAccountPage.clickAboutMeButton();
        aboutMePage.fullCheck();

        aboutMePage.clearContacts("Удалить", -1);
        aboutMePage.clearContacts("Удалить", -3);
        aboutMePage.clickSaveButton();
    }
}
