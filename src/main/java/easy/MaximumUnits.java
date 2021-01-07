package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnits {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        int output = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            if (boxTypes[i][0] <= truckSize) {
                output += (boxTypes[i][0] * boxTypes[i][1]);
                truckSize -= boxTypes[i][0];
            } else {
                output += (truckSize * boxTypes[i][1]);
                return output;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(MaximumUnits.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }
}
