package dsa;

public class KadaneAlgo {
    public static void main(String []args){
        int[] arr = new int[]{6, -6, 3, -8, 2, 3, 3, -3, -6, 0};

        int n = arr.length;

        int sum = arr[0];
        int best = arr[0];
        for(int i =1;i<n;i++){
            sum = Integer.max(arr[i],sum +  arr[i]);
            best = Integer.max(sum,best);
        }
        System.out.println(best);
    }
}
