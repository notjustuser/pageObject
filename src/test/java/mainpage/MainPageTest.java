package mainpage;

import components.DropDownListComponent;
import components.popups.SignInPopup;
import data.BrowserNameData;
import data.IData;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AboutMePage;
import pages.MainPage;
import pages.PersonalAccountPage;
import utils.waiters.Waiter;


public class MainPageTest {
    private WebDriver driver;
    private Waiter waiter;
    BrowserNameData browserName = BrowserNameData.valueOf(System.getProperty("browser").toUpperCase());

    @BeforeEach
    public void setup() {
        driver = new WebDriverFactory().create(browserName);
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
        mainPage
                .clickAuthButton()
                .popupShouldBeVisible();

        new SignInPopup(driver)
                .authorize()
                .popupShouldNotBeVisible();

        new DropDownListComponent(driver, "Abra").clickLKButton();


        new PersonalAccountPage(driver).clickAboutMeButton();


        new AboutMePage(driver)
                .fullInput()
                .clickSaveButton();

        driver.quit();

        driver = new WebDriverFactory().create(browserName);
        new MainPage(driver).open("/");
        new MainPage(driver)
                .clickAuthButton()
                .popupShouldBeVisible();

        new SignInPopup(driver)
                .authorize()
                .popupShouldNotBeVisible();

        new DropDownListComponent(driver, "Abra").clickLKButton();
        new PersonalAccountPage(driver).clickAboutMeButton();

        new AboutMePage(driver).fullCheck()
                .clearContacts("")
                .clearContacts("-2")
                .clickSaveButton();
    }
}
