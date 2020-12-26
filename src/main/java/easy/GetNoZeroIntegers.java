package easy;

import java.util.Arrays;

public class GetNoZeroIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(GetNoZeroIntegers.getNoZeroIntegers(1000)));
    }

    public static int[] getNoZeroIntegers(int n) {
        int pos = 1;
        int m = 0, num = n;

        while (n > 1) {
            int d = (n % 10);
            if (d == 1) {
                m += 2 * pos;
                n -= 2;
            } else {
                m += pos;
                n -= 1;
            }

            pos *= 10;
            n /= 10;
        }

        return new int[]{num - m, m};
    }
}
