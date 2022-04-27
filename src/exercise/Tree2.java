package exercise;

import java.util.LinkedList;
import java.util.Queue;

public class Tree2 extends Tree{
    
    //Tree traversal algorithms
    //1. Preorder
    public void preOrderTraversal(int p) {
        //recursive approach: current parent node + all left child nodes + all right child nodes
        System.out.print(T[p] + " ");
        if(hasLeftChild(p)) {
            preOrderTraversal(2*p+1);
        }
        if(hasRightChild(p)) {
            preOrderTraversal(2*p+2);
        }
    }

    //2. Inorder
    public void inOrderTraversal(int p) {
        //recursive approach: left child node + parent node + right child node
        if (hasLeftChild(p)){
            inOrderTraversal(p*2+1);
        }
        System.out.print(T[p] + " ");
        if (hasRightChild(p)){
            inOrderTraversal(p*2+2);
        }
    }

    //3. Postorder
    public void postOrderTraversal(int p) {
        //recursive approach: all left child nodes + all right child nodes + current parent node
        if (hasLeftChild(p)){
            inOrderTraversal(p*2+1);
        }
        if (hasRightChild(p)){
            inOrderTraversal(p*2+2);
        }
        System.out.print(T[p] + " ");
    }

    //4. Breadth-first
    public void breadthFirstTraversal(int p) {
        Queue<Integer> queue = new LinkedList<>(); // Create queue to stored position p
        queue.offer(p); // Add given p to the first of queue

        while (!queue.isEmpty()) { //Loop until all values is dequeued
            // dequeue values and print it
            int dequeue = queue.poll();
            System.out.printf(T[dequeue] + " ");

            // After dequeue add left child of dequeue position to the queue if exists
            if (hasLeftChild(dequeue)) {
                queue.offer(dequeue*2+1);
            }
            // After dequeue add left child of dequeue position to the queue if exists
            if (hasRightChild(dequeue)) {
                queue.offer(dequeue*2+2);
            }

            // After this will go to the loop again if left child of deque is exists it will be next dequeue value
            // And also if right is exists right will be the next value to dequeue
            // By the way if left has a left or right children it will be added to the queue and run after right if right is exists
            // The same as left, right will work similarly to left
            // Its mean every data at the same level will be added to the queue respectively and will be queued respectively too
        }
    }

}
