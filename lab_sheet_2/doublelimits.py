x = 0.2;
y = 0.1;
z = x - y;

x2 = 0.3;
y2 = 0.2;
z2 = x2 - y2;

print(str(x) + " - " + str(y) + " = " + str(z))
print("Formatted to 20 decimal places...")
print(str(format(x, '.20f')) + " - " + str(format(y, '.20f')) + " = " + str(format(z, '.20f')) + "\n")

print(str(x2) + " - " + str(y2) + " = " + str(z2))
print("Formatted to 20 decimal places...")
print(str(format(x2, '.20f')) + " - " + str(format(y2, '.20f')) + " = " + str(format(z2, '.20f')) + "\n")

print("When running the same statement in python with high level precision then we can see that the doubles aren't what they appear to be which can lead to odd floating errors if proper care isn't taken")