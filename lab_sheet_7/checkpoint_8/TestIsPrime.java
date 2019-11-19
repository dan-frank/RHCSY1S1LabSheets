//
// Note: run with
//
//  javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar TestIsPrime.java
//  java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestIsPrime
//

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestIsPrime {
    @Test
    public void evaluatesPrime() {
        IsPrime isPrime = new IsPrime();
        assertEquals(false, isPrime.isPrime(72));
        assertEquals(false, isPrime.isPrime(0));
        assertEquals(false, isPrime.isPrime(1));
        assertEquals(true, isPrime.isPrime(2));
        assertEquals(true, isPrime.isPrime(3));
    }
}