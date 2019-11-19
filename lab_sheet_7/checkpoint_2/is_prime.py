
import math

def is_prime(num):
    if num <= 1:
        return False

    maxFactor = math.floor(math.sqrt(num))

    for i in range(2, maxFactor + 1):
        if num % i == 0:
            return False

    return True

def main():
    num = int(input("Enter a number to test for primality: "))

    if is_prime(num):
        print("The number is prime")
    else:
        print("The number is not prime")

if __name__ == "__main__":
    main()
