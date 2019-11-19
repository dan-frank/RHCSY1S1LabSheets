x   = 50000.0
Hx  = 0.0
HxR = 0.0
i   = 1.0

while (i <= x):
	Hx += (1 / i)
	i += 1

print("The Harmonic Series of " + str(x) + " returns " + str(Hx) + "\n")

i = x

while (i > 0):
	HxR += (1 / i)
	i -= 1

print("The reverse Harmonic Series of " + str(x) + " returns " + str(HxR) + "\n")

print("The difference between the two Harmonic series is:")
print("H - HR = " + str(Hx - HxR))
print("HR - H = " + str(HxR - Hx) + "\n")

print("I believe right to left is more accurate")
print("While it uses the same numbers for the calculation the inaccuracy is smaller earlier on, which reduces the uncertainty of the end value") 
