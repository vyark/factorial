package factorial;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<BigInteger> {
    private BigInteger number;

    public FactorialTask(BigInteger number) {
        this.number = number;
    }

    @Override
    public BigInteger compute() {
        if (number.compareTo(BigInteger.valueOf(1)) <= 0) {
            return BigIntegerMath.factorial(number.intValue());
        }
        FactorialTask subtask = new FactorialTask(number.subtract(BigInteger.ONE));
        subtask.fork();
        return number.multiply(subtask.join());
    }
}
