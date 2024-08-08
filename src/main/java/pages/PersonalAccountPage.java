package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends AbsBasePage{

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    private By aboutMeButton = By.linkText("О себе");

    public PersonalAccountPage clickAboutMeButton() {
        driver.findElement(aboutMeButton).click();
        return new PersonalAccountPage(driver);
    }
}
