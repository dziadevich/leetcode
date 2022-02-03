package easy;

import java.util.stream.Stream;

/*
https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 */
public class MaximumNumberWordsFoundSentences {
    public int mostWordsFound(String[] sentences) {
        return Stream.of(sentences).mapToInt(s -> s.split(" ").length).max().getAsInt();
    }
}
