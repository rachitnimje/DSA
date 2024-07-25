package BinaryTree;

import java.util.Scanner;

public class BT {

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the value of root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter the left node of " + node.val);
        boolean choice = scanner.nextBoolean();
        if (choice) {
            System.out.println("Enter the left node of " + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter the right node of " + node.val);
        choice = scanner.nextBoolean();
        if (choice) {
            System.out.println("Enter the right node of " + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, " ");
    }

    public void display(Node node, String indent) {
        if(node == null){
            return;
        }

        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    private void prettyPrint() {
        prettyPrint(root, 0);
    }

    private void prettyPrint(Node node, int level) {
        if(node == null) {
            return;
        }

        prettyPrint(node.right, level + 1);

        if(level != 0) {
            for(int i = 0; i < level-1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + node.val);
        } else {
            System.out.println(node.val);
        }
        prettyPrint(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BT bt = new BT();
        bt.populate(scanner);
        bt.prettyPrint();
    }
}
