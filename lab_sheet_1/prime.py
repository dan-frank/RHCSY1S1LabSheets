primeNumList = []
primeCount = 101
is_prime = False

i = 1
while i < primeCount:
	j = 0
	primeNumLength = len(primeNumList) 

	if (i % i == 0):
		for n in primeNumList:
			if (i % n == 0):
				is_prime = False
				break
		if (is_prime):
			primeNumList.append(i)

	i += 1

print(primeNumList)
