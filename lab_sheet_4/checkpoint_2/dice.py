def diceRoll(loops):
	j = 1
	for i in range(1, loops):
		j = j * i
	return j

def probabilityRoll(loops, probability, probabilityOutOf):
	j = 1
	for i in range (1, loops):
		j = j * (probability / probabilityOutOf)
	return j

def Main(trials, outcomes, probability, probabilityOutOf):
	x = diceRoll(trials)
	y = diceRoll(outcomes)
	z = diceRoll((trials-outcomes))

	probabilityRestOf = probabilityOutOf - probability
	p = probabilityRoll(outcomes, probability, probabilityOutOf) # ?
	q = probabilityRoll((trials-outcomes), probabilityRestOf, probabilityOutOf) # ?

	c = x / (y * z)
	result = c * p * q

	return result

print(Main(5, 3, 1, 6))
print(Main(10, 3, 1, 6))
print(Main(15, 11, 1, 2))