
# the dimensions of the array
height = 3
width = 4

# the list
# list2d = [ [0] * width for r in range(height) ]
list2d = [[0] * width] * height

# fill the 2-dim array
for i in range(height):
    for j in range(width):
        list2d[i][j] = " " + str(i) + str(j)

# print the 2-dim array
for i in range(height):
    line = ""
    for j in range(width):
        line += list2d[i][j]

    print(line)

print("The expression \"[[0] * width] * height\" works in two steps")
print("It calculates the first list with \"[0] * width\".")
print("It then calculates the second list that insted of containing [0] contains the list of 10 0's as defined by this part, \"[[0] * width]\".")
print("Creating the 2D array that prints out at the end")