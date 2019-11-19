import random as r
import math as m

randNums = []
numCheck = [0,0,0,0,0,0,0,0,0,0]
chiSquare = 0.0
upperBound = 1000
randNumUpperBound = 10
chiExpected = upperBound / randNumUpperBound

i = 0
while i < upperBound:
    randNum = r.randint(1,randNumUpperBound)
    randNums.append(randNum)
    i += 1

for j in randNums:
    numCheck[j - 1] += 1

for k in numCheck:
    chiSquare += m.pow((k - chiExpected), 2)

chiSquare = chiSquare / chiExpected

print(chiSquare)
