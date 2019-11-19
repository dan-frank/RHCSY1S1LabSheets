
import math

def is_prime(num):
    # eliminate even numbers early
    if num % 2 == 0:
        return False

    maxFactor = math.floor(math.sqrt(num))

    for i in range(2, maxFactor):
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
