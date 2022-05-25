package Tree.BinarySearchTree;

public class DataNode implements Node {

    private DataElement data;
    private int count;
    private Node left;
    private Node right;

    /**
     * Constructor for a new DataNode, initializes two new EndNodes as left and right follower.
     * Stores the referenced data as well as a count how often this item has been inserted.
     * @param data the data that is being stored in this node
     */
    public DataNode(DataElement data){
        this.data = data;
        count = 1;
        left = new EndNode();
        right = new EndNode();
    }


    /**
     * Helper method for getting the reference to the left follower
     */
    @Override
    public Node getLeft(){
        return left;
    }

    /**
     * Helper method for getting the reference to the right follower
     */
    @Override
    public Node getRight(){
        return right;
    }

    /**
     * Helper method for getting the referenced data of this node
     */
    @Override
    public DataElement getData(){
        return data;
    }

    /**
     * Helper method for getting the current count of times this data has been appended
     */
    @Override
    public int getCount(){
        return count;
    }

    /**
     * Recursive method to insert the given data sorted into the binary tree.
     * If an item is already present the count of it being inserted is increased.
     * @param data the data that shall be inserted
     */
    @Override
    public Node insert(DataElement data) {
        if(data.isGreater(this.data)) {
            right = right.insert(data);
        } else if (data.equals(this.data)){
            count++;
        } else {
            left = left.insert(data);
        }
        return this; 
    }

    /**
     * Recursive method to print the tree in a given Order, determined by the Enum Order
     * @param order the chosen order 
     */
    @Override
    public void print(Order order) {
        if(order == Order.PRE) {
            System.out.print(data.toString());
            left.print(order);
            right.print(order);
        } else if (order == Order.IN) {
            left.print(order);
            System.out.print(data.toString());
            right.print(order);
        } else if (order == Order.POST) {
            left.print(order);
            right.print(order);
            System.out.print(data.toString());
        } 
    }

    /**
     * Recursive method to determine, if a given data element is present
     * in the tree. Returns true, if the data matches the nodes data. 
     * It calls itself on the right child, if the given data is greater than
     * the own data, otherwise on the left child. 
     * @param data the data, that is being searched
     */
    @Override
    public boolean contains(DataElement data) {
        if(data.equals(this.data)) {
            return true;
        }
        if(data.isGreater(this.data)){
            return right.contains(data);
        } else {
            return left.contains(data);
        }
    }

    /**
     * Recursive method to search for the reference to the node
     * of a given data element. Returns the reference, if the data matches the nodes data. 
     * It calls itself on the right child, if the given data is greater than
     * the own data, otherwise on the left child. 
     * @param data the data, that is being searched
     * @return returns a reference to the searched Node
     */
    @Override
    public Node search(DataElement data) {
        if(data.equals(this.data)){
            return this;
        } 
        if(data.isGreater(this.data)) {
            return right.search(data);
        } else {
            return left.search(data);
        }
    }

    /**
     * Recursive method to delete a Node in the tree. It checks, if the right 
     * child is the Node to delete, if so, it replaces it with the biggest
     * node in the right subtree. Similarily, if the left child is the Node to delete.
     * Ohterwise the method is called on the left or right child, determined by the
     * order of the given data element.
     * @param data the data element that shall be deleted
     * @return returns a reference to the deleted node
     */
    @Override
    public Node delete(DataElement data) {
        if(data.isGreater(this.data)) {
            if(right.getData().equals(data)) {
                Node oldRight = right;
                right = right.getMaxRightSubtree();
                right.setLeft(oldRight.getLeft());
                right.setRight(oldRight.getRight());
                return oldRight;
            } else {
                return right.delete(data);
            }
        } else {
            if(left.getData().equals(data)) {
                Node oldLeft = left;
                left = left.getMaxRightSubtree();
                left.setRight(oldLeft.getRight());
                left.setLeft(oldLeft.getLeft());
                return oldLeft;
            } else {
                return left.delete(data);
            }
        }
    }

    /**
     * A recursive helper method, that finds the height of the tree at the given node.
     * @return returns the maximum of the method calls on the left and right child + 1
     */
    public int getDepthFromHere(){
        return Math.max(left.getDepthFromHere() + 1, right.getDepthFromHere() + 1);
    }

    /**
     * A recursive helper method to find the Node with the biggest data in the right
     * subtree. 
     * @return returns the reference to the node that is being searched
     */
    @Override
    public Node getMaxRightSubtree() {
        if(right.getRight().getData() == null) {
            Node tmp = right;
            right = right.getRight();
            return tmp;
        } else {
            return right.getMaxRightSubtree();
        }
    }

    /**
     * Helper method to set a new left child of this node
     */
    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Helper method to set a new right child of this node
     */
    @Override
    public void setRight(Node right) {
        this.right = right;
    }

}