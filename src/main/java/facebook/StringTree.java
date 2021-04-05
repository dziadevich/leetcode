package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringTree {
    public static void main(String[] args) {
        System.out.println(new StringTree().stringTree(new Node('A', new Node('B',
                new Node('D', null, null), null),
                new Node('C', new Node('E', null, null),
                        new Node('F', null, null)))));
    }

    public List<String> stringTree(Node node) {
        List<String> res = new ArrayList<>();
        if (node == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Queue<String> queueS = new LinkedList<>();
        queueS.add("");
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            String s = queueS.poll();
            if (curr.left == null && curr.right == null) {
                res.add(s + curr.val);
            } else {
                if (curr.left != null) {
                    queue.add(curr.left);
                    queueS.add(s + curr.val);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                    queueS.add(s + curr.val);
                }
            }
        }
        return res;
    }
}


class Node {

    char val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
