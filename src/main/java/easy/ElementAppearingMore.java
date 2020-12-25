package easy;

/*
https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
public class ElementAppearingMore {
    public static void main(String[] args) {
        System.out.println(ElementAppearingMore.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }

    public static int findSpecialInteger(int[] arr) {
        int count = arr.length / 4;

        int current = arr[0];
        int cur_count = 1;

        for (int i=1; i<arr.length; i++){
            if (arr[i] == current) {
                cur_count++;

                if (cur_count > count) {
                    return current;
                }

            } else {
                current = arr[i];
                cur_count = 1;
            }
        }
        return current;
    }
}
