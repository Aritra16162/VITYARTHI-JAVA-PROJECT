package projectvityarthi;
/**
 * Main.java
 * 
 * ENTRY POINT — Menu-driven console UI.
 * 
 * This class contains the main method that runs the Student Expense Tracker application.
 * It displays a menu to the user, takes input, and calls methods from ExpenseManager
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner       = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager(); //  Auto-loads file here

        int choice;

        
        System.out.println("\n  ╔════════════════════════════════════════╗");
        System.out.println("  ║     STUDENT EXPENSE TRACKER            ║");
        System.out.println("  ║                                        ║");
        System.out.println("  ╚════════════════════════════════════════╝");

        // Main loop
        do {
            printMenu();

            System.out.print("  Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {

               
                // Case 1: Add a new expense
                // (save to file happens inside addExpense())
                
                case 1:
                    System.out.println("\n  -- Add New Expense --");

                    System.out.print("  Enter amount (Rs): ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("  Enter category (e.g., Food, Travel, Books): ");
                    String category = scanner.nextLine().trim();

                    System.out.print("  Enter date (e.g., 2024-03-25): ");
                    String date = scanner.nextLine().trim();

                    manager.addExpense(amount, category, date);
                    break;

                
                // Case 2: View all expenses
                
                case 2:
                    System.out.println("\n  -- All Expenses --");
                    manager.viewAllExpenses();
                    break;

               
                // Case 3: Calculate total expense
                
                case 3:
                    System.out.println("\n  -- Total Expense --");
                    manager.calculateTotalExpense();
                    break;

                
                // Case 4: Category-wise summary
                
                case 4:
                    System.out.println("\n  -- Category-wise Summary --");
                    manager.categorySummary();
                    break;

                
                // Case 5: Exit
                
                case 5:
                    System.out.println("\n  All expenses are saved in 'expenses.txt'.");
                    System.out.println("  Thank you for using Student Expense Tracker!");
                    System.out.println("  Goodbye! Track your expenses wisely. 👋\n");
                    break;

                
                // Default: invalid input
                
                default:
                    System.out.println("\n Invalid choice!\n Please enter 1-5.");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }

    
    //  Updated menu — shows auto-save indicator on Option 1
    
    private static void printMenu() {
        System.out.println("\n  ┌───────────────────────────────────────┐");
        System.out.println("  │              MAIN MENU                │");
        System.out.println("  ├───────────────────────────────────────┤");
        System.out.println("  │  1. Add Expense          [Auto-Save]  │");
        System.out.println("  │  2. View All Expenses                 │");
        System.out.println("  │  3. Calculate Total Expense           │");
        System.out.println("  │  4. Category-wise Summary             │");
        System.out.println("  │  5. Exit                              │");
        System.out.println("  └───────────────────────────────────────┘");
    }
}