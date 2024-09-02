package pages;

import data.Person;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutMePage extends AbsBasePage {

    private final String inputSelectorTemplate = "input[name='%s']";
    private final String contactLocatorTemplate = "(//button[contains(text(), '%s')]) [last()]";
    private final By setMethodLocator = By.xpath("(//span[@class='placeholder']) [last()]");
    private final String socialNetLocatorTemplate = "(//button[@data-value='%s']) [last()]";
    private final String fieldSelectorTemplate = "input#id_contact-%d-value";
    private final By saveSelector = By.cssSelector("button[title='Сохранить и заполнить позже']");
    private String deleteLocator = "(//div[@class='lk-cv-block__input-alignment']/button)[last()%s]";

    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    public AboutMePage clearInput(String name, String input) {
        WebElement field = driver.findElement(By.cssSelector(String.format(inputSelectorTemplate, name)));
        field.clear();
        field.sendKeys(input);

        return this;
    }

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

    public AboutMePage fullInput(Person person) {
        clearInput("fname", person.getFirstName());
        clearInput("fname_latin", person.getFirstNameLatin());
        clearInput("lname", person.getLastName());
        clearInput("lname_latin", person.getLastNameLatin());
        clearInput("date_of_birth", person.getBirthdate());

        setContacts(person.getFirstSocials(), 1, person.getFirstLink());
        setContacts(person.getSecondSocials(), 2, person.getSecondLink());
        return this;
    }

    public AboutMePage fullCheck(Person person) {
        checkContacts("fname", person.getFirstName());
        checkContacts("fname_latin", person.getFirstNameLatin());
        checkContacts("lname", person.getLastName());
        checkContacts("lname_latin", person.getLastNameLatin());
        checkContacts("date_of_birth", person.getBirthdate());
        checkSocials(0, person.getFirstLink());
        checkSocials(1, person.getSecondLink());
        return this;
    }

    public AboutMePage clearContacts(String num) {
        driver.findElement(By.xpath(String.format(deleteLocator,num))).click();
        return this;
    }
}
