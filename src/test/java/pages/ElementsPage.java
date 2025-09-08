package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    // Main navigation elements
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsCard;

    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBoxMenu;

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButtonMenu;

    // Text Box elements
    @FindBy(id = "userName")
    private WebElement fullNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    // Radio Button elements
    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(xpath = "//p[@class='mt-3']")
    private WebElement radioButtonResult;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToElements() {
        clickElement(elementsCard);
    }

    public void navigateToTextBox() {
        clickElement(textBoxMenu);
    }

    public void fillTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        sendKeysToElement(fullNameInput, fullName);
        sendKeysToElement(emailInput, email);
        sendKeysToElement(currentAddressInput, currentAddress);
        sendKeysToElement(permanentAddressInput, permanentAddress);
    }

    public void submitTextBoxForm() {
        clickElement(submitButton);
    }

    public void navigateToRadioButton() {
        clickElement(radioButtonMenu);
    }

    public void selectImpressiveRadioButton() {
        clickElement(impressiveRadioButton);
    }

    public String getRadioButtonResult() {
        return getElementText(radioButtonResult);
    }
}
