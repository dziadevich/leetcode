package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum
 * of the non included elements in such subsequence.
 * <p>
 * If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple
 * solutions,
 * return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained
 * by erasing some (possibly zero) elements from the array.
 * <p>
 * Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted
 * in non-increasing order.
 */
public class MinimumSubsequenceinNonIncreasingOrder {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum1 = 0, sum2 = 0;
        for (int num : nums) sum1 += num;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            sum2 += nums[i];
            sum1 -= nums[i];
            if (sum2 > sum1) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSubsequenceinNonIncreasingOrder()
                .minSubsequence(new int[]{4, 3, 10, 9, 8}));
    }
}
