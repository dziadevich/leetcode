package facebook;

import java.util.HashMap;
import java.util.Map;
/*
    https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2869293499822992
 */
public class ReverseToMakeEqual {
    public static void main(String[] args) {
        System.out.println(new ReverseToMakeEqual().areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2}));
    }

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur : array_a) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (int cur : array_b) {
            if (!map.containsKey(cur)) {
                return false;
            }
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) == 0) {
                map.remove(cur);
            }
        }
        return map.size() == 0;
    }
}
