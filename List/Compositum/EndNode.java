package List.Compositum;

public class EndNode extends Node {

    /**
     * Functionless Override
     */
    @Override
    public void setNext(Node node) {
        System.out.println("This is an end, it has no successor");
    }

    /**
     * Functionless Override, returns null
     */
    @Override
    public Node getNext() {
        System.out.println("This is an end, it has no successor");
        return null;
    }

    /**
     * Recursive method for appending a new Node between this and the last node
     * @param data the data for the new Node
     * @return returns a new DataNode with this as its next
     */
    @Override
    public Node push(DataElement data) {
        return new DataNode(this, data);
    }

    /**
     * A recursive method to insert a new Node sorted, only called when it is the
     * biggest dataelement in the list so far. 
     * @param data the data for the new node
     * @return returns a new DataNode with this as its next
     */
    @Override
    public Node appendSorted(DataElement data) {
        return new DataNode(this, data);
    }

    /**
     * Functionless Override, returns null
     */
    @Override
    public DataElement getData() {
        System.out.println("This is an end, it has no data");
        return null;
    }

    /**
     * Functionless Override, just returns
     */
    @Override
    public void printList() {
        return;    
    }

    /**
     * Recursive method to find the position of a given dataelement.
     * Only called when the item is not in the list, returns -1 then. 
     * @param data the data that has been searched
     * @param counter a helper counter for searching the position
     * @return returns -1 as indicator that the item is not in the list
     */
    @Override
    public int searchItemPosition(DataElement data, int counter) {
        return -1;
    }

    /**
     * Functionless Override
     * @return returns null as indicator, that there is no item at this position
     */
    @Override
    public DataElement getItemAtPosition(int position, int counter) {
        return null;
    }

    /**
     * Recursive method to check whether an item is in the list.
     * @param data the data that is being checked
     * @return returns false as the item is not in the list
     */
    @Override
    public boolean contains(DataElement data) {
        return false;
    }

    /** 
     * Recursive method to determine the length of the list.
     * @return returns 0 as the EndNode is not part of the actual list
     */
    @Override
    public int length() {
        return 0;
    }

    /**
     * Functionless Override, not used for removal
     */
    @Override
    public void remove(DataElement data) {}
    
    /**
     * Functionless Override, not used for removal
     * @return returns functionless null
     */
    @Override
    public DataElement removeAt(int position, int counter){
        System.out.println("The list is not that long!");
        return null;
    }

    /**
     * Recursive Method to find the last DataNode. 
     * @param node gets the last node in the list as refernce
     * @return returns the given node again 
     */
    @Override
    public Node findEnd(Node node){
        return node; 
    }
}
