package components.popups;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbsCommon;

public class LibraryDescriptionPopup extends AbsCommon implements IPopup {

    public LibraryDescriptionPopup(WebDriver driver) {
        super(driver);
    }

    private By popupLocator = By.xpath("");

    @Override
    public void popupShouldBeVisible() {
        Assertions.assertTrue(
                waiter.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(popupLocator)),
                "Description popup should not be visible"
        );
    }

    @Override
    public void popupShouldNotBeVisible() {
        Assertions.assertTrue(
                waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(popupLocator)),
                "Description popup should be visible"
        );
    }
}
