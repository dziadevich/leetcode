package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().nextLargerNodes(
                new ListNode(2, new ListNode(1, new ListNode(5))))));
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodeVals = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodeVals.add(curr.val);
            curr = curr.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nodeVals.size()];

        for(int i = 0; i <nodeVals.size(); i++){
            while(!stack.isEmpty() &&  nodeVals.get(stack.peek()) < nodeVals.get(i)){
                res[stack.pop()] = nodeVals.get(i);
            }
            stack.push(i);
        }

        return res;
    }
}
