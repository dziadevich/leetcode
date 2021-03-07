package facebook;

import java.util.Arrays;
import java.util.Stack;
/*
    https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=226517205173943
 */
public class ContiguousSubarrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ContiguousSubarrays().countSubarrays(new int[]{3, 4, 1, 6, 2})));
    }

    int[] countSubarrays(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        stack.add(0);
        for (int i = 1; i < n; i++) {
            while (stack.peek() != -1 && arr[i] > arr[stack.peek()])
                stack.pop();
            output[i] += i - stack.peek() - 1;
            stack.add(i);
        }

        stack.clear();
        stack.add(n);
        stack.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (stack.peek() != n && arr[i] > arr[stack.peek()])
                stack.pop();
            output[i] += stack.peek() - i - 1;
            stack.add(i);
        }
        return output;
    }
}
