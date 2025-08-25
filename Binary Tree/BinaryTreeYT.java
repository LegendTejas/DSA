package binaryTree;

public class BinaryTreeYT {
	
	// Node class represents each node of the binary tree
	static class Node {
		int data;     // value of the node
		Node left;    // reference to left child
		Node right;   // reference to right child
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	// BinaryTree class contains methods for building a binary tree
	static class BinaryTree {
		static int idx = -1; // static index used while building the tree
		
        // Method to build a binary tree from a given array
        // -1 in the array represents a NULL node (no child)
		public static Node buildTree (int nodes[]) {
			idx++; // move to the next element in the array
			
			// Base case: if current element is -1, return null (no node)
			if (nodes[idx] == -1) {
				return null;
			}
			
			Node newNode = new Node(nodes[idx]);  // Create a new node with the current value
			newNode.left = buildTree(nodes);      // Recursively build the left subtree
			newNode.right = buildTree(nodes);     // Recursively build the right subtree
			
			return newNode;   // return the root of this subtree
		}
	}

	
	// Preorder traversal
	public static void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	
	// Inorder traversal
	public static void inorder(Node root) {
	       if(root == null) {
	           return;
	       }
	       inorder(root.left);
	       System.out.print(root.data+" ");
	       inorder(root.right);
	   }
	
	
	// Postorder traversal
	public static void postorder(Node root) {
	       if(root == null) {
	           return;
	       }
	       postorder(root.left);
	       postorder(root.right);
	       System.out.print(root.data+" ");
	   }
	
	public static void main(String[] args) {
        // Array representation of tree
        // -1 means no child
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
        // Build binary tree from array
		Node root = BinaryTree.buildTree(nodes);

		System.out.print("Preorder: ");
		preorder(root);
		System.out.println(); // new line

		System.out.print("Inorder: ");
		inorder(root);
		System.out.println();

		System.out.print("Postorder: ");
		postorder(root);
		System.out.println();
	}
}