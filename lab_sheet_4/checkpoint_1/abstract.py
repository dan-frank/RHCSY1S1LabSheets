import math

def discriminant(a, b, c):
	disc = 0.0
	disc = (b * b) - (4 * a * c)
	return math.sqrt(disc)

# ( -b +- sqrt(b^2-4ac^2) ) / 2a
a = 2.0
b = 3.0
c = -5.0
x1 = 0.0
x2 = 0.0

print("The program calculates the quadratic formula.")

x1 = ((b*-1) - discriminant(a,b,c)) / (a*a)
x2 = ((b*-1) + discriminant(a,b,c)) / (a*a)

print("The quadratic formula x="+str(a)+"x^2+"+str(b)+"x+"+str(c)+" results in...")
print("x1 = " + str(x1))
print("x2 = " + str(x2))