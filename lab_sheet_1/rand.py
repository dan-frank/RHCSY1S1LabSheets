import random as r

print("Random numbers \n")

i = 0
while i < 10:
    print(r.randint(0,10))
    i += 1

print("Random even Numbers")

i = 0
while i < 10:
    print(r.randint(0,5) * 2)
    i += 1

print("Random Floatds")

i = 0
while i < 10:
    print(r.uniform(0,10))
    i += 1
