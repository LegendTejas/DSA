package binarySearchTree;
import java.util.*;

public class BST {
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	// Insert a new value in BST
	// Time Complexity: O(h), where h = height of tree
	// Best case (balanced): O(log n), Worst case (skewed): O(n)
	public static Node insert(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		
		if(root.data > val) {
			// Insert into left subtree
			root.left = insert(root.left, val);
		} else {
			// Insert into right subtree
			root.right = insert(root.right, val);
		}
		
		return root;
	}
	
	// Inorder Traversal (Left, Root, Right)
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	// Search a key in BST
	// Time Complexity: O(h), where h = height of tree
	// Best case (balanced): O(log n), Worst case (skewed): O(n)
	public static boolean search(Node root, int key) {
		if (root == null) {
			return false;
		}
		
		if(root.data > key) { // Search in left subtree
			return search(root.left, key);
		}
		else if(root.data == key) {
			return true;
		}
		else { // Search in right subtree
			return search(root.right, key);
		}
	}
	
	public static void main(String[] args) {
		int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
		Node root = null;
		
		// Build BST
		for(int i=0; i < values.length; i++) {
			root = insert(root, values[i]);
		}
		
		System.out.print("BST Inorder Traversal: ");
		inorder(root);
		System.out.println();
		
		// Search key in BST
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a key to search in BST: ");
		int n = sc.nextInt();
		
		if(search(root, n)) {
			System.out.println("Key " +n+ " is found");
		} else {
			System.out.println("Key " +n+ " is not found");
		}
		
		sc.close();
	}
}