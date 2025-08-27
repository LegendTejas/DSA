package binarySearchTree;

import java.util.ArrayList;

public class BSTProblems {
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	// Insert a new value in BST
	public static Node insert(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		if (val < root.data) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}
	
	// Inorder Traversal (Left, Root, Right)
	public static void inorder(Node root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	// Problem 1: Print a particular range of values
	public static void printInRange(Node root, int X, int Y) {
		if (root == null) return;
		
		if(root.data >= X && root.data <= Y) {
			printInRange(root.left, X, Y);
			System.out.print(root.data+" ");
			printInRange(root.right, X, Y);
		}
		else if(root.data >= Y){
			printInRange(root.left, X, Y);
		}
		else {
			printInRange(root.right, X, Y);
		}
		
	}
	
	// Problem 2: Print Root to Leaf Paths
	public static void printPath(ArrayList<Integer> path) {
	    for (int i = 0; i < path.size(); i++) {
	        System.out.print(path.get(i));
	        if (i < path.size() - 1) { // Print "->" only between nodes, not after the last one
	            System.out.print("->");
	        }
	    }
	    System.out.println(); // Move to next line after printing a full path
	}

	// Recursive function to print all root-to-leaf paths in the BST
	public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
	    if (root == null) return; 
	    
	    // Add current node to the path
	    path.add(root.data);

	    // If it's a leaf node, print the entire path
	    if (root.left == null && root.right == null) {
	        printPath(path);
	    } else { 
	        // Otherwise, recursively explore left and right subtrees
	        printRoot2Leaf(root.left, path);
	        printRoot2Leaf(root.right, path);
	    }

	    // Backtrack: remove the current node before returning to the parent
	    path.remove(path.size() - 1);
	}
	
	
	public static void main(String[] args) {
		int values[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
		Node root = null;
		
		// Build BST using insert()
		for (int val : values) {
			root = insert(root, val);
		}		
		
		System.out.print("BST Inorder Traversal: ");
		inorder(root);
		
		System.out.println();
		
		System.out.print("\nBST Traversal Range (6 to 14): ");
		printInRange(root, 6, 14);
		
		System.out.println();
		
		System.out.println("\nAll Paths from Root to Leaf Nodes: ");
		printRoot2Leaf(root, new ArrayList<>());
	}

}