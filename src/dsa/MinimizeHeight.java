package dsa;

import java.util.Arrays;

public class MinimizeHeight {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,6,10,12};
        int k = 7;
        Arrays.sort(arr);
        int n = arr.length;
        int ans = arr[n-1]-arr[0];
        for(int i = 1;i<n;i++){
            int min = Math.min(arr[0]+k,arr[i]-k);
            int max = Math.max(arr[n-1]-k,arr[i-1]+k);
            ans = Math.min(ans,max-min);
        }

        System.out.println(ans);

    }
}
