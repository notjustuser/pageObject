package components.popups;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;

public class SignInPopup extends AbsBasePage implements IPopup {

    public SignInPopup(WebDriver driver) {
        super(driver);
    }

    private String email = System.getProperty("email");
    private String password = System.getProperty("password");

    private By signInPopupSelector = By.cssSelector("#__PORTAL__>div");
    private By emailInputBy = By.name("email");
    private By passwordInputBy = By.xpath("//input[@type='password']");
    private By signInButtonLocator = By.xpath("//div[text()='Войти']");

    @Override
    public void popupShouldNotBeVisible() {
        Assertions.assertTrue(
                waiter.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(signInPopupSelector)),
                "Sign in popup should not be visible"
        );
    }

    @Override
    public void popupShouldBeVisible() {
        Assertions.assertTrue(
                waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(signInPopupSelector)),
                "Sign in popup should be visible"
        );
    }

    public SignInPopup authorize() {
        WebElement inputEmail = driver.findElement(emailInputBy);
        inputEmail.sendKeys(email);

        WebElement inputPassword = driver.findElement(passwordInputBy);
        inputPassword.sendKeys(password);

        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();

        return this;
    }
}