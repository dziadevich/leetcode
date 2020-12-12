package easy;

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string,
 * and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 */
public class CheckIfTwoStringArraysareEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringArrIterator itr1 = new StringArrIterator(word1);
        StringArrIterator itr2 = new StringArrIterator(word2);
        while (itr1.hasNext() && itr2.hasNext()) {
            if (itr1.next() != itr2.next()) {
                return false;
            }
        }
        return !itr1.hasNext() && !itr2.hasNext();
    }
}

class StringArrIterator {
    String[] strArr;
    int arrIdx;
    int strIdx;

    public StringArrIterator(String[] strArr) {
        this.strArr = strArr;
    }

    public boolean hasNext() {
        return arrIdx != strArr.length;
    }

    public char next() {
        char charAt = strArr[arrIdx].charAt(strIdx++);
        if (strIdx == strArr[arrIdx].length()) {
            arrIdx++;
            strIdx = 0;
        }
        return charAt;
    }
}