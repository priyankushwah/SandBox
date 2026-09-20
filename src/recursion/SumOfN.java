package recursion;

import dp.Fibonacci;
import util.LoggerUtil;
import java.util.logging.Logger;

public class SumOfN {
    private static final Logger log = LoggerUtil.getLogger(Fibonacci.class);

    public static int sum(int n){
        if(n>0)
            return n + sum(n-1);
        return 0;
    }

    public static void main(String[] args){
        int n = 6;
        log.warning("Starting SumOfN with n = " + n);
        log.info("Sum of first " + n + " natural numbers is: " + sum(n));
    }

}
