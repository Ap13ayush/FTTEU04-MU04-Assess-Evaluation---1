package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttonsOption;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;

    @FindBy(id = "dynamicClickMessage")
    private WebElement clickResult;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToButtons() {
        clickElement(buttonsOption);
    }

    public void scrollToButtons() {
        scrollToElement(clickMeButton);
    }

    public void jsClickButton() {
        jsClick(clickMeButton);
    }

    public String getClickResult() {
        return getElementText(clickResult);
    }
}
