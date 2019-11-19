
// Note: run with
//
//  java -enableassertions TestIsPrime

public class TestIsPrime {
    public static void testIsPrime(int value) {
        assert IsPrime.isPrime(value);
    }

    public static void testIsNotPrime(int value) {
        assert !IsPrime.isPrime(value);
    }

    public static void testAll() {
        testIsNotPrime(72);
        testIsNotPrime(0);
        testIsNotPrime(1);
        testIsPrime(2);
        testIsPrime(3);

        testIsPrime(5);
        testIsNotPrime(6);
        testIsPrime(7);
        testIsNotPrime(25);
    }

    public static void main(String[] args) {
        testAll();
    }
}