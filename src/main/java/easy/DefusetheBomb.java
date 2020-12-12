package easy;

import java.util.Arrays;

/**
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code
 * of length of n and a key k.
 *
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 *
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 *
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 */
public class DefusetheBomb {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                DefusetheBomb.decrypt(new int[]{5, 7, 1, 4}, -3)));
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] cleartext = new int[code.length];

        if (k > 0) {
            // get initial sum of first k numbers.
            // we'll update this sum by adding and subtracting edge numbers as needed as we traverse code[]
            int sum = 0;
            for (int t = 0; t < k; ++t) {
                sum += code[t];
            }
            for (int r = 0; r < n; ++r) {
                // update sum by:
                // subtracting departing value...
                sum -= code[(r + n) % n];
                // and adding arriving value
                sum += code[(r + k + n) % n];
                // and then assign updated sum
                cleartext[r] = sum;
            }

        } else if (k < 0) {
            k *= -1; // get absolute value of k

            // get initial sum of previous k numbers
            int sum = 0;
            for (int t = 0; t < k; ++t) {
                sum += code[-2 - t + n];
            }

            for (int r = 0; r < n; ++r) {
                // update sum by:
                // subtracting departing value...
                sum -= code[(r - 1 - k + n) % n];
                // and adding arriving value
                sum += code[(r - 1 + n) % n];
                // and then assign updated sum
                cleartext[r] = sum;
            }

        } else { // k == 0
            for (int r = 0; r < n; ++r) {
                cleartext[r] = 0;
            }
        }

        return cleartext;
    }
}
