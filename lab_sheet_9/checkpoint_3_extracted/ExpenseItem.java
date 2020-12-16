import java.time.LocalDate;

class ExpenseItem {
	private String description;
	private String category;
	private double amount;
	private LocalDate dateAdded;
	private boolean income; // True = income | False = outcome

	/**
	 * Creates ExpenseItem Class Object
	 *
	 * @param description a description of the expense item
	 * @param category groups expense items into categories 
	 * @param amount total cost of an expense item
	 * @param dateAdded the time and date an expense item was created
	 * @param income if income then true, if outcome then false
	 */
	public ExpenseItem(String description, String category, double amount, boolean income) {
		this.description = description;
		this.category = category;
		this.amount = amount;
		this.dateAdded = LocalDate.now();
		this.income = income;
	}
	
	/**
	 * Gets the description from the ExpenseItem object
	 *
	 * @return a description of the expense item as String
	 */
	public String getDescription() { return this.description; }
	/**
	 * Sets description for the ExpenseItem object
	 *
	 * @param description a description of the expense item
	 */
	public void setDescription(String description) { this.description = description; }
	
	/**
	 * Gets the category from the ExpenseItem object
	 *
	 * @return a category of the expense item as String
	 */
	public String getCategory() { return this.category; }
	/**
	 * Sets category for the ExpenseItem object
	 *
	 * @param category a category of the expense item
	 */
	public void setCategory(String category) { this.category = category; }

	/**
	 * Gets the amount from the ExpenseItem object
	 *
	 * @return a amount of the expense item as double
	 */
	public double getAmount() { return this.amount; }
	/**
	 * Sets amount for the ExpenseItem object
	 *
	 * @param amount the cost of the expense item
	 */
	public void setAmount(double amount) { this.amount = amount; }

	/**
	 * Gets the dateAdded from the ExpenseItem object
	 *
	 * @return dateAdded, the time and date an expense item was created as LocalDate
	 */
	public LocalDate getDateAdded() { return this.dateAdded; }

	/**
	 * Gets the income from the ExpenseItem object
	 *
	 * @return a income of the expense item as boolean
	 */
	public boolean getIncome() { return this.income; }
	/**
	 * Sets income for the ExpenseItem object
	 *
	 * @param income the income of the expense item
	 */
	public void setIncome(boolean income) { this.income = income; }
}
