x = 12345678910
digits = 0

print("Starting Val: " + str(x))

is_float = True
while is_float:
    digits += 1
    x = x // 10

    if (x <= 0):
        is_float = False

print("The initial variable contains " + str(digits) + " digits")
