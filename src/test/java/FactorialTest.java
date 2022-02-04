import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @Test
    public void calculateFactorialForZero() {
        BigInteger result = factorial.calculateFactorial(0);

        assertEquals(result, new BigInteger("1"));
    }

    @Test
    public void calculateFactorialForOne() {
        BigInteger result = factorial.calculateFactorial(1);

        assertEquals(result, new BigInteger("1"));
    }

    @Test
    public void calculateFactorialForNumber() {
        BigInteger result = factorial.calculateFactorial(5);

        assertEquals(result, new BigInteger("120"));
    }

    @Test
    public void testFactorialTask() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        BigInteger result = forkJoinPool.invoke(new Factorial.FactorialTask(BigInteger.valueOf(4)));

        assertEquals(result, new BigInteger("24"));
    }
}
