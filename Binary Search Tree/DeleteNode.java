package binarySearchTree;

public class DeleteNode {
	static class Node {
		int data;
		Node left, right;
		
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
	
	
	// Delete a node from BST
	// Time Complexity: O(h), where h = height of tree
	// Best case (balanced): O(log n), Worst case (skewed): O(n)
	public static Node delete(Node root, int val) {
		if (root == null) {
			return null;
		}
		
		if (val < root.data) {
			root.left = delete(root.left, val);
		} else if (val > root.data) {
			root.right = delete(root.right, val);
		} else {
			// Node found (root.data == val)
			
			// Case 1: Node has no child (leaf node)
			// → Simply remove it by returning null
			if (root.left == null && root.right == null) {
				return null;
			}
			
			// Case 2: Node has only one child
			// → Return the non-null child to replace the node
			if (root.left == null) return root.right;
			else if (root.right == null) return root.left;
			
			// Case 3: Node has two children
			// → Find the inorder successor (smallest value in right subtree)
			// → Replace current node’s data with successor’s data
			// → Recursively delete the successor node from right subtree
			Node successor = findMin(root.right);
			root.data = successor.data;  
			root.right = delete(root.right, successor.data);  
		}
		
		return root;
	}
	
	// Find minimum node in BST (used for inorder successor)
	private static Node findMin(Node root) {
		while (root.left != null) {
			root = root.left;
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
	
	public static void main(String[] args) {
		int values[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
		Node root = null;
		
		// Build BST using insert()
		for (int val : values) {
			root = insert(root, val);
		}
		
		System.out.print("BST Inorder before deletion: ");
		inorder(root);
		System.out.println();
		
		// Delete node
		root = delete(root, 5);
		
		System.out.print("BST Inorder after deleting 5: ");
		inorder(root);
		System.out.println();
	}
}