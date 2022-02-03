package google;

import java.util.*;

public class Hard {
    public static void main(String[] args) {
        System.out.println(transform(Arrays.asList("ACT", "TOC"), Arrays.asList("TASC", "TORC", "GROM")));
    }

    static List<String> transform(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String s1 : l1) {
            char[] cs = s1.toCharArray();
            Arrays.sort(cs);
            set.add(new String(cs));
        }
        for (String s2 : l2) {
            char[] cs = s2.toCharArray();
            Arrays.sort(cs);
            StringBuilder sb = new StringBuilder(String.valueOf(cs));
            for (int i = 0; i < cs.length; i++) {
                sb.deleteCharAt(i);
                if (set.contains(sb.toString())) {
                    result.add(s2);
                }
                sb.insert(i, cs[i]);
            }
        }

        return result;
    }


}
