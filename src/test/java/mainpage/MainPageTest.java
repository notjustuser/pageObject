package mainpage;

import components.DropDownListComponent;
import components.popups.SignInPopup;
import data.Person;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AboutMePage;
import pages.MainPage;
import pages.PersonalAccountPage;

import java.net.MalformedURLException;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        driver = new WebDriverFactory().create();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkContacts() throws MalformedURLException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open("/");
        mainPage
                .clickAuthButton()
                .popupShouldBeVisible();

        new SignInPopup(driver)
                .authorize()
                .popupShouldNotBeVisible();

        new DropDownListComponent(driver).clickLKButton();


        new PersonalAccountPage(driver).clickAboutMeButton();

        Person person = new Person("Abra", "Kadabra", "Abrum", "Kalabum", "20.12.20", "telegram", "https://t.me/durov", "vk", "https://vk.com/durov");
        new AboutMePage(driver)
                .fullInput(person)
                .clickSaveButton();

        driver.quit();

        driver = new WebDriverFactory().create();
        new MainPage(driver).open("/");
        new MainPage(driver)
                .clickAuthButton()
                .popupShouldBeVisible();

        new SignInPopup(driver)
                .authorize()
                .popupShouldNotBeVisible();

        new DropDownListComponent(driver).clickLKButton();
        new PersonalAccountPage(driver).clickAboutMeButton();

        new AboutMePage(driver).fullCheck(person)
                .clearContacts("")
                .clearContacts("-2")
                .clickSaveButton();
    }
}
