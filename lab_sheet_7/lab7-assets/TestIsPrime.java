
// Note: run with
//
//  java -enableassertions TestIsPrime

public class TestIsPrime {
    public static void testSimplePrime() {
        assert IsPrime.isPrime(72);
    }

    // Add new test methods here

    public static void testAll() {
        testSimplePrime();
        // Call new tests here
    }

    public static void main(String[] args) {
        testAll();
    }
}
