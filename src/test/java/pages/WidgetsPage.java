package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WidgetsPage extends BasePage {

    // Navigation elements
    @FindBy(xpath = "//h5[text()='Widgets']")
    private WebElement widgetsCard;

    @FindBy(xpath = "//span[text()='Select Menu']")
    private WebElement selectMenuOption;

    @FindBy(xpath = "//span[text()='Date Picker']")
    private WebElement datePickerOption;

    // Select Menu elements
    @FindBy(id = "oldSelectMenu")
    private WebElement titleDropdown;

    @FindBy(xpath = "//div[@id='selectOne']//div[@class=' css-1hwfws3']")
    private WebElement dynamicDropdown;

    @FindBy(xpath = "//div[text()='Group 1, option 1']")
    private WebElement groupOption;

    // Date Picker elements
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement dateInput;

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToWidgets() {
        clickElement(widgetsCard);
    }

    public void navigateToSelectMenu() {
        clickElement(selectMenuOption);
    }

    public void selectTitle(String title) {
        Select select = new Select(titleDropdown);
        select.selectByVisibleText(title);
    }

    public void selectDynamicOption() {
        clickElement(dynamicDropdown);
        clickElement(groupOption);
    }

    public void navigateToDatePicker() {
        clickElement(datePickerOption);
    }

    public void setDate(String date) {
        dateInput.clear();
        sendKeysToElement(dateInput, date);
        dateInput.sendKeys(Keys.ENTER);
    }
}
