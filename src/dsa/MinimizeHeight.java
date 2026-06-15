package dsa;

import java.util.Arrays;

public class MinimizeHeight {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,10,6,4,6,9,1};
        int k = 7;
        for(int i = 0;i< arr.length; i++){

            if(arr[i]<=k){
                System.out.println("value: " + arr[i] + " Modify: "+(arr[i]+k));
                arr[i] = arr[i]+k;
            }
            else {
                System.out.println("value: " + arr[i] + " Modify: "+(arr[i]-k));
                arr[i] = arr[i]-k;
            }
        }
        Arrays.sort(arr);
        System.out.println("Minimized height difference: " + (arr[arr.length-1] - arr[0]));

    }
}
