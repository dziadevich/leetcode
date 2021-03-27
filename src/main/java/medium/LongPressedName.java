package medium;

/*
    https://leetcode.com/problems/long-pressed-name/
 */
public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("alex", "aaleex")); //true
        System.out.println(new LongPressedName().isLongPressedName("leelee", "lleeelee")); //true
        System.out.println(new LongPressedName().isLongPressedName("saeed", "ssaaedd")); //false
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        for (int j = 0; j < typed.length(); j++) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j))
                i++;
            else if (i <= 0 || name.charAt(i - 1) != typed.charAt(j)) {
                return false;
            }
        }
        return i == name.length();
    }
}
