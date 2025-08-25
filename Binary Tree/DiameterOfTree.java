package binaryTree;

public class DiameterOfTree {
   static class Node {
       int data;
       Node left;
       Node right;


       Node(int data) {
           this.data = data;
           this.left = null;
           this.right = null;
       }
   }

   static class BinaryTree {
       static int idx = -1;
       public static Node buildTree(int nodes[]) {
           idx++;
           if(nodes[idx] == -1) {
               return null;
           }
           Node newNode = new Node(nodes[idx]); 
           newNode.left = buildTree(nodes);
           newNode.right = buildTree(nodes);
           return newNode;
       }
   }
   
   // Height Of Tree
   public static int height(Node root) {
       if(root == null) {
           return 0;
       }
       int leftHeight = height(root.left);
       int rightHeight = height(root.right);
       return Math.max(leftHeight, rightHeight) + 1;
   }

   // Diameter of a Tree: Number of nodes in the longest path between any two nodes
   
   // Approach 1: O(n²)
   public static int diameter(Node root) {
	   if(root == null) {
		   return 0;
	   }
	   int diam1 = diameter(root.left);
	   int diam2 = diameter(root.right);
	   int diam3 = height(root.left) + height(root.right) + 1;
	   
	   return Math.max(diam3, Math.max(diam1, diam2));
   }
   
   // Approach 2: O(n)
   static class TreeInfo {
	   int ht; // Height
	   int diam; // Diameter
	   
	   TreeInfo(int ht, int diam) {
		   this.ht = ht;
		   this.diam = diam;
	   }
   }
   
   public static TreeInfo diameter2(Node root) {
	   if(root == null) {
		   return new TreeInfo(0, 0);
	   }
	   
	   TreeInfo left = diameter2(root.left);
	   TreeInfo right = diameter2(root.right);
	   
	   int myHeight = Math.max(left.ht, right.ht) + 1;
	   
	   int diam1 = left.diam;
	   int diam2 = right.diam;
	   int diam3 = left.ht + right.ht + 1;
	   
	   int mydiam = Math.max(Math.max(diam1, diam2), diam3);
	   
	   TreeInfo myInfo = new TreeInfo(myHeight, mydiam);
	   return myInfo;
	   
   }
   public static void main(String args[]) {
       int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
      
       Node root = BinaryTree.buildTree(nodes);
       
       System.out.println("(Approach-1) Diameter of Tree: " + diameter(root));
       
       System.out.println("(Approach-2) Diameter of Tree: " + diameter2(root).diam);
   }
}