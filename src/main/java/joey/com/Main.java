package joey.com;

import joey.com.dataStructures.trees.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.addElement(10);

        tree.addElement(8);
        tree.addElement(18);

        tree.addElement(9);
        tree.addElement(7);



        tree.addElement(15);
        tree.addElement(16);
        tree.addElement(14);
        tree.addElement(20);
        tree.addElement(27);
        tree.addElement(19);


        tree.remove(10);
        tree.showInOrder(tree.getRoot());
    }
}