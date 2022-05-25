package Tree.BinarySearchTree;

public class EndNode implements Node {

    /**
     * Recursive method to insert a new DataElement.
     * @param data the data that shall be stored in the new Node.
     * @return returns a reference to a new DataNode.
     */
    @Override
    public Node insert(DataElement data) {
        return new DataNode(data);
    }

    /**
     * stops the print call, no further usage.
     */
    @Override
    public void print(Order o) {
        return;
    }

    /**
     * Helper method, no use in EndNode.
     */
    @Override
    public DataElement getData(){
        return null;
    }

    /**
     * stops the count call and returns 0.
     */
    @Override
    public int getCount(){
        return 0;
    }

    /**
     * stops the contains call and returns false, since
     * the data was not found until now. 
     */
    @Override
    public boolean contains(DataElement data) {
        return false;
    }

    /**
     * stops the delete call, no further usage in EndNode.
     */
    @Override
    public Node delete(DataElement data) {
        return null;
    }
    
    /**
     * stops the getDepthFromHere call and returns 0.
     */
    @Override
    public int getDepthFromHere(){
        return 0;
    }

    /**
     * Helper method, no usage in EndNode.
     */
    @Override
    public Node getLeft() {
        return this;
    }

    /**
     * Helper method, no usage in EndNode.
     */
    @Override
    public Node getRight() {
        return this;
    }

    /**
     * stops the getMaxRightSubtree call and returns itself, no
     * usage in EndNode.
     */
    @Override
    public Node getMaxRightSubtree() {
        return this;
    }

    /**
     * stops the search call and returns itself, no usage in
     * EndNode.
     */
    @Override
    public Node search(DataElement data) {
        return null;
    }
    
    /**
     * Helper method, no usage in EndNode.
     */
    @Override
    public void setLeft(Node left) {}

    /**
     * Helper method, no usage in EndNode.
     */
    @Override
    public void setRight(Node right) {}

}
