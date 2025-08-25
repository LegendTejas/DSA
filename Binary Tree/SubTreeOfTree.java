package binaryTree;

public class SubTreeOfTree {

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

        public static Node buildTree (int nodes[]) {
            idx++;  
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; 
        }
    }

    // Check if two trees are identical
    public static boolean isIdentical(Node root, Node subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    // Check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public static void main(String[] args) {
        // Build main tree
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        // Build subtree
        int subNodes[] = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree.idx = -1; // reset index before building again
        Node subRoot = BinaryTree.buildTree(subNodes);

        // Check if subRoot is a subtree of root
        System.out.println(isSubtree(root, subRoot)); // prints true or false
    }
}


// Similar Problem: LeetCode 572
