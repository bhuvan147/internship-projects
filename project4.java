import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private static final List<Expense> expenses = new ArrayList<>();
    private static final Map<String, Double> categoryTotals = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    expenseSummaries(scanner);
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter expense category: ");
        String category = scanner.next();

        // Validate and add the expense
        if (amount > 0) 
        {    Expense expense = new Expense(description, amount, category);
            expenses.add(expense);

            // Update category total
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);

            System.out.println("Expense added successfully!");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void viewExpenses() {
        System.out.println("Expense List:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void expenseSummaries(Scanner scanner) {
        System.out.println("Expense Summaries Menu:");
        System.out.println("1. Total Expenses");
        System.out.println("2. Expenses by Category");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
                System.out.println("Total Expenses: $" + totalExpenses);
                break;
            case 2:
                System.out.println("Category-wise Expenses:");
                for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
                    System.out.println(entry.getKey() + ": $" + entry.getValue());
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }
}

class Expense {
    private final String description;
    private final double amount;
    private final String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category;
    }
}
