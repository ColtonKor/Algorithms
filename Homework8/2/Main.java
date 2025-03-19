/*
 * INSTRUCTION:
 *     This is a Java starting code for hw8.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw8_2.java
 * Abstract: This program is a binary tree. it fills it out based on the levels. You can also read the height and first node of the tree.
 * We can check if it is a Binary Search Tree. You can also read the tree from 4 order types. In order, preorder, postorder, layerorder.
 * Name: Colton Korhummel
 * Date: 4/19/2024
 */

 //I found help on GeeksForGeeks

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.Queue;
 import java.util.Scanner;
 
 class Node
 {
     // Use "public" data to make the program simple (= no getters and setters).
     public int data;
     public Node left;
     public Node right;
 
     // Constructor
     public Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }
 
 
 // A class for a BST which may include many Nodes.
 class BST {
     static boolean BinarySearchTree = true;
     private Node root;
 
     public Node getRoot() {
         return root;
     }
 
     // Add an item to the BST
     // Internally, it calls "insert()" for actual insertion if root is not null.
     public void add(int item) {
         Node newNode = new Node(item, null, null);
         // Empty tree
         if (root == null) {
             root = newNode;
         } else {
             insert(newNode, root);
         }
     }
 
 
     // Insert a new node under the subtree using recursion
     private void insert(Node newNode, Node subTree) {
 //        // Go to the left subtree
 //        if (newNode.data < subTree.data) {
 //            if(subTree.left == null) {
 //                subTree.left = newNode;
 //            } else {
 //                insert(newNode, subTree.left);
 //            }
 //        } else { // Go to the right subtree
 //            if(subTree.right == null) {
 //                subTree.right = newNode;
 //            } else {
 //                insert(newNode, subTree.right);
 //            }
 //        }
         //I found a very similar function on GeeksForGeeks
         Queue<Node> queue = new LinkedList<>();
         queue.add(subTree);
 
         while (!queue.isEmpty()) {
             Node tempNode = queue.poll();
             if (tempNode.left == null) {
                 tempNode.left = newNode;
                 break;
             } else {
                 queue.add(tempNode.left);
             }
 
             if (tempNode.right == null) {
                 tempNode.right = newNode;
                 break;
             } else {
                 queue.add(tempNode.right);
             }
         }
     }
 
 
     // Conduct the in-order traversal.
     // Actual traversal happens in another method named inOrder() with the root.
     // We have two inOrder() methods (= method overloading).
     public void inOrder() {
         inOrder(root);
     }
 
 
     private void inOrder(Node subTree) {
         if (subTree != null) {
             inOrder(subTree.left);
             System.out.print(subTree.data + " ");
             inOrder(subTree.right);
         }
     }
 
     public void isBST(){
         isBST(root);
         System.out.print(BinarySearchTree);
     }
     private void isBST(Node subTree){
         if(subTree.left == null || subTree.right == null){
             return;
         }
         if(subTree.left.data > subTree.data || subTree.right.data < subTree.data){
             BinarySearchTree = false;
             return;
         }
         isBST(subTree.left);
         isBST(subTree.right);
     }
 
     public int findHeight(){
         return findHeight(root) - 1;
     }
 
     private int findHeight(Node subTree){
         int lefth = 0, righth = 0;
         if(subTree.left != null) {
             lefth = findHeight(subTree.left);
         }
         if(subTree.right != null) {
             righth = findHeight(subTree.right);
         }
 
         if (lefth > righth) {
             return lefth + 1;
         } else {
             return righth + 1;
         }
     }
 
 
     public void findFirstNode(){
         findFirstNode(root);
     }
 
     private void findFirstNode(Node subTree){
         if(subTree.left == null){
             System.out.print(subTree.data);
             return;
         }
         findFirstNode(subTree.left);
     }
 
     //I also found similar functions on GeeksForGeeks
     public void levelOrder(){
         int h = findHeight(root) + 1;
         int i;
         for (i = 1; i < h; i++) {
             levelOrder(root, i);
         }
     }
 
     private void levelOrder(Node subTree, int level){
         if (subTree == null) {
             return;
         }
         if (level == 1) {
             System.out.print(subTree.data + " ");
         } else if (level > 1) {
             levelOrder(subTree.left, level - 1);
             levelOrder(subTree.right, level - 1);
         }
     }
 
     public void preOrder(){
         preOrder(root);
     }
     private void preOrder(Node subTree){
         if(subTree == null){
             return;
         }
         System.out.print(subTree.data + " ");
         preOrder(subTree.left);
         preOrder(subTree.right);
     }
 
     public void postOrder(){
         postOrder(root);
     }
     private void postOrder(Node subTree){
         if (subTree == null) {
             return;
         }
         postOrder(subTree.left);
         postOrder(subTree.right);
         System.out.print(subTree.data + " ");
     }
 }  // end of class BST
 
 
 public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int root = sc.nextInt();
         int commands = sc.nextInt();
 
         BST t1 = new BST();
         t1.add(root);
 
         ArrayList<Integer> appends = new ArrayList<>();
         ArrayList<String> command = new ArrayList<>();
 
         for (int i = 0; i < commands; i++) {
             String temp = sc.next();
             command.add(temp);
             if(temp.equals("append")){
                 appends.add(sc.nextInt());
             }
         }
 
         for (int i = 0; i < command.size(); i++) {
             if(command.get(i).equals("append")){
                 t1.add(appends.get(0));
                 appends.remove(0);
             } else if(command.get(i).equals("isBST")){
                 t1.isBST();
                 if(i != command.size()-1){
                     System.out.println();
                 }
             } else if(command.get(i).equals("height")){
                 System.out.print(t1.findHeight());
                 if(i != command.size()-1){
                     System.out.println();
                 }
             } else if(command.get(i).equals("preOrder")){
                 t1.preOrder();
                 if(i != command.size()-1){
                     System.out.println();
                 }
             } else if(command.get(i).equals("levelOrder")){
                 t1.levelOrder();
                 if(i != command.size()-1){
                     System.out.println();
                 }
             } else if(command.get(i).equals("postOrder")){
                 t1.postOrder();
                 if(i != command.size()-1){
                     System.out.println();
                 }
             } else if(command.get(i).equals("findFirstNode")){
                 t1.findFirstNode();
                 if(i != command.size()-1){
                     System.out.println();
                 }
             } else if(command.get(i).equals("inOrder")){
                 t1.inOrder();
                 if(i != command.size()-1){
                     System.out.println();
                 }
             }
         }
     }
 }