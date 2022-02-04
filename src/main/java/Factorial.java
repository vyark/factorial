import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Factorial {

    public static void main(String[] args) {
        int number = 3;

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.invoke(new FactorialTask(BigInteger.valueOf(number))));

        System.out.println(calculateFactorial(number));
    }

    protected static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    static class FactorialTask extends RecursiveTask<BigInteger> {
        private BigInteger number;

        public FactorialTask(BigInteger number) {
            this.number = number;
        }

        @Override
        protected BigInteger compute() {
            if (number.compareTo(BigInteger.valueOf(1)) <= 0) {
                return BigIntegerMath.factorial(number.intValue());
            }
            FactorialTask subtask = new FactorialTask(number.subtract(BigInteger.ONE));
            subtask.fork();
            return number.multiply(subtask.join());
        }
    }
}


