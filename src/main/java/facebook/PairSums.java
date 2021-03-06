package facebook;

import java.util.Arrays;

public class PairSums {
    public static void main(String[] args) {
        System.out.println(new PairSums().numberOfWays(new int[]{1, 2, 3, 4, 3}, 6)); // 2
        System.out.println(new PairSums().numberOfWays(new int[]{1, 5, 3, 3, 3}, 6)); // 4
    }

    int numberOfWays(int[] arr, int k) {
        int count = 0;
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l != r) {
            if (arr[l] + arr[r] == k) {
                count++;
                int i = r;
                while (arr[l] + arr[--i] == k && i > l){
                    count++;
                }
                l++;
            }else if(arr[l] + arr[r] < k){
                l++;
            }else{
                r--;
            }
        }
        return count;
    }
}
