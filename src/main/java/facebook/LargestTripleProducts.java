package facebook;

/*
https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=510655302929581
 */
public class LargestTripleProducts {


    int[] findMaxProduct(int[] arr) {
        // Write your code here
        if (arr.length == 1) {
            return new int[]{-1};
        } else if (arr.length == 2) {
            return new int[]{-1, -1};
        }
        int[] result = new int[arr.length];
        int small = -1, med = -1, high = -1;
        int count = 0;
        for (int i : arr) {
            if (i > high) {
                small = med;
                med = high;
                high = i;
            } else if (i > med) {
                small = med;
                med = i;
            } else if (i > small) {
                small = i;
            }
            if(small == -1 || med == -1 || high == -1){
                result[count++] = -1;
            }else{
                result[count++] = small*med*high;
            }
        }

        return result;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] expected_1 = {-1, -1, 6, 24, 60};
        int[] output_1 = findMaxProduct(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {-1, -1, 56, 56, 140, 140};
        int[] output_2 = findMaxProduct(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new LargestTripleProducts().run();
    }
}
