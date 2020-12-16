class Budget {
	private double limit;
	private String category;

	/**
	 * Creates Budget Class Object
	 *
	 * @param limit the spending limit
	 * @param category the item catagory the limit is for
	 */
	public Budget(double limit, String category) {
		this.limit = limit;
		this.category = category;
	}

	/**
	 * Sets the limit for the Budget object
	 *
	 * @param limit the limit of the budget
	 */
	public void setLimit(double limit) { this.limit = limit; }
	/**
	 * Gets the limit from the Budget object
	 *
	 * @return the limit of the budget as double
	 */
	public double getLimit() { return limit; }

	/**
	 * Sets the category for the Budget object
	 *
	 * @param category the category of the budget
	 */
	public void setCategory(String category) { this.category = category; }
	/**
	 * Gets the category from the Budget object
	 *
	 * @return the category of the budget as String
	 */
	public String getCategory() { return category; }
}