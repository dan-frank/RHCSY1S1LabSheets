print("--------------------------------------------------------\n")

print("BIDMAS Proof\n")

print("1 + 4 * 3 - 8 / 2")
print("Est: 9")
expres1 = 1.0 + 4.0 * 3.0 - 8.0 / 2.0
expres12 = 1.0 + 4.0 * 3.0 - 8.0 // 2.0
print("Ans: " + str(expres1))
print("// Ans: " + str(expres12) + "\n")

print("(1 + 4) * 3 - 8 / 2")
print("Est: 11")
expres2 = (1.0 + 4.0) * 3.0 - 8.0 / 2.0
expres22 = (1.0 + 4.0) * 3.0 - 8.0 // 2.0
print("Ans: " + str(expres2))
print("// Ans: " + str(expres22) + "\n")

print("1 + 4 * (3 - 8) / 2")
print("Est: -9")
expres3 = 1.0 + 4.0 * (3.0 - 8.0) / 2.0
expres32 = 1.0 + 4.0 * (3.0 - 8.0) // 2.0
print("Ans: " + str(expres3))
print("// Ans: " + str(expres32) + "\n")

print("(1 + 4) * (3 - 8) / 2")
print("Est: -12.5")
expres4 = (1.0 + 4.0) * (3.0 - 8.0) / 2.0
expres42 = (1.0 + 4.0) * (3.0 - 8.0) // 2.0
print("Ans: " + str(expres4))
print("// Ans: " + str(expres42) + "\n")

print("--------------------------------------------------------\n")

print("BOOLEAN Proof\n")

print("True or True and False")
print("Est: True")
print("Ans: " + str(True or True and False) + "\n")

print("True or (True and False)")
print("Est: True")
print("Ans: " + str(True or (True and False)) + "\n")

print("(True or True) and False")
print("Est: False")
print("Ans: " + str((True or True) and False) + "\n")

print("not True or True and False")
print("Est: False")
print("Ans: " + str(not True or True and False) + "\n")

print("not (True or True and False)")
print("Est: False")
print("Ans: " + str(not (True or True and False)) + "\n")

print("not ((True or True) and False)")
print("Est: True")
print("Ans: " + str(not ((True or True) and False)) + "\n")

print("--------------------------------------------------------\n")

print("OPERATOR BOOLEAN Proof\n")

print("10 == 5")
print("Est: False")
print("Ans: " + str(10 == 5) + "\n")

print("10 > 5")
print("Est: True")
print("Ans: " + str(10 > 5) + "\n")

print("5 == 5")
print("Est: True")
print("Ans: " + str(5 == 5) + "\n")

print("False or (5 != 4)")
print("Est: True")
print("Ans: " + str(False or (5 != 4)) + "\n")

print("False and (5 != 4)")
print("Est: False")
print("Ans: " + str(False and (5 != 4)) + "\n")

print("5 == 11 - 6")
print("Est: True")
print("Ans: " + str(5 == 11 - 6) + "\n")

print("3 - 2 == 2 - 1")
print("Est: True")
print("Ans: " + str(3 - 2 == 2 - 1) + "\n")

print("--------------------------------------------------------")