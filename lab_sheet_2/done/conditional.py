print("Enter the number 1")
condIf = input("Input: ")

if(condIf.isnumeric()):
    if (int(condIf) == 1):
        print("The expression evaluates to True\nYou have correctly input the number 1")
    else:
        print("The expression evaluates to False\nYou have incorrectly input the number 1")
else:
    print("The expression evaluates to False\nYou have incorrectly a string")
