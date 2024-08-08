package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutMePage extends AbsBasePage {

    private final String inputSelectorTemplate = "input[name='%s']";
    private final String deleteLocatorTemplate = "(//button[contains(text(), '%s')]) [last()%d]";
    private final String contactLocatorTemplate = "(//button[contains(text(), '%s')]) [last()]";
    private final By setMethodLocator = By.xpath("(//span[@class='placeholder']) [last()]");
    private final String socialNetLocatorTemplate = "(//button[@data-value='%s']) [last()]";
    private final String fieldSelectorTemplate = "input#id_contact-%d-value";
    private final By saveSelector = By.cssSelector("button[title='Сохранить и заполнить позже']");
    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    public AboutMePage clearInput(String name, String input) {
        WebElement field = driver.findElement(By.cssSelector(String.format(inputSelectorTemplate, name)));
        field.clear();
        field.sendKeys(input);

        return this;
    }

//    public AboutMePage setContacts(String name, int num, String socials) {
//        driver.findElement(By.xpath(String.format(contactLocatorTemplate, "Добавить"))).click();
//        driver.findElement(setMethodLocator).click();
//        driver.findElement(By.xpath(String.format(socialNetLocatorTemplate, name))).click();
//        WebElement input = driver.findElement(By.cssSelector(String.format(fieldSelectorTemplate, num)));
//        input.click();
//        input.sendKeys(socials);
//         return this;
//    }

    public AboutMePage setContacts(String name, int num, String socials) {
        driver.findElement(By.xpath(String.format(contactLocatorTemplate, "Добавить"))).click();
        driver.findElement(setMethodLocator).click();
        driver.findElement(By.xpath(String.format(socialNetLocatorTemplate, name))).click();
        WebElement input = driver.findElement(By.cssSelector(String.format(fieldSelectorTemplate, num)));
        input.click();
        input.sendKeys(socials);
        return this;
    }


    public AboutMePage clickSaveButton() {
        driver.findElement(saveSelector).click();
        return new AboutMePage(driver);
    }

    public AboutMePage checkContacts(String name, String exp) {
        Assertions.assertEquals(exp, driver.findElement(By.cssSelector(String.format(inputSelectorTemplate, name))).getAttribute("value"));
        return this;
    }

    public AboutMePage checkSocials(int num, String exp) {
        Assertions.assertEquals(exp, driver.findElement(By.cssSelector(String.format(fieldSelectorTemplate, num))).getAttribute("value"));
        return this;
    }

    public AboutMePage fullCheck() {
        checkContacts("fname", "Abra");
        checkContacts("fname_latin", "Kadabra");
        checkContacts("lname", "Abrum");
        checkContacts("lname_latin", "Kalabum");
        checkContacts("date_of_birth", "20.08.2012");
        checkSocials(1, "https://t.me/durov");
        checkSocials(2, "https://vk.com/durov");
        return this;
    }

    public AboutMePage fullInput() {
        clearInput("fname", "Abra");
        clearInput("fname_latin", "Kadabra");
        clearInput("lname", "Abrum");
        clearInput("lname_latin", "Kalabum");
        clearInput("date_of_birth", "20.08.2012");

        setContacts("telegram", 1, "https://t.me/durov");
        setContacts("vk", 2, "https://vk.com/durov");
        return this;
    }

    public AboutMePage clearContacts(String name, int num) {
        driver.findElement(By.xpath(String.format(deleteLocatorTemplate, name, num))).click();
        return this;
    }
}
