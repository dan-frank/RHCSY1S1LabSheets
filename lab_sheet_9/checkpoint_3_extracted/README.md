# Expenses System [OPEN REPO](https://github.com/RHUL-CS-Projects/CS1822-1920-Lab9-Group-16)

Allow users to track their expenditure

## Notes

### Key

- (C) | Class
- (M) | Method

## MUST DO

- [x] Document your code in JavaDoc style

## Features

- [x] Interactive UI - @dan-frank
- [x] Edit - @dan-frank @meganhardman
- [x] Analysis - @meganhardman

### Edit Mode (M) - @dan-frank @meganhardman

- [x] Users can add/delete expense items (C) 
- [x] Add budgets (C)

#### Expense Items - @dan-frank

##### Class Object

- [x] Description
- [x] Category
- [x] Amount
- [x] Automatic date of when expense was added
- [x] Deside whether income / outcome

##### Main Method Controller

- [x] Add ExpenseItem to HashMap
- [x] Delete ExpenseItem from HashMap
- [x] Update ExpenseItem

#### Budgets (C) - @meganhardman

##### Class Object

- [x] Limit
- [x] Category

##### Main Method Controller

- [x] Limit total spend
- [x] Limit by category
- [x] Warn user when budget is running low (below 20%)

### Analysis Mode (M) - @meganhardman

- [x] Breakdown of expenditure by category
- [x] Total expenditure by category
- [x] Total income by category
- [x] Average expenditure by item
- [x] Total expenditure
- [x] Total average expenditure

### UI - @dan-frank

- [x] Control expense items
    - [x] Add expense item
    - [x] Remove expense item
    - [x] Update expense item
- [x] Control budgets
    - [x] Add budgets
    - [x] Remove budget
    - [x] Update budget
- [x] Analysis
    - [x] View total average spend
    - [x] View expenditure per item
    - [x] View expenditure by category
    - [x] View income by category
    - [x] View analysis breakdown
- [x] Added barchart for analysis breakdown

## Examples

### JavaDoc Comment Style

```
/**
 * Calculate the squared sum of a and b
 *
 * @param a the first value
 * @param b the second value
 * @return (a+b) squared
 */
public int squareSum(int a, int b) { ... }
```
