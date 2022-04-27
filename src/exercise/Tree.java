package exercise;

import java.util.Arrays;

public class Tree {
    // default tree's capacity
    protected final int treeCapacity = 64;
    protected int size = 0;
    // array to keep tree data
    protected int[] T;

    public Tree() {
        T = new int[treeCapacity];
        // fill array with -1
        Arrays.fill(T, -1);
    }

    @SuppressWarnings("unused")
    public Tree(int tSize) {
        T = new int[tSize];
        // fill array with -1
        Arrays.fill(T, -1);
    }

    //is current node a root?
    public boolean isRoot(int p) {
        return p == 0; // p is the root when p is 0
    }

    public boolean hasLeftChild(int p) {
        //is node p has a left child?
        int leftChildIndex = 2*p+1;
        return  T[leftChildIndex] > -1; // get value of left child at the index is filled or not if not it will be -1
    }

    public boolean hasRightChild(int p) {
        //is node p has a right child?
        int rightChildIndex = 2*p+2;
        return  T[rightChildIndex] > -1; // get value of left child at the index is filled or not if not it will be -1
    }

    public int getsize() {
        //return tree's size
        return size;
    }

    public boolean isEmpty() {
        //is tree empty?
        return size == 0; // if size equals 0 this will be empty
    }

    public int getElement(int p) {
        // is node p existed?
        int valuesAtP = T[p];
        return (valuesAtP != -1)? valuesAtP : -999; // return values at p if it exists (at p is not -1) else return -999
    }

    public boolean isInternal(int p) {
        // if either left or right child node exists
        return (hasLeftChild(p) || hasRightChild(p)); // If at p has at least one child node exist
    }

    public boolean isLeaf(int p) {
        // left and right child nodes are blank (-1)
        return !(isInternal(p)); // If at p is not internal node or means it doesn't have any child node it means it is a leaf
    }

    public int getParent(int p) {
        //return value of parent node of node p
        int parentIndex = (p-1)/2; // A half up of point
        return (!isRoot(p))? T[parentIndex] : -999; // return p's parent if p is not parent, else -999
    }

    // print all nodes' positions
    public void printAllPositions() {
        System.out.print("\nAll positions are :");
        for (int i = 0; i < T.length; i++) {
            if (T[i] > -1){ // Check p is has a value a not
                System.out.print(i + " "); // Then just print it if it has value
            }
        }
        System.out.println();
    }

    // print all nodes' elements (Breadth-First)
    public void printAllElements() {
        System.out.print("\nAll elements are :");
        for (int node : T) {
            if (node > -1) { // Check p is has a value a not
                System.out.print(node + " "); // Then just print its value if it has a value
            }
        }
        System.out.println();
    }

    public void addRoot(int element) {
        if (size == 0){ // Add root only when tree is empty (size == 0) else alert
            T[0] = element;
            size ++;
            System.out.println("Root of tree was added");
        } else {
            System.out.println("Tree is not empty!!");
        }
    }

    public void addChild(int p, int element) {
        //add left or right
        // Try to add element at the left of p if element is less than element at the p
        if (element < T[p]){
            int leftChildIndex = p*2+1; // The index that will be at element

            if (hasRightChild(p)){
                // Recursive call when at p already has a left child, just go to check given element with that left child
                // Then check it again and again until correct position
                // In recursive element can go left or right depends on checking
                addChild(leftChildIndex, element);
            } else {
                // If finally at p has no left child set element for the left child of p
                // p can be leftChildIndex from the recursive or given p if at p has no left child
                T[leftChildIndex] = element; // Add element at the left child
                size ++; // increase size
                System.out.println("Left of " + p + " was added!!!"); // This line will let you know where exactly element was at
            }

        // Try to add element at the right of p if element is greater than element at the p
        } else {
            int rightChildIndex = p*2+2; // The index that will be at element

            if (hasRightChild(p)){
                // Recursive call when at p already has a right child, just go to check given element with that right child
                // Then check it again and again until correct position
                // In recursive element can go left or right depends on checking
                addChild(rightChildIndex, element);
            } else {
                // If finally at p has no right child set element for the left child of p
                // p can be rightChildIndex from the recursive or given p if at p has no right child
                T[rightChildIndex] = element; // add element at the right child
                size ++; // increase size
                System.out.println("Right of " + p + "was added!!!"); // This line will let you know where exactly element was at
            }
        }
    }

    public int getLeftChild(int p) {
        // has left child?
        if (hasLeftChild(p)){
            return T[2*p+1]; // Return value at the left child index
        } else {
            return -999;
        }
    }

    public int getRightChild(int p) {
        // has right child?
        if (hasRightChild(p)){
            return T[2*p+2]; // Return value at the right index
        } else {
            return -999;
        }
    }

    public int getSibling(int p) {

        // First, if p is parent it will not have a sibling
        if(isRoot(p)){
            return -999;
        }

        if (p%2 == 1) { // p is the left child when it is odd number
            return T[p+1]; // Return right child that is next of p
        } else { // p is the right child if it is even number
            return T[p-1]; // Return left child that is before of p
        }
    }
}
