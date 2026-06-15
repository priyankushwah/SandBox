package dsa;

public class KadaneAlgo {
    public static void main(String []args){
        int[] arr = new int[]{6, -6, 3, -8, 2, 3, 3, -3, -6, 0};

        int n = arr.length;

        int sum = arr[0];
        int best = arr[0];
        for(int i = 1;i<n;i++){
            if(arr[i] > sum && sum <= 0){
                sum = arr[i];  // throw the items of bag
                if(sum>best){
                    best = arr[i];
                }
            }
            else {
                best = Math.max(best, arr[i] + sum);
                sum = sum + arr[i];
            }
        }
        System.out.println(best);
    }
}
