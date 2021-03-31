package medium;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnesIII().longestOnes1(
                new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new MaxConsecutiveOnesIII().longestOnes2(
                new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }


    public int longestOnes1(int[] A, int K) {
        int n = A.length, l = 0, maxi = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == 0)
                cnt++;

            while (cnt > K && l <= i) {
                if (A[l] == 0)
                    cnt--;
                l++;
            }
            maxi = Math.max(i - l + 1, maxi);
        }
        return maxi;
    }

    public int longestOnes2(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int end = 0;
        int start = 0;
        int count = 0;
        int res = 0;
        while (end < A.length) {
            if (A[end] == 0) {
                count++;
            }
            while (start <= end && count > K) {
                if (A[start] == 0) {
                    count--;
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
