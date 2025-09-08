package tests;

import org.testng.annotations.Test;
import pages.WidgetsPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task2DynamicWidgetsTest extends BaseTest {

    @Test(priority = 2, description = "Test Handling Dynamic Widgets")
    public void testHandlingDynamicWidgets() {
        WidgetsPage widgetsPage = new WidgetsPage(driver);

        // Navigate to Widgets -> Select Menu
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToSelectMenu();

        // Handle standard dropdown
        widgetsPage.selectTitle("Dr.");

        // Handle dynamic dropdown
        widgetsPage.selectDynamicOption();

        // Navigate to Date Picker
        widgetsPage.navigateToDatePicker();

        // Handle calendar - set future date
        LocalDate futureDate = LocalDate.now().plusMonths(1).withDayOfMonth(15);
        String formattedDate = futureDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        widgetsPage.setDate(formattedDate);

        System.out.println("Task 2 - Dynamic Widgets: PASSED");
    }
}
