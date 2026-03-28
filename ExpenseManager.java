package projectvityarthi;
/**
 * ExpenseManager.java
 * 
 * LOGIC CLASS — Handles all expense operations.
 * 
 * This class manages the list of expenses, provides methods to add/view/calculate/summarize expenses,
 * and implements file handling to save/load expenses from "expenses.txt".
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExpenseManager {

    
    private static final String FILE_NAME = "projectvityarthi/expenses.txt";

    // ArrayList to store all Expense objects in memory
    private ArrayList<Expense> expenseList;

    // Constructor — initializes the expense list and loads from file
    public ExpenseManager() {
        expenseList = new ArrayList<>();
        loadExpensesFromFile(); // 🆕 Auto-load saved expenses on start
    }

    
    public void addExpense(double amount, String category, String date) {
        Expense newExpense = new Expense(amount, category, date);
        expenseList.add(newExpense);
        saveExpensesToFile(); // 🆕 Persist to file immediately
        System.out.println("\n  ✔  Expense added and saved successfully!");
    }

   
    public void viewAllExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("\n  No expenses recorded yet.");
            return;
        }

        System.out.println("\n  " + "=".repeat(55));
        System.out.printf("  %-5s %-15s %-15s %-12s%n",
                          "S.No", "Category", "Date", "Amount (Rs)");
        System.out.println("  " + "=".repeat(55));

        for (int i = 0; i < expenseList.size(); i++) {
            Expense expense = expenseList.get(i);
            System.out.printf("  %-5d %-15s %-15s %-12.2f%n",
                              (i + 1),
                              expense.getCategory(),
                              expense.getDate(),
                              expense.getAmount());
        }

        System.out.println("  " + "=".repeat(55));
    }

    
    public void calculateTotalExpense() {
        if (expenseList.isEmpty()) {
            System.out.println("\n  No expenses to calculate.");
            return;
        }

        double total = 0.0;
        for (Expense expense : expenseList) {
            total += expense.getAmount();
        }

        System.out.println("\n  " + "-".repeat(35));
        System.out.printf("  %-25s Rs %.2f%n", "Total Expenses:", total);
        System.out.println("  " + "-".repeat(35));
    }

    
    public void categorySummary() {
        if (expenseList.isEmpty()) {
            System.out.println("\n  No expenses to summarize.");
            return;
        }

        HashMap<String, Double> categoryMap = new HashMap<>();

        for (Expense expense : expenseList) {
            String cat    = expense.getCategory();
            double amount = expense.getAmount();

            if (categoryMap.containsKey(cat)) {
                categoryMap.put(cat, categoryMap.get(cat) + amount);
            } else {
                categoryMap.put(cat, amount);
            }
        }

        System.out.println("\n  " + "=".repeat(35));
        System.out.printf("  %-20s %-12s%n", "Category", "Total (Rs)");
        System.out.println("  " + "=".repeat(35));

        for (Map.Entry<String, Double> entry : categoryMap.entrySet()) {
            System.out.printf("  %-20s %-12.2f%n",
                              entry.getKey(),
                              entry.getValue());
        }

        System.out.println("  " + "=".repeat(35));
    }

    
    private void saveExpensesToFile() {
        // Try-with-resources: automatically closes the writer when done
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Expense expense : expenseList) {
                // Write each expense as a CSV line: amount,category,date
                writer.write(expense.getAmount() + ","
                           + expense.getCategory() + ","
                           + expense.getDate());
                writer.newLine(); // Move to the next line
            }

        } catch (IOException e) {
            // If something goes wrong while writing, inform the user
            System.out.println("\n  ⚠  Error saving expenses: " + e.getMessage());
        }
    }

   
    private void loadExpensesFromFile() {
        // Try-with-resources: automatically closes the reader when done
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            // Read one line at a time until end of file
            while ((line = reader.readLine()) != null) {

                // Skip blank lines
                if (line.trim().isEmpty()) continue;

                // Split the CSV line into parts: [amount, category, date]
                String[] parts = line.split(",");

                // We need exactly 3 parts; skip malformed lines
                if (parts.length != 3) continue;

                // Parse each field with appropriate data type
                double amount   = Double.parseDouble(parts[0].trim());
                String category = parts[1].trim();
                String date     = parts[2].trim();

                // Recreate the Expense object and add to list
                expenseList.add(new Expense(amount, category, date));
            }

            // Only show this message if data was actually loaded
            if (!expenseList.isEmpty()) {
                System.out.println("  ✔  " + expenseList.size()
                                 + " expense(s) loaded from saved file.");
            }

        } catch (FileNotFoundException e) {
            // File doesn't exist yet — this is normal on first run, do nothing
            // (No message needed; the file will be created on first save)

        } catch (IOException e) {
            // Some other read error occurred
            System.out.println("\n  ⚠  Error loading expenses: " + e.getMessage());

        } catch (NumberFormatException e) {
            // A line had a non-numeric amount — skip it gracefully
            System.out.println("\n  ⚠  Skipped a corrupted line in expenses.txt.");
        }
    }
}