package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPage;

public class Task3AlertsWindowsFramesTest extends BaseTest {

    @Test(priority = 3, description = "Test Alerts, Windows, and IFrames")
    public void testAlertsWindowsAndIFrames() {
        AlertsFrameWindowsPage alertsPage = new AlertsFrameWindowsPage(driver);

        // Window Handling
        alertsPage.navigateToAlertsFrameWindows();
        alertsPage.navigateToBrowserWindows();

        String newTabText = alertsPage.handleNewTab();
        Assert.assertTrue(newTabText.contains("This is a sample page"),
                "New tab text verification failed");

        // Alert Handling
        alertsPage.navigateToAlerts();

        // Simple alert
        alertsPage.handleSimpleAlert();

        // Confirmation alert
        alertsPage.handleConfirmAlert();

        // Assert confirmation result
        String confirmResult = alertsPage.getConfirmResult();
        Assert.assertTrue(confirmResult.contains("You selected Cancel"),
                "Confirm alert result verification failed");

        // IFrame Handling
        alertsPage.navigateToFrames();

        String frameText = alertsPage.handleFrame();
        Assert.assertTrue(frameText.contains("This is a sample page"),
                "Frame text verification failed");

        System.out.println("✅ Task 3 - Alerts, Windows & Frames: PASSED");
    }
}
