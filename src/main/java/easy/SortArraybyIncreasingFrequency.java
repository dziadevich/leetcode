package easy;

import java.util.*;

public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                SortArraybyIncreasingFrequency.frequencySort(new int[]{2, 3, 1, 3, 2})));
    }

    public static int[] frequencySort(int[] nums) {
        int[] copyOfNums = nums.clone(); // make copy of input array and sort it
        Arrays.sort(copyOfNums);

        Map<Integer, List<Integer>> frequencyTable = new HashMap<>();

        for (int i = 0; i < copyOfNums.length; ++i) {

            int count = 1; // initialize frequency counter for the current number

            while (i < copyOfNums.length - 1 && copyOfNums[i] == copyOfNums[i + 1]) {
                ++count; // our frequency counter for the current number
                ++i; // our index into nums[]
            }

            // store the frequency count for this number in frequencyTable
            if (!frequencyTable.containsKey(count)) {
                frequencyTable.put(count, new ArrayList<Integer>());
            }
            frequencyTable.get(count).add(copyOfNums[i]); // the List<Integer> stores numbers with equal frequency in nums[]
        }

        // now we'll overwrite the copyOfNums[] array with the numbers in the correct sequence
        int cursor = 0;
        for (int i = 0; i <= 100; i++) { // we'll traverse entries in frequencyTable in ascending order, checking for valid keys

            List<Integer> li = frequencyTable.get(i);
            if (li == null) {
                continue;
            }

            for (int k = li.size() - 1; k >= 0; --k) {
                for (int m = 0; m < i; ++m) {
                    copyOfNums[cursor++] = li.get(k);
                }
            }
        }

        return copyOfNums;
    }
}
