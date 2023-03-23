package Tree.BinarySearchTree;

public class BinaryTree {
    private Node root;

    /**
     * Constructor for the binary tree, initializes an empty tree with an EndNode as
     * root.
     */
    public BinaryTree() {
        root = new EndNode();
    }

    /**
     * Helper method to set a new root, if there is none yet
     * 
     * @param data the data that is being stored in the Node
     */
    public void setRoot(DataElement data) {
        if (root instanceof EndNode)
            root = new DataNode(data);
    }

    /**
     * @return returns a referene to the current root Node
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Inserts a new DataElement by calling the insert method on root.
     * 
     * @param data the data that shall be inserted into the tree.
     */
    public void insert(DataElement data) {
        root = root.insert(data);
    }

    /**
     * Starts the printing of the tree by calling the print method on the root node.
     * 
     * @param order the order in which the tree will be printed, given by the Enum
     *              Order.
     */
    public void print(Order order) {
        root.print(order);
    }

    /**
     * Searches for a given DataElement in the tree.
     * 
     * @param data the data that is being searched.
     * @return returns true, if the data is present in the tree.
     */
    public boolean contains(DataElement data) {
        if (search(data) instanceof EndNode) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Searches for a given DataElement in the tree.
     * 
     * @param data the data that is being searched.
     * @return returns a reference to the found node or null.
     */
    public Node search(DataElement data) {
        return root.search(data);
    }

    /**
     * Deletes the root, if the data is stored in there, otherwise it starts
     * the recursive call for deletion on the root node.
     * 
     * @param data the data that shall be deleted.
     * @return returns a reference to the deleted node, can be null, if the data
     *         was not present.
     */
    public Node delete(DataElement data) {
        if (data.equals(((DataNode) root).getData())) {
            Node oldRoot = root;
            root = root.getMaxRightSubtree();
            return oldRoot;
        }
        return root.delete(data);
    }

}