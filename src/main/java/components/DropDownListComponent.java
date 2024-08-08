package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.AbsCommon;

public class DropDownListComponent extends AbsCommon {

    private String name;

    public DropDownListComponent(WebDriver driver, String name) {
        super(driver);

        this.name = name;
    }

    private String hoverAbleLocatorTemplate = "//span[contains(text(),'%s')]";
    private By lkButtonLocator = By.linkText("Личный кабинет");

    public DropDownListComponent clickLKButton() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(String.format(hoverAbleLocatorTemplate, name))))
                .perform();
        driver.findElement(lkButtonLocator).click();

        return this;
    }
}
