package binaryTree;

import java.util.*;

public class LevelOrderTraversal {
    
    // Node class represents each node of the binary tree
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
    
    // Method for Level Order Traversal (Breadth-First Traversal)
    public static void levelOrder(Node root) {
        if(root == null) {
            return; // if tree is empty, nothing to print
        }

        Queue<Node> q = new LinkedList<>(); // queue to store nodes for BFS
        q.add(root);    // add root to queue
        q.add(null);    // add null as marker for end of level

        // Process nodes level by level
        while(!q.isEmpty()) {
            Node curr = q.remove(); // remove front of queue

            // If current is null, means one level is completely traversed
            if(curr == null) {
                System.out.println(); // move to next line for new level

                // If queue is empty, traversal is done
                if(q.isEmpty()) {
                    break;
                } else {
                    // Otherwise, add null to mark the end of next level
                    q.add(null);
                }
            } else {
                // Print current node's data
                System.out.print(curr.data+" ");

                // Add left child to queue if exists
                if(curr.left != null) {
                    q.add(curr.left);
                }

                // Add right child to queue if exists
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // Build binary tree from array
        Node root = BinaryTree.buildTree(nodes);
        
        levelOrder(root);
    }
}