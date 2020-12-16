import java.util.Scanner;

import java.util.HashMap;
import java.util.ArrayList;

import java.util.InputMismatchException;

import java.text.DecimalFormat;

class ExpenseSystem {

    private static HashMap<String, ArrayList<ExpenseItem>> expenseItems = new HashMap<String, ArrayList<ExpenseItem>>();
    private static HashMap<String, Budget> budgets = new HashMap<String, Budget>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inInt;
        boolean running = true;

        addExpenseItem("Parking ticket", "travel", 40, false);
        addExpenseItem("Parking ticket", "travel", 30, false);
        addExpenseItem("Software Engineer", "work", 400, true);
        addExpenseItem("New Mouse", "work", 15, false);
        addBudget("travel", 100);

        System.out.println("Welcome to Dan & Megan's Expenses System");

        while (running) {
            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("1. Manage expenses");
            System.out.println("2. Manage budget");
            System.out.println("3. View analytics");
            System.out.println("4. Exit expense system");
            System.out.print("Select an option: ");

            try {
                inInt = input.nextInt();
                input.nextLine();
                System.out.println();

                if (inInt == 1) {
                    System.out.println("Transferring you to Expense Management...");
                    expenseController();
                } else if (inInt == 2) {
                    System.out.println("Transferring you to Budget Management...");
                    budgetController();
                } else if (inInt == 3) {
                    System.out.println("Transferring you to Analysis...");
                    analysisController();
                } else if (inInt == 4) {
                    System.out.println("Goodbye! 👋");
                    running = false;
                } else {
                    System.out.println("You have input an incorrect value, please try again...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type input");
                input.nextLine();
            }
        }
    }

    /**
     * EXPENSES CONTROLLER - For navigating the user through expense item options
     *
     * @return void
     */
    public static void expenseController() {
        Scanner input = new Scanner(System.in);
        int inInt;
        boolean running = true;

        System.out.println("Welcome to expense management!");

        while (running) {
            String description = "",
                    category = "";
            double amount = 0;
            boolean income = false;

            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("1. Add an expense item");
            System.out.println("2. Edit an expense item");
            System.out.println("3. Remove an expense item");
            System.out.println("4. Return to home");
            System.out.print("Select an option: ");

            try {
                inInt = input.nextInt();
                input.nextLine();
                System.out.println();

                if (inInt == 1) {
                    try {
                        System.out.println("Enter the following information:");
                        System.out.print("     description: ");
                        description = input.nextLine();
                        System.out.print("     category: ");
                        category = input.nextLine();
                        System.out.print("     amount: ");
                        amount = input.nextDouble();
                        System.out.print("     income (income = true | outcome = false): ");
                        income = input.nextBoolean();

                        addExpenseItem(description, category, amount, income);
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect data type input, please try again...");
                    }
                }
                else if (inInt == 2 || inInt == 3) {
                    System.out.println("We're going to find your expense item");
                    System.out.print("What category would you like to search in?: ");
                    category = input.nextLine();

                    ExpenseItem expenseItem = findExpenseItem(category);
                    if (expenseItem != null) {
                        if (inInt == 2) {
                            updateExpenseItem(expenseItem);
                        } else if (inInt == 3) {
                            deleteExpenseItem(expenseItem);
                        }
                    }
                }
                else if (inInt == 4) {
                    System.out.println("Sending you home!");
                    running = false;
                }
                else {
                    System.out.println("You have input an incorrect value, please try again...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type input");
                input.nextLine();
            }
        }
    }

    /**
     * Creates and adds ExpenseItem class object to expenseItems HashMap
     *
     * @param expenseItems the HashMap we're add the ExpenseItem to
     * @param description  a description of the expense item
     * @param category     the ExpenseItem category
     * @param amount       total cost of an expense item
     * @param dateAdded    the time and date an expense item was created
     * @param income       if income then true, if outcome then false
     * @return nothing, the expenseItems HashMap is updated by refereance
     */
    public static void addExpenseItem(String description, String category, double amount, boolean income) {
        ExpenseItem expenseItem = new ExpenseItem(description, category, amount, income);

        if (!expenseItems.containsKey(category)) {
            expenseItems.put(category, new ArrayList<ExpenseItem>());
        }
        expenseItems.get(category).add(expenseItem);
    }

    /**
     * Removes ExpenseItem class object from expenseItems HashMap
     *
     * @param expenseItems the HashMap we're add the ExpenseItem to
     * @param expenseItem  the expense item to remove
     * @return nothing, the expenseItems HashMap is updated by refereance
     */
    public static void deleteExpenseItem(ExpenseItem expenseItem) {
        String category = expenseItem.getCategory();
        expenseItems.get(category).remove(expenseItem);
    }

    /**
     * Edits ExpenseItem
     *
     * @param expenseItems the expense item to remove
     * @return nothing, the ExpenseItem is updated by refereance
     */
    public static void updateExpenseItem(ExpenseItem expenseItem) {
        boolean updating = true;
        Scanner input = new Scanner(System.in);
        int intIn;
        String strIn;
        double doubleIn;
        boolean boolIn;

        while (updating) {
            System.out.println("What would you like to update?");
            System.out.println("1. Description (" + expenseItem.getDescription() + ")");
            System.out.println("2. Category (" + expenseItem.getCategory() + ")");
            System.out.println("3. Amount (" + expenseItem.getAmount() + ")");
            System.out.println("4. Income (" + expenseItem.getIncome() + ")");
            System.out.println("5. Stop editing...");
            System.out.print("What would you like to do?: ");
            intIn = input.nextInt();
            input.nextLine();

            if (intIn == 1) {
                System.out.print("What do you want to change the description to?: ");
                strIn = input.nextLine();
                expenseItem.setDescription(strIn);
            } else if (intIn == 2) {
                String catOld = expenseItem.getCategory();
                System.out.print("What do you want to change the category to?: ");
                strIn = input.nextLine();
                expenseItem.setCategory(strIn);

                expenseItems.get(catOld).remove(expenseItem);
                if (expenseItems.get(catOld).size() <= 0) {
                    expenseItems.remove(catOld);
                }
                addExpenseItem(expenseItem.getDescription(), expenseItem.getCategory(), expenseItem.getAmount(), expenseItem.getIncome());
            } else if (intIn == 3) {
                System.out.print("What do you want to change the amount to?: ");
                doubleIn = input.nextDouble();
                input.nextLine();
                expenseItem.setAmount(doubleIn);
            } else if (intIn == 4) {
                System.out.print("What do you want to change the income to?: ");
                boolIn = input.nextBoolean();
                input.nextLine();
                expenseItem.setIncome(boolIn);
            } else if (intIn == 5) {
                System.out.println("Thank you for editing...");
                updating = false;
            } else {
                System.out.println("That input is invalid...");
                System.out.println("Please try again");
            }
        }
    }

    /**
     * Finds ExpenseItem from expenseItems by searching through category
     *
     * @param category, the category to search for
     * @return expenseItem, chosen category by user
     */
    public static ExpenseItem findExpenseItem(String category) {
        Scanner input = new Scanner(System.in);
        int inInt;

        ArrayList<ExpenseItem> expenseItemCategory = expenseItems.get(category);
        ExpenseItem expenseItem = null;

        int i = 1;
        for (ExpenseItem item : expenseItemCategory) {
            System.out.println(i + ". " + item.getDescription() + ", " + (item.getIncome() ? "+" : "-") + "£" + item.getAmount() + ", " + item.getDateAdded());
            i++;
        }
        System.out.print("Choose an exepense item: ");
        inInt = input.nextInt();
        input.nextLine();

        if (inInt <= expenseItemCategory.size() && inInt > 0) {
            expenseItem = expenseItemCategory.get(inInt - 1);
        } else {
            System.out.println("You're expense item at position " + inInt + " was out of bounds...");
        }

        return expenseItem;
    }

    /**
     * BUDGETS CONTROLLER - For navigating the user through budget options
     */
    public static void budgetController() {
        Scanner input = new Scanner(System.in);
        int inInt;
        boolean running = true;

        System.out.println("Welcome to budget management!");

        while (running) {
            String category = "";
            double amount = 0;

            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("1. Add a budget");
            System.out.println("2. Edit a budget");
            System.out.println("3. Remove a budget");
            System.out.println("4. Return to home");
            System.out.print("Select an option: ");

            try {
                inInt = input.nextInt();
                input.nextLine();
                System.out.println();

                if (inInt == 1) {
                    try {
                        System.out.println("Enter the following information:");
                        System.out.print("     category: ");
                        category = input.nextLine();
                        System.out.print("     amount: ");
                        amount = input.nextDouble();

                        addBudget(category, amount);
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect data type input, please try again...");
                    }
                }
                else if (inInt == 2 || inInt == 3) {
                    System.out.println("We're going to find your expense item");
                    System.out.print("What category would you like to search in?: ");
                    category = input.nextLine();

                    Budget budget = findBudget(category);
                    if (budget != null) {
                        if (inInt == 2) {
                            updateBudget(budget.getCategory());
                        } else if (inInt == 3) {
                            deleteBudget(budget);
                        }
                    }
                }
                else if (inInt == 4) {
                    System.out.println("Sending you home!");
                    running = false;
                }
                else {
                    System.out.println("You have input an incorrect value, please try again...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type input");
                input.nextLine();
            }
        }
    }

    /**
     * Creates and adds a Budget class object to the budgets HashMap
     *
     * @param category the category for this budget
     * @param limit the spending limit on this category
     * @return nothing, the budgets HashMap is updated by reference
     */
    public static void addBudget(String category, double limit) {
        Budget newBudget = new Budget(limit, category);
        if (budgets.containsKey(category)) {
            budgets.remove(category);
        }
        budgets.put(category, newBudget);
    }

    /**
     * Removes a Budget class object from the budgets HashMap
     *
     * @param budgets the HashMap of Budget objects
     * @param budget the budget to remove
     * @return nothing, the budgets HashMap is updated by reference
     */
    public static void deleteBudget(Budget budget) {
        budgets.remove(budget.getCategory());
    }

    /**
     * Checks if an expense category is near the budget
     *
     * @param budgets the HashMap of Budget objects
     * @param expenseItems the HashMap of expenses
     * @param budget the budget to remove
     * @return true if bellow 20% left of budget / false if more is left
     */
    public static boolean budgetWarning(String category) {
        Double budget = budgets.get(category).getLimit();
        Double expense = ExpenseSystem.expenditureByCategory(category);
        if (expense > budget*0.8) { return true; }
        return false;
    }

    /**
     * Updates price for budget
     *
     * @param category, the budget to update
     * @return void, budget get's updated by refereance
     */
    public static void updateBudget(String category) {
        Scanner input = new Scanner(System.in);
        double inDouble;

        try {
            System.out.print("Enter a new budget price: ");
            inDouble = input.nextDouble();

            addBudget(category, inDouble);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data type input");
            input.nextLine();
        }
    }

    /**
     * Finds Budget from budgets
     *
     * @param category, the category to search for
     * @return budget
     */
    public static Budget findBudget(String category) {
        return budgets.get(category);
    }

    /**
     * ANALYSIS CONTROLLER - For navigating the user through analysis options
     */
    public static void analysisController() {
        Scanner input = new Scanner(System.in);
        int inInt;
        boolean running = true;

        System.out.println("Welcome to budget management!");

        while (running) {
            String inStr = "";

            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("1. View total expenditure");
            System.out.println("2. View total average spend");
            System.out.println("3. View expenditure per item");
            System.out.println("4. View expenditure by category");
            System.out.println("5. View income by category");
            System.out.println("6. View analysis breakdown");
            System.out.println("7. Return to home");
            System.out.print("Select an option: ");

            try {
                inInt = input.nextInt();
                input.nextLine();
                System.out.println();

                if (inInt == 1) {
                    System.out.println("Total expenditure: £" + totalExpenditure());
                }
                else if (inInt == 2) {
                    System.out.println("Total average spend: £" + totalAverageSpend());
                }
                else if (inInt == 3) {
                    System.out.print("Enter the expense item's description (name)?: ");
                    inStr = input.nextLine();

                    System.out.println("Total expenditure for item description " + inStr + ": £" + expenditurePerItem(inStr));
                }
                else if (inInt == 4 || inInt == 5) {
                    System.out.print("What category would you like analysis for?: ");
                    inStr = input.nextLine();

                    if (inInt == 4) {
                        System.out.println("Total expenditure for category " + inStr + ": £" + expenditureByCategory(inStr));
                    } else if (inInt == 5) {
                        System.out.println("Total income for category " + inStr + ": £" + incomeByCategory(inStr));
                    }
                }
                else if (inInt == 6) {
                    analysisBreakdown();
                }
                else if (inInt == 7) {
                    System.out.println("Sending you home!");
                    running = false;
                }
                else {
                    System.out.println("You have input an incorrect value, please try again...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type input");
                input.nextLine();
            }
        }
    }

    /**
     * Calculates the total expenses logged
     *
     * @param expenseItems the hashmap of all expenseItem objects
     * @return total expenditure
     */
    public static double totalExpenditure() {
        double total = 0;

        for (ArrayList<ExpenseItem> items : expenseItems.values()) {
            for (ExpenseItem item : items) {
                if (!item.getIncome()) {
                    total += item.getAmount();
                }
            }
        }

        return total;
    }

    /**
     * Calculates the total average expenditure
     *
     * @param expenseItems the hashmap of all expenseItem objects
     * @return average expenditure of all items
     */
    public static double totalAverageSpend() {
        double total = 0;
        double totalItems = 0;

        for (ArrayList<ExpenseItem> items : expenseItems.values()) {
            for (ExpenseItem item : items) {
                if (!item.getIncome()) {
                    total += item.getAmount();
                    totalItems++;
                }
            }
        }

        return total / totalItems;
    }

    /**
     * Calculates the average expenditure by type of item
     *
     * @param expenseItems the hashmap of all expenseItem objects
     * @param itemDesc     the name/descrition of the item type
     * @return average expenditure per item type
     */
    public static double expenditurePerItem(String itemDesc) {
        double average = 0;
        int totalNum = 0;

        for (ArrayList<ExpenseItem> items : expenseItems.values()) {
            for (ExpenseItem item : items) {
                if ((!item.getIncome()) && item.getDescription().equals(itemDesc)) {
                    average += item.getAmount();
                    totalNum++;
                }
            }
        }

        return average / totalNum;
    }

    /**
     * Calculates the average expenditure for a category
     *
     * @param expenseItems the hashmap of all expenseItem objects
     * @param category     the category of expenditure
     * @return total expenditure for the specified category
     */
    public static double expenditureByCategory(String category) {
        double total = 0;

        for (ArrayList<ExpenseItem> items : expenseItems.values()) {
            for (ExpenseItem item : items) {
                if ((!item.getIncome()) && item.getCategory().equals(category)) {
                    total += item.getAmount();
                }
            }
        }

        return total;
    }

    /**
     * Calculates the average income for a category
     *
     * @param expenseItems the hashmap of all expenseItem objects
     * @param category     the category of income
     * @return total income for the specified category
     */
    public static double incomeByCategory(String category) {
        double total = 0;

        for (ArrayList<ExpenseItem> items : expenseItems.values()) {
            for (ExpenseItem item : items) {
                if (item.getIncome() && item.getCategory().equals(category)) {
                    total += item.getAmount();
                }
            }
        }

        return total;
    }

    /**
     * Calculates the statistical breakdown for each categorys
     *
     * @param expenseItems the hashmap of all expenseItem objects
     * @return void, prints arraylist of the statistics in order of income, outcome, overall balance, and percentage outcome
     */
    public static void analysisBreakdown() {
        HashMap<String, ArrayList<Double>> categoryBreakdown = new HashMap<String, ArrayList<Double>>();
        double totalIncome, totalExpenditure, totalBalance, percentExpenditure;
        String category;
        DecimalFormat format = new DecimalFormat("##.00");

        for (ArrayList<ExpenseItem> items : expenseItems.values()) {
            category = items.get(0).getCategory();

            totalIncome = incomeByCategory(category);
            totalExpenditure = expenditureByCategory(category);
            totalBalance = totalIncome - totalExpenditure;
            percentExpenditure = (totalExpenditure / totalExpenditure()) * 100;

            // System.out.println("Category: " + category);
            // System.out.println("	total income: £" + totalIncome);
            // System.out.println("	total outgoings: £" + totalExpenditure);
            // System.out.println("	total balance: £" + totalBalance);
            // System.out.println("	percentage outgoings: " + percentExpenditure + "%");

            System.out.println();

            System.out.println("Category: " + category);

            printAnalysisBreakdownGraph("total income", totalIncome, totalBalance, " ");

            printAnalysisBreakdownGraph("total outgoings", totalExpenditure, totalBalance, " ");

            printAnalysisBreakdownGraph("total balance", totalBalance, totalBalance, "*");

            System.out.println("percentage outgoings: " + format.format(percentExpenditure) + "%");
        }
    }

    /**
     * Teminal Graph
     * @param name the name of the variable
     * @param value the value to print the size of
     * @param totalBalance the total balance to account for formatting
     * @param totalBalanceFormatString the value to print when formatting graph
     * @return prints line for analysisBreakdown() barchart
     */
    public static void printAnalysisBreakdownGraph(String name, double value, double totalBalance, String totalBalanceFormatString) {
    	DecimalFormat format = new DecimalFormat("##.00");

    	// The longest string name "percentage outgoings" is 20 characters
    	int longestStringName = 20;

    	for (int i = 0; i < longestStringName - name.length(); i++) {
    		System.out.print(" ");
    	}
		System.out.print(name + ": ");
		
        if (0 > totalBalance) {
        	for (int i = 0; i > totalBalance / 10; i--) {
                System.out.print(totalBalanceFormatString);
            }

            System.out.print(" | ");
        }
        
        for (int i = 0; i < value / 10; i++) {
            System.out.print("*");
        }
        
        System.out.println(" - £" + format.format(value));
    }
}