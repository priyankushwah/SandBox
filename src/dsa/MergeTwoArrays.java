package dsa;

import java.util.logging.Logger;
import util.LoggerUtil;

//to be sorted after merge without extra space
public class MergeTwoArrays {

    private static final Logger log = LoggerUtil.getLogger(MergeTwoArrays.class);

    public static void main(String[] args){
        log.warning("Starting MergeTwoArrays program");
        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0, 0};
        int[] arr2 = {0, 2, 6, 8, 9};
        int n = arr2.length;
        int m = arr1.length-n;
        log.info("Initial arrays: arr1 = " + java.util.Arrays.toString(arr1) + ", arr2 = " + java.util.Arrays.toString(arr2));
        solition(arr1,arr2,n,m);
        log.info("Arrays after merging: arr1 = " + java.util.Arrays.toString(arr1));
    }

    public static void solition(int[] arr1, int[] arr2, int n, int m){
        log.info("Starting merge operation with n = " + n + ", m = " + m);
        if(m == 0){
            if (n >= 0) System.arraycopy(arr2, 0, arr1, 0, n);
            return;
        }
        if(n == 0){
            return;
        }
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(arr2[j]>arr1[i]){
                arr1[k] = arr2[j];
                j--;
            }
            else{
                arr1[k] = arr1[i];
                i--;
            }
            k--;
        }
        while(j>=0){
            arr1[k] = arr2[j];
            j--;k--;
        }
    }
}
