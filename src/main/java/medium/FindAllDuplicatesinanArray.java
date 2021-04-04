package medium;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesinanArray {

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesinanArray().findDuplicates(new int []{  4,3,2,7,8,2,3,1 }));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1]<0){
                list.add(num);
            }
            else{
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        return list;
    }
}
