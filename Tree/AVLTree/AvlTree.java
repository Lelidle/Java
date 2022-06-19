package Tree.AVLTree;

public class AvlTree {
    
    private Node root;

    /**
     * Generic constructor,only initializes a null root.
     */
    public AvlTree(){
        root = null;
    }

    /**
     * Getter for the root, only for testing purposes.
     * @return returns a reference to the root node.
     */
    public Node getRoot(){
        return root;
    }

    /**
     * Method to insert a new Node, works like inserting into a binary tree.
     * After the method calls the rebalance method that balances the tree again.
     * @param data the data that shall be stored in the node, currently only integers.
     */
    public void insert(int data) {
        if(root == null) {
            root = new DataNode(data, null);
        } else {
            root.insert(data, root);
        }
        //if(!checkBalance()) {
            rebalance();
        //}
    }

    /**
     * Method to start the rebalancing at the root Node.
     * Only public for testing purposes.
     */
    public void rebalance() {
        root.rebalance();
    }

    /**
     * Method to check if the tree is currently balanced.
     * Oly public for testing purposes, should be private.
     * @return returns true if the tree is currently balanced.
     */
    public boolean checkBalance() {
        if(root != null) {
            return root.checkBalance();
        } else {
            return false;
        }
    }

    public void printTree(Order order) {
        root.print(order);
    }
}
