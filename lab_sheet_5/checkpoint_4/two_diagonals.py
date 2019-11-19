
size = int(input("Size of the square: "))

for i in range(size):
    line = ""

    for j in range(size):
        if i == j:
            line += "x"
        else:
            line += "o"

    print(line)
