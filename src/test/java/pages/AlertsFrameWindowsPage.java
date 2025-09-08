package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class AlertsFrameWindowsPage extends BasePage {

    // Navigation elements
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsCard;

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsOption;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsOption;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesOption;

    // Browser Windows elements
    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    // Alerts elements
    @FindBy(id = "alertButton")
    private WebElement simpleAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmAlertButton;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    // Frames elements
    @FindBy(id = "frame1")
    private WebElement frame1;

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAlertsFrameWindows() {
        clickElement(alertsFrameWindowsCard);
    }

    public void navigateToBrowserWindows() {
        clickElement(browserWindowsOption);
    }

    public String handleNewTab() {
        String originalWindow = driver.getWindowHandle();

        clickElement(newTabButton);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String newTabText = getElementText(sampleHeading);

        driver.close();
        driver.switchTo().window(originalWindow);

        return newTabText;
    }

    public void navigateToAlerts() {
        clickElement(alertsOption);
    }

    public void handleSimpleAlert() {
        clickElement(simpleAlertButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void handleConfirmAlert() {
        clickElement(confirmAlertButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public String getConfirmResult() {
        return getElementText(confirmResult);
    }

    public void navigateToFrames() {
        clickElement(framesOption);
    }

    public String handleFrame() {
        driver.switchTo().frame(frame1);
        String frameText = getElementText(sampleHeading);
        driver.switchTo().defaultContent();
        return frameText;
    }
}
