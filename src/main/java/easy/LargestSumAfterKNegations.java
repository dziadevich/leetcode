package easy;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class LargestSumAfterKNegations {

    public static void main(String[] args) {
//        System.out.println(LargestSumAfterKNegations.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));

//        System.out.println(LargestSumAfterKNegations.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));

        System.out.println(LargestSumAfterKNegations.bitwiseComplement(5));
    }


    public static int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : A) {
            pq.offer(x);
        }
        while (K > 0) {
            pq.offer(-pq.poll());
            K--;
        }
        return pq.stream().mapToInt(i -> i).sum();
    }

    public static int bitwiseComplement(int n) {
        int mlog = (int) Math.log(n);
        int tlog = (int) Math.log(2);
        int log = (int) (Math.log(n) / Math.log(2));
        ++log;
        int setBits = (1 << log) - 1;
        int resp = setBits ^ n;
        return setBits ^ n;
    }
}
