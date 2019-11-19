
arrayLength = int(input("Enter the length of the array: "))

numbers = [0] * arrayLength

for i in range(arrayLength):
  numbers[i] = 1

for i in range(arrayLength):
  print("numbers[" + str(i) + "] = " + str(numbers[i]))
