package easy;

/*
https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class FindNumbersEvenNumber {
    public static void main(String[] args) {
        System.out.println(FindNumbersEvenNumber.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;

        for (int num : nums) {
            if (num > 9 && num < 100 || num > 999 && num < 10000 || num == 100000)
                result++;
        }
        return result;
    }
}
