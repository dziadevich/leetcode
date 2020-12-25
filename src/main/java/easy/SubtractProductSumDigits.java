package easy;

/*
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractProductSumDigits {
    public static void main(String[] args) {
        System.out.println(SubtractProductSumDigits.subtractProductAndSum(234));
    }

    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while(n > 0){
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }

        return product - sum;
    }
}
