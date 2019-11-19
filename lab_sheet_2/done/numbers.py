import time

x = 0
numLoop = True

while numLoop:
    print(x)
    x += 1
    
    time.sleep(0.5)

    if(x > 50):
        numLoop = False
