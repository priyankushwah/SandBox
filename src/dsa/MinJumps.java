package dsa;

public class MinJumps {
    public static void main(String[] args) {
        int[] arr = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
        int n = arr.length;
        System.out.println(minJumps(arr,n));
    }

    public static int minJumps(int[] arr,int n){

        if(n == 1 && arr[0]>=0)return 0;
        if(arr[0] == 0) return -1;
        int count = 1;
        for(int i = 0;i<n;){
            int max = 0;
            int jumpsFrom = 0;
            if(arr[i]>=n-i-1)return count;
            for(int j = i+1;j<=i+arr[i] && j<n;j++){
                if(j+arr[j]>max){
                    max = arr[j]+j;
                    jumpsFrom = j;
                }
            }
            if(jumpsFrom == 0)return -1;
            i = jumpsFrom;
            count++;
            System.out.println(count+"nd jumps from index: j = "+ jumpsFrom + " and value is: "+arr[i]);
        }
        return count;
    }
}


// its not about finding the max its about finding the rigth move so checking while searching max check the reach as well as from
// it is a brute force but still it passed I dont know lets see