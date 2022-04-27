package exercise;

public class MainTree2 {
    public static void main(String[] args) {
        int[] data = {8, 5, 10, 15, 20, 18, 3};
        Tree2 abt = new Tree2();

        //add data to the binary search tree
        for(int p=0;p<data.length;p++) {
            if (abt.isEmpty()) {
                abt.addRoot(data[p]);
            } else {
                abt.addChild(0, data[p]);
            }
        }

        //print positions and elements
        abt.printAllPositions();
        abt.printAllElements();
        System.out.println();

        //tree traversal
        //1. preorder
        System.out.print("Preorder Traversal: ");
        abt.preOrderTraversal(0);
        System.out.println();
        //2. inorder
        System.out.print("Inorder Traversal: ");
        abt.inOrderTraversal(0);
        System.out.println();
        //3. postorder
        System.out.print("Postorder Traversal: ");
        abt.postOrderTraversal(0);
        System.out.println();
        //4. breadth-first
        System.out.print("Breadth-first Traversal: ");
        abt.breadthFirstTraversal(0);
    }
}
