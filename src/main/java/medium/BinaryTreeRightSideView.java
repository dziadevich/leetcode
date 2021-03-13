package medium;

import java.util.*;
import java.util.stream.Stream;

/*
https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) return result;

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) result.add(node.val);
                Stream.of(node.right, node.left).filter(Objects::nonNull).forEach(q::offer);
            }
        }
        return result;
    }
}
