package BinarySearchTree;

public class RecursiveTraversal {
    void inOrderRec(BST.Node node) {
        if(node == null) {
            return;
        }
        inOrderRec(node.left);
        System.out.print(node.val + "-->");
        inOrderRec(node.right);
    }

    void preOrderRec(BST.Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val + "-->");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    void postOrderRec(BST.Node node) {
        if(node == null) {
            return;
        }
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.val + "-->");
    }
}
