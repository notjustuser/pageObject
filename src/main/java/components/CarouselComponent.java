package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbsCommon;

public class CarouselComponent extends AbsCommon {

    private String name;

    public CarouselComponent(WebDriver driver, String name) {
        super(driver);

        this.name = name;
    }

    private String carouselComponentLocatorTemplate = "//section[./h2[text()='%s']]/div";
    private String carouselPrevButtonLocator = String.format("(/div/div)[1]", carouselComponentLocatorTemplate);
    private String carouselNextButtonLocator = String.format("(/div/div)[last()]", carouselComponentLocatorTemplate);

    public CarouselComponent prevButtonShouldNotBeClickable() {
        WebElement prevButton = driver.findElement(By.xpath(String.format(carouselPrevButtonLocator, name)));
        waiter.waitForCondition(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(prevButton)));

        return this;
    }

    public CarouselComponent prevButtonShouldBeClickable() {
        WebElement prevButton = driver.findElement(By.xpath(String.format(carouselPrevButtonLocator, name)));
        waiter.waitForCondition(ExpectedConditions.elementToBeClickable(prevButton));

        return this;
    }

    public CarouselComponent clickNextButton() {
        WebElement nextButton = driver.findElement(By.xpath(String.format(carouselNextButtonLocator, name)));
        nextButton.click();

        return this;
    }
}
