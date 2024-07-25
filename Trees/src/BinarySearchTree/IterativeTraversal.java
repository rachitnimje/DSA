package BinarySearchTree;

import java.util.Stack;

public class IterativeTraversal {

    void inOrder(BST.Node root) {
        BST.Node current = root;

        Stack<BST.Node> stack = new Stack<>();
        stack.push(root);

        while(current.left != null) {
            // push to stack current.val
            stack.push(current.left);
            current = current.left;
        }

        // while loop till stack is empty
        // current = pop from stack
        // print current
        // while till current.right exist
        System.out.println("Iterative In-order traversal");

        while(!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.val + "->");

            while(current.right != null) {
                stack.push(current.right);
                current = current.right;
            }
        }
    }

    void preOrder(BST.Node root) {

    }
}
