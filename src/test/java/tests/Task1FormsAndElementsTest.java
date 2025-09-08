package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;

public class Task1FormsAndElementsTest extends BaseTest {

    @Test(priority = 1, description = "Test Forms and Basic Element Interaction")
    public void testFormsAndBasicElementInteraction() {
        ElementsPage elementsPage = new ElementsPage(driver);

        // Navigate to Elements -> Text Box
        elementsPage.navigateToElements();
        elementsPage.navigateToTextBox();

        // Fill form fields
        elementsPage.fillTextBoxForm(
                "John Doe",
                "john.doe@example.com",
                "123 Main Street, City",
                "456 Oak Avenue, Town"
        );

        // Submit form
        elementsPage.submitTextBoxForm();

        // Navigate to Radio Button
        elementsPage.navigateToRadioButton();

        // Click Impressive radio button
        elementsPage.selectImpressiveRadioButton();

        // Assert the selection
        String result = elementsPage.getRadioButtonResult();
        Assert.assertTrue(result.contains("Impressive"),
                "Radio button selection verification failed");

        System.out.println("✅ Task 1 - Forms and Elements: PASSED");
    }
}
