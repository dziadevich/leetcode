package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaximumLengthConcatenatedString {

    public static void main(String[] args) {
        System.out.println(new MaximumLengthConcatenatedString()
                .maxLength(Arrays.asList("cha", "r", "act", "ers")));
    }

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;

        List<List<String>> res = new ArrayList<>();
        dfs(0, arr, new HashSet<Character>(), new ArrayList<String>(), res);

        int maxLen = 0;
        for (List<String> list : res) {
            int count = 0;
            for (String s : list) {
                count += s.length();
            }
            maxLen = Math.max(count, maxLen);
        }

        return maxLen;
    }

    private void dfs(int index, List<String> arr, HashSet<Character> set, List<String> path, List<List<String>> res) {
        if (index == arr.size()) {
            res.add(new ArrayList<String>(path));
            return;
        }

        HashSet<Character> newSet = (HashSet) set.clone();
        String curr = arr.get(index);

        boolean isUnique = true;
        for (int i = 0; i < curr.length(); i++) {
            if (newSet.contains(curr.charAt(i))) {
                isUnique = false;
            }
            newSet.add(curr.charAt(i));
        }

        if (isUnique) {
            path.add(curr);
            dfs(index + 1, arr, newSet, path, res);
            // backtracking
            path.remove(path.size() - 1);
        }

        dfs(index + 1, arr, set, path, res);
    }
}
