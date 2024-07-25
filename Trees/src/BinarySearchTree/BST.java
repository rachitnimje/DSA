package BinarySearchTree;

import java.util.Scanner;

public class BST {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Node root;

    // add a node
    void add(Scanner scanner) {
        System.out.println("Enter the root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        System.out.println("Root node created: " + val);
        print(root, 0);

        System.out.println("Do you want to add another node?");
        boolean choice = scanner.nextBoolean();
        while(choice) {
            System.out.println("Enter the node value: ");
            val = scanner.nextInt();
            add(root, val);
            print(root, 0);
            System.out.println("Do you want to add another node?");
            choice = scanner.nextBoolean();
        }
    }
    void add(Node node, int val) {
        if(val < node.val) {
            if(node.left == null) {
                node.left = new Node(val);
                System.out.println("Node added: " + val);
                return;
            }
            add(node.left, val);
        }
        if(val > node.val) {
            if(node.right == null) {
                node.right = new Node(val);
                System.out.println("Node added: " + val);
                return;
            }
            add(node.right, val);
        }
    }

    // delete a node
    void delete(Scanner scanner) {}

    // prints a tree
    void print(Node node, int level) {
        if(node == null) {
            return;
        }
        print(node.right, level + 1);
        if(level != 0) {
            for(int i = 0; i < level-1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + node.val);
        } else {
            System.out.println(node.val);
        }
        print(node.left, level + 1);
    }
}
