package facebook;

import java.util.Arrays;
import java.util.LinkedList;

/*
https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2444722699191194
 */
public class SeatingArrangements {
    int minOverallAwkwardness(int[] arr) {
        // Write your code here
        Arrays.sort(arr);

        int len = arr.length;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = len-1; i >= 0; i--){
            if (i % 2 == 0) {
                list.addLast(arr[i]);
            }else{
                list.addFirst(arr[i]);
            }
        }

        int max = 0;

        int prev = list.get(len-1);

        for (int i=0; i < len; i++){
            max = Math.max(Math.abs(list.get(i)-prev), max);
            prev = list.get(i);
        }

        return max;
    }
    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        int output_1 = minOverallAwkwardness(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        int output_2 = minOverallAwkwardness(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new SeatingArrangements().run();
    }
}
