package easy;

import java.util.ArrayList;
import java.util.List;

/**
 There is a stream of n (id, value) pairs arriving in an arbitrary order, where id is an integer between 1
 and n and value is a string. No two pairs have the same id.

 Design a stream that returns the values in increasing order of their IDs by returning a chunk (list)
 of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.

 Implement the OrderedStream class:

 OrderedStream(int n) Constructs the stream to take n values.
 String[] insert(int id, String value) Inserts the pair (id, value) into the stream, then returns the
 largest possible chunk of currently inserted values that appear next in the order.
 */
public class DesignanOrderedStream {
    private String[] s;
    private int index;

    public DesignanOrderedStream(int n) {
        s = new String[n];
    }

    public List<String> insert(int id, String value) {
        s[id - 1] = value;
        List<String> ans = new ArrayList<>();
        while (index < s.length) {
            if (s[index] == null)
                break;
            ans.add(s[index++]);
        }
        return ans;
    }

}
