package easy;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 */
public class ConvertBinaryNumber {
    public static void main(String[] args) {
        System.out.println(ConvertBinaryNumber.getDecimalValue(new ListNode(0)));
    }

    /**
     *  int num = head.val;
     *         while (head.next != null) {
     *             num = num * 2 + head.next.val;
     *             head = head.next;
     *         }
     *         return num;
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }
}
