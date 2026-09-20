package recursion;

import dp.Fibonacci;
import util.LoggerUtil;
import java.util.logging.Logger;

public class PrintNTimes {
    private static final Logger log = LoggerUtil.getLogger(Fibonacci.class);

    public static void printNTimes(int n){
//        log.info("Printing number: " + n);
        if(n>0) {
            printNTimes(n-1);
        }
        log.info("Printing number: " + n);
    }

    public static void main(String[] args){
        int n = 9;
        log.warning("Starting PrintNTimes with n = " + n);
        printNTimes(n);
    }

}
