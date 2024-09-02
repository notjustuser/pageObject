package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.AbsCommon;

public class DropDownListComponent extends AbsCommon {

    public DropDownListComponent(WebDriver driver) {
        super(driver);
    }

    private  String profilePictureTemplate = "img[src='%s']";
    private String profilePictureSelector = String.format(profilePictureTemplate, "/_next/static/images/img/pink-owl-8e5a051ea32951df20c17b6479d3677f.png");
    private By lkButtonLocator = By.linkText("Личный кабинет");

    public DropDownListComponent clickLKButton() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(profilePictureSelector)))
                .perform();
        driver.findElement(lkButtonLocator).click();

        return this;
    }
}
