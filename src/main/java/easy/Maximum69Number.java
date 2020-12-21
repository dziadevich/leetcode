package easy;

/*
https://leetcode.com/problems/maximum-69-number/

Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 */
public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(Maximum69Number.maximum69Number(9669));
    }

    public static int maximum69Number(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        for(int i= 0; i < nums.length; i++){
            if(nums[i] == '6')
            {
                nums[i] = '9';
                return Integer.parseInt(String.valueOf(nums));
            }
        }

        return num;
    }
}
