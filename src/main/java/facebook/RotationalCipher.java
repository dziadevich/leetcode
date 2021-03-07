package facebook;
/*
    https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=238827593802550
 */
public class RotationalCipher {

    public static void main(String[] args) {
        System.out.println(new RotationalCipher().rotationalCipher("Zebra-493?", 3));
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if(Character.isUpperCase(c)){
                    i = c -'A';
                    i = (i + rotationFactor)%26;
                    c = (char) ('A' + i);
                }else{
                    i = c -'a';
                    i = (i + rotationFactor)%26;
                    c = (char) ('a' + i);
                }
            } else if (Character.isDigit(c)) {
                i = c -'0';
                i = (i + rotationFactor) % 10;
                c = (char) ('0' + i);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
