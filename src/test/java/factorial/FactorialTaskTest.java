package factorial;

import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;

public class FactorialTaskTest {

    @Test
    public void testFactorialTask() {
        FactorialTask factorialTask = new FactorialTask(new BigInteger("6"));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        BigInteger result = forkJoinPool.invoke(factorialTask);

        assertEquals(result, new BigInteger("720"));
    }

    @Test
    public void testFactorialTask_valueIsOne() {
        FactorialTask factorialTask = new FactorialTask(new BigInteger("1"));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        BigInteger result = forkJoinPool.invoke(factorialTask);

        assertEquals(result, new BigInteger("1"));
    }
}
