package medium;
/*
https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println('a' - 'A');
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }

    public int characterReplacement(String s, int k) {

        // initiate a array to store the occurrence of each character in s
        int[] seen = new int[26];

        // initiate two pointers
        // left for optimization
        // right for expanding the window
        int left = 0;
        int right = 0;

        // initiate result max
        int max = 0;

        // initiate majority
        int majority = 0;

        // traverse the string
        while (right < s.length()) {

            // expanding the window
            int r = s.charAt(right) - 'A';

            right ++;

            seen[r] ++;

            majority = Math.max(majority, seen[r]);

            // check the validity
            if (right - left - majority > k) {

                int l = s.charAt(left) - 'A';

                left += 1;

                seen[l] -= 1;
            }

            // update the result
            max = Math.max(max, right - left);
        }

        return max;
    }
}
