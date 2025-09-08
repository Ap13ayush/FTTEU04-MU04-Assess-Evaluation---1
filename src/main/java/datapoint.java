import java.util.*;

public class EmployeeProcessor {
    public static void main(String[] args) {
        // Initial dataset
        String[] employeeNames = {
                "Alice", "Bob", "Charlie", "Alice", "David", "Bob", "Eve",
                "Charlie", "Alice", "Frank", "Grace", "Bob"
        };

        System.out.println("=== EMPLOYEE CHECK-IN PROCESSOR ===\n");

        // TASK 1: Store and Display All Entries (ArrayList)
        System.out.println("TASK 1: Storing All Entries");
        System.out.println("------------------------");

        // Create ArrayList to store all names
        ArrayList<String> allEntries = new ArrayList<>();

        // Add all names from array to ArrayList
        for (String name : employeeNames) {
            allEntries.add(name);
        }

        // Display results
        System.out.println("Total Entries: " + allEntries.size());
        System.out.println("All entries: " + allEntries);
        System.out.println();

        // TASK 2: Identify Unique Employees (HashSet)
        System.out.println("TASK 2: Finding Unique Employees");
        System.out.println("-------------------------------");

        // Create HashSet to store unique names
        HashSet<String> uniqueEmployees = new HashSet<>();

        // Add all names from ArrayList to HashSet (duplicates automatically removed)
        for (String name : allEntries) {
            uniqueEmployees.add(name);
        }

        // Display results
        System.out.println("Unique Employees: " + uniqueEmployees.size());
        System.out.println("Unique names: " + uniqueEmployees);
        System.out.println();

        // TASK 3: Count Entry Frequency (HashMap)
        System.out.println("TASK 3: Counting Check-in Frequency");
        System.out.println("----------------------------------");

        // Create HashMap to count frequencies
        HashMap<String, Integer> frequencyCount = new HashMap<>();

        // Count each employee's check-ins
        for (String name : allEntries) {
            // Check if name already exists in map
            if (frequencyCount.containsKey(name)) {
                // If exists, get current count and add 1
                int currentCount = frequencyCount.get(name);
                frequencyCount.put(name, currentCount + 1);
            } else {
                // If doesn't exist, add with count of 1
                frequencyCount.put(name, 1);
            }
        }

        // Display frequency results
        System.out.println("Check-in frequency for each employee:");
        for (String name : frequencyCount.keySet()) {
            int count = frequencyCount.get(name);
            System.out.println(name + ": " + count);
        }
    }
}
