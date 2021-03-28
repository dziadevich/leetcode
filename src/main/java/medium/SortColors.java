package medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] colors = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;

        while(white <= blue){
            if(nums[white] == 0)
                swap(nums, white++, red++);
            else if(nums[white] == 2)
                swap(nums, white, blue--);
            else
                white++;
        }
    }

    public static void swap(int[] nums, int white, int blueOrRed){
        int temp = nums[white];
        nums[white] = nums[blueOrRed];
        nums[blueOrRed] = temp;
    }
}
