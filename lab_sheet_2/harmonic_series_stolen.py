n = input("Enter n:")

def harmonic(n): #original harmonic series
     a=1
     b=1
     for d in range(2, n+1):
         a = a*d+b
         b = b*d
     return(a,b)


def harmonic_lt(n): #_lt: harmonic series with lowest terms
                    #not pythonic, but simple
    a=1
    b=1
    for d in range(2, n+1):
        a = a*d+b
        b = b*d

    y=a
    x=b
    while x > 0:
        re = y % x
        y = x
        x = re

    a=a/y
    b=b/y
    return(a,b)

print harmonic(n)
print harmonic_lt(n)