package easy;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 * Given two integer arrays startTime and endTime and given an integer queryTime.
 * <p>
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
 * <p>
 * Return the number of students doing their homework at time queryTime. More formally,
 * return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
 */
public class NumberofStudentsDoingHomework {

    public static void main(String[] args) {
        System.out.println(NumberofStudentsDoingHomework
                .busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                result++;
            }
        }

        return result;
    }
}
