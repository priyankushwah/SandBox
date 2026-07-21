package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import util.LoggerUtil;

public class Fibonacci {
    
    private static final Logger log = LoggerUtil.getLogger(Fibonacci.class);

    public static void main(String[] args){
        ArrayList<Long> dp = new ArrayList<>(Arrays.asList(0L,1L));
        log.warning("Initial DP array initialized: " + dp);
        int n = 10; // Example value, replace with actual input
        for(int i = 2; i < n; i++){
            dp.add(dp.get(i-1)+ dp.get(i-2));
        }
        log.info("Fibonacci sequence: " + dp);
        log.info("Last Fibonacci number: " + dp.get(n - 1));
    }


}
