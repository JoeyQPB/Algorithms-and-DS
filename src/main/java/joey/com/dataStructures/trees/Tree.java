package joey.com.dataStructures.trees;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
        root = null;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void addElement(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<T> current = this.root;

            while (true) {
                if (newNode.getValue().compareTo(current.getValue()) < 0) {
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(newNode);
                        break;
                    }
                } else { // bigger or equals
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(newNode);
                        break;
                    }
                }
            }
        }
    }

    // in order (left, top and right)
    public void showInOrder(Node<T> current) {
        if (current != null) {
            showInOrder(current.getLeft());
            System.out.println(current.getValue());
            showInOrder(current.getRight());
        }
    }

    // pre-order (top, left and right)
    public void showInPreOrder(Node<T> current) {
        if (current != null) {
            System.out.println(current.getValue());
            showInPreOrder(current.getLeft());
            showInPreOrder(current.getRight());
        }
    }

    // pos order (left, right, top)
    public void showInPosOrder(Node<T> current) {
        if (current != null) {
            showInPosOrder(current.getLeft());
            showInPosOrder(current.getRight());
            System.out.println(current.getValue());
        }
    }

    public boolean remove(T value) {
        // try to get el and the remove
        Node<T> current = this.root;
        Node<T> currentFather = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                // remove
                privateRemove(current, currentFather);
                break;

            } else if (value.compareTo(current.getValue()) < 0) { // value is less than current is
                currentFather = current;
                current = current.getLeft();
            } else { // value is greater than current
                currentFather = current;
                current = current.getRight();
            }
        }

        return current != null;
    }

    private void privateRemove(Node<T> current, Node<T> currentFather) {
        if (current.getRight() != null) {
            // to remove from the left you should go to the first right subtree from current then get the last left leaf to replace
            Node<T> sub = current.getRight();
            Node<T> subFather = current;
            Node<T> saveTree = null;

            if (current.getValue().equals(this.root.getValue())) {
                saveTree = sub;
            }

            while (sub.getLeft() != null) {
                subFather = sub;
                sub = sub.getLeft();
            }

            // keep the tree elements
            sub.setLeft(current.getLeft());

            if (currentFather != null) {
                if (current.getValue().compareTo(currentFather.getValue()) < 0) { // current < currentFather
                    currentFather.setLeft(sub);
                } else { // current > currentFather
                    currentFather.setRight(sub);
                }
            } else { // this is a root case
                this.root = sub;
                sub.setRight(saveTree);
            }

            if (sub.getValue().compareTo(subFather.getValue()) < 0) { // sub < subFather
                subFather.setLeft(null);
            } else { // current > currentFather
                subFather.setRight(null);
            }
        }
        else if (current.getLeft() != null) {
            // to remove from the right you should go to the first left subtree from current then get the last right leaf to replace
            Node<T> sub = current.getLeft();
            Node<T> subFather = current;

            while (sub.getRight() != null) {
                subFather = sub;
                sub = sub.getRight();
            }

            // keep the tree elements
            sub.setRight(current.getRight());

            if (currentFather != null) {
                if (current.getValue().compareTo(currentFather.getValue()) < 0) { // current < currentFather
                    currentFather.setLeft(sub);
                } else { // current > currentFather
                    currentFather.setRight(sub);
                }
            } else { // root case
                this.root = sub;
            }

            if (sub.getValue().compareTo(subFather.getValue()) < 0) { // sub < subFather
                subFather.setLeft(null);
            } else { // current > currentFather
                subFather.setRight(null);
            }
        }
        else {
            if (currentFather != null) {
                if (current.getValue().compareTo(currentFather.getValue()) < 0) { // current < currentFather
                    currentFather.setLeft(null);
                } else { // current > currentFather
                    currentFather.setRight(null);
                }
            } else { // root case
                this.root = null;
            }
        }
    }

}
