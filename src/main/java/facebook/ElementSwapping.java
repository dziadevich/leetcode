package facebook;

/*
https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=838749853303393
 */
public class ElementSwapping {

    public int[] findMinArray(int[] arr, int k) {
        for(int i =0; i < arr.length && k >0; i++) {
            int minIndex = findMinAtDistanceK(arr, i, k);
            //if minimum element is already at position i, nothing to do
            if(minIndex == i) {
                continue;
            }
            swap(arr, i, minIndex);
            // we have used up minindex-i swaps
            k -= minIndex - i;
        }
        return arr;
    }

    private int findMinAtDistanceK(int [] arr, int start, int k) {
        int index = 0, min = Integer.MAX_VALUE;
        // find minimum element at distance k from start
        for(int i=start; i <= start + k; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index =i;
            }
        }
        return index;
    }

    private void swap(int [] arr, int start, int end) {
        //move element at position end to start
        while(end > start) {
            int temp = arr[end];
            arr[end] = arr[end-1];
            arr[end-1] = temp;
            end--;
        }
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
        }
        else {
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
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        check(expected_1, output_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ElementSwapping().run();
    }
}
