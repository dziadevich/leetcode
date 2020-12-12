package easy;

/**
 * You are given a string allowed consisting of distinct characters and an array of strings words.
 * A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 */
public class CounttheNumberofConsistentStrings {
    public static void main(String[] args) {
        System.out.println(
                CounttheNumberofConsistentStrings.countConsistentStrings("ab",
                        new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

    /**
     * Use the bits of an int to indicate the characters in allowed.
     * Loop through the words and check if all the characters of each word present in the allowed; if yes,
     * count it in; otherwise ignore it.
     * Time: O(n), space: O(1), where n = the total characters in words and allowed. `
     * @param allowed
     * @param words
     * @return
     */
    public static int countConsistentStrings(String allowed, String[] words) {
        int alphabet = 0, cnt = 0;
        for (int i = 0; i < allowed.length(); ++i) {
            int shift = allowed.charAt(i) - 'a';
            alphabet |= 1 << shift;
        }
        outer:
        for (String w : words) {
            for (int i = 0; i < w.length(); ++i) {
                if ((alphabet & (1 << w.charAt(i) - 'a')) == 0) {
                    continue outer;
                }
            }
            ++cnt;
        }
        return cnt;
    }
}
