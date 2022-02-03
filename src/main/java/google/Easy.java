package google;

public class Easy {
    public static void main(String[] args) {
        System.out.println(transform("ACT", "TASK"));
        System.out.println(transform("ACT", "TASC"));
    }

    static boolean transform(String s1, String s2){
        int [] f1 = new int[26];
        int [] f2 = new int[26];
        for(char c : s1.toCharArray()){
            f1[c - 'A']++;
        }
        for(char c : s2.toCharArray()){
            f2[c - 'A']++;
        }
        int diff = 0;
        for(int i = 0; i< 26; i++){
            diff += Math.abs(f1[i] - f2[i]);
        }
        return diff < 2;
    }
}
