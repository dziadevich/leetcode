package facebook;

import java.util.*;
/*
    https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=146466059993201
 */
public class PassingYearbooks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PassingYearbooks().findSignatureCounts(new int[]{2, 1}))); //2,2
        System.out.println(Arrays.toString(new PassingYearbooks().findSignatureCounts(new int[]{1, 2}))); // 1,1
    }

    int[] findSignatureCounts(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];
        List<LinkedHashSet<Integer>> loops = new ArrayList<>();

        Arrays.fill(result, 0);
        for (int i = 0; i < arr.length; i++) {
            for(LinkedHashSet<Integer> loop : loops) {
                if(loop.contains(arr[i])) {
                    result[i]=loop.size();
                    break;
                }
            }

            if(result[i]==0) {
                LinkedHashSet<Integer> loop = new LinkedHashSet<>();
                loop.add(arr[i]);
                int index = arr[i] - 1;
                while (index != i) {
                    loop.add(arr[index]);
                    index = arr[index] - 1;
                }
                result[i] = loop.size();
                loops.add(loop);
            }
        }
        return result;
    }
}
