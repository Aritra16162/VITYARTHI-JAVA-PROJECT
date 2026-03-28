package projectvityarthi;
/**
 * Expense.java
 * 
 * This is the DATA CLASS (Model) for the Student Expense Tracker.
 * It represents a single expense entry with three fields:
 *   - amount   : how much was spent
 *   - category : what it was spent on (e.g., Food, Travel)
 *   - date     : when it was spent (e.g., 2024-03-25)
 * 
 * Encapsulation is applied — all fields are private,
 * and accessed via public getters and setters.
 */
public class Expense {

    // -------------------------------------------------------
    // Private fields (Encapsulation)
    // -------------------------------------------------------
    private double amount;      // Amount spent (e.g., 150.50)
    private String category;    // Category of expense (e.g., Food)
    private String date;        // Date of expense (e.g., 2024-03-25)

    // -------------------------------------------------------
    // Constructor — used to create a new Expense object
    // -------------------------------------------------------
    public Expense(double amount, String category, String date) {
        this.amount   = amount;
        this.category = category;
        this.date     = date;
    }

    // -------------------------------------------------------
    // Getters — allow reading private fields
    // -------------------------------------------------------
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    // -------------------------------------------------------
    // Setters — allow updating private fields
    // -------------------------------------------------------
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }
}