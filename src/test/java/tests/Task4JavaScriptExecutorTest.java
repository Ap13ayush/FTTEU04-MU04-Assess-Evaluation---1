package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;
import pages.ElementsPage;

public class Task4JavaScriptExecutorTest extends BaseTest {

    @Test(priority = 4, description = "Test JavaScript Executor and Screenshots")
    public void testJavaScriptExecutorAndScreenshots() {
        ElementsPage elementsPage = new ElementsPage(driver);
        ButtonsPage buttonsPage = new ButtonsPage(driver);

        // Navigate to Elements -> Buttons
        elementsPage.navigateToElements();
        buttonsPage.navigateToButtons();

        // Scroll using JavaScriptExecutor
        buttonsPage.scrollToButtons();

        // Click using JavaScriptExecutor
        buttonsPage.jsClickButton();

        // Verify the click result
        String clickResult = buttonsPage.getClickResult();
        Assert.assertTrue(clickResult.contains("You have done a dynamic click"),
                "JavaScript click verification failed");

        System.out.println("Task 4 - JavaScript Executor: PASSED");
    }
}
