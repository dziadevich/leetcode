package easy;

public class FreqAlphabets {
    public static void main(String[] args) {
        System.out.println(FreqAlphabets.freqAlphabets("10#11#12"));
    }

    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)!='#'){
                sb.insert(0, (char)(s.charAt(i)-'1'+'a'));
            }else{
                int n = (s.charAt(i-2)-'0') * 10 + (s.charAt(i-1)-'0');
                sb.insert(0, (char)('a'+n-1));
                i-=2;
            }
        }
        return sb.toString();
    }

    public String freqAlphabets2(String s) {
        StringBuilder h = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#'){
                char c = (char) (Integer.parseInt(Character.toString(s.charAt(i)) +
                        s.charAt(i + 1)) + 96);
                h.append(c);
                i += 2;
            }
            else {
                char c = (char) (Integer.parseInt(Character.toString(s.charAt(i))) + 96);
                h.append(c);
            }
        }
        return h.toString();
    }
}
