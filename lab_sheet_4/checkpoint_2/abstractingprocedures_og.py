n = 5
k = 3

x = 1
for i in range(1, n):
	x = x * i

y = 1
for i in range(1, k):
	y = y * i

z = 1
for i in range(1, (n - k)):
	z = z * i

c = x / (y * z)

p = 1
for i in range(1, k):
	p = p * (1 / 6)

q = 1
for i in range(1, (n - k)):
	q = q * (5 / 6)

result = c * p * q

print(result)