package medium;

import java.util.Stack;

/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {

    }

    /*
    Just Imagine, we want a Array list in a pre-order traversal.
    Just do a pre-order traversal.
    In extra, link the previous entry in the list to current entry. (as a right pointer)
*/

    /*
    Store the previously processed node in this variable.
    */
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
  /*
        Since we are modifing the left and right pointers in the list, before doing anything store the left node and right node.
        */
        TreeNode left = root.left;
        TreeNode right = root.right;

         /*
        Link the previous element in the processing to the current element and
        make the next previous as current element.
        */
        if (prev != null) {
            prev.right = root;
        }
        prev = root;

        /*
        We don't need any additional links to the current node.
        Only previous element links to the root. so delete all the links to the current node.
        */
        root.left = null;
        root.right = null;

        /*
        Pre-order traversal
        */
        flatten(left);
        flatten(right);
    }

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
