package pages;


import components.popups.SignInPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By authButtonLocator = By.xpath("//button[text()='Войти']");

    public SignInPopup clickAuthButton() {
        driver.findElement(authButtonLocator).click();
        return new SignInPopup(driver);
    }

//    public MainPage goToAboutMePage() {
//        clickAuthButton().popupShouldBeVisible();
//        SignInPopup.
//        return this;
//    }

}
