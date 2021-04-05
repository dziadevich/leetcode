package facebook;

import java.util.Stack;

public class ValidBrackets {

    public static void main(String[] args) {
        System.out.println(new ValidBrackets().validBrackets(")))(((")); // ""
        System.out.println(new ValidBrackets().validBrackets("a)(abc)b")); //"a(abc)b"
        System.out.println(new ValidBrackets().validBrackets("((()")); // "()"
    }

    public String validBrackets(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                while (stack.peek() != '(') {
                    sb2.append(stack.pop());
                }
                sb2.append(stack.pop());
                sb.append(sb2.reverse()).append(c);
            } else if (Character.isLetterOrDigit(c) && stack.isEmpty()) {
                sb.append(c);
            } else if (Character.isLetterOrDigit(c) && !stack.isEmpty()) {
                stack.push(c);
            }
        }
        return sb.toString();
    }
}
