package easy;

/**
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
 * The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
 * If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 */
public class MaximumRepeatingSubstring {

    public static int maxRepeating(String sequence, String word) {
        // Use StringBuilder instead of String which creates a new string on every append
        StringBuilder sb = new StringBuilder(word);
        int result = 0;
        // check if the string is part of sb
        while (sequence.contains(sb)) {
            result += 1;
            sb.append(word);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(MaximumRepeatingSubstring.maxRepeating("ababc", "ab"));
    }
}
