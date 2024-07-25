package BinarySearchTree;

import java.util.Scanner;

public class LeetcodeProblems {
    static int rangeSumBST(BST.Node root, int low, int high) {
        return rangeSumBST(root, low, high, 0);
    }

    static int rangeSumBST(BST.Node node, int low, int high, int sum) {
        if(node.val > high && node.left != null) {
            sum += rangeSumBST(node.left, low, high, 0);
        }
        if(node.val < low && node.right != null) {
            sum += rangeSumBST(node.right, low, high, 0);
        }
        if(low <= node.val && node.val <= high) {
            sum += node.val;
            if(node.left != null) {
                sum += rangeSumBST(node.left, low, high, 0);
            }
            if(node.right != null) {
                sum += rangeSumBST(node.right, low, high, 0);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);

        bst.add(scanner);

        // range sum BST code
        System.out.println("Enter low and high: ");
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int sum = rangeSumBST(bst.root, low, high);
        System.out.println("Sum is " + sum);
    }
}
