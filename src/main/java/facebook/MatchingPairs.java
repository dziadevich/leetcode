package facebook;

import java.util.HashSet;
import java.util.Set;

public class MatchingPairs {
    public static void main(String[] args) {
        System.out.println(new MatchingPairs().matchingPairs("abcd", "abcb"));
    }

    int matchingPairs(String s, String t) {
        // Write your code here
        Set<String> mismatchS = new HashSet<>();
        char[] sToChar = s.toCharArray();
        char[] tToChar = t.toCharArray();
        int matching =0;
        for (int i =0;i<sToChar.length;i++) {
            if(sToChar[i]!=tToChar[i]) {
                mismatchS.add(sToChar[i]+""+tToChar[i]);
            }
            else
                matching++;
        }
        for(String mism : mismatchS) {
            String reverse=mism.charAt(1)+""+mism.charAt(0);
            if(mismatchS.contains(reverse)) {
                return matching+2;
            }
        }
        if(mismatchS.size()<=1)
            matching--;
        if(mismatchS.size()==0)
            matching--;
        return matching;
    }
}
