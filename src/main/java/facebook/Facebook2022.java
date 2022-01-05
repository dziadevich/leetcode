package facebook;

import java.util.Arrays;
import java.util.LinkedList;

public class Facebook2022 {
    public static void main(String[] args) {
        System.out.println(caesarCipher("amaz", 2));
        System.out.println(equals(
                new LinkedList<>(Arrays.asList("he", "ll", "o")),
                new LinkedList<>(Arrays.asList("hel", "lo"))));
    }

    public static boolean equals(LinkedList<String> l1, LinkedList<String> l2){
        int il1 = 0;
        int il2 = 0;
        int is1 = 0;
        int is2 = 0;
        while(il1 < l1.size() && il2 < l2.size()
                && l1.get(il1).charAt(is1) == l1.get(il1).charAt(is1)){
            is1++;
            is2++;
            if(l1.get(il1).length() == is1){
                is1 = 0;
                il1++;
            }
            if(l2.get(il2).length() == is2){
                is2 = 0;
                il2++;
            }
        }
        System.out.println(il1);
        System.out.println(il2);
        System.out.println(is1);
        System.out.println(is2);
        return il1 == l1.size() && il2 == l2.size() && is1 == 0 && is2 == 0;
    }

    public static String caesarCipher(String s, int k){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            int diff = (c - 'a' + k) % 26;
            sb.append((char)('a' + diff));
        }
        return sb.toString();
    }
}
