package medium;

import java.util.Stack;

/*
https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef")); //Output: "abcabccdcdcdef"
    }

    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                temp.append(res.repeat(count));
                res = temp.toString();
                index++;
            } else {
                res += s.charAt(index);
                index++;
            }
        }
      return res;
    }
}
