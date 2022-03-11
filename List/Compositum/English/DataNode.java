package List.Compositum.English;

public class DataNode extends Node {

    private Node next;
    private DataElement data;

    /**
     * constructor that initializes the referene to the data and next node
     * @param node the reference to the next node
     * @param data the DataElement that is stored in this node
     */
    public DataNode(Node node, DataElement data){
        next = node;
        this.data = data;
    }

    /**
     * A method to alter the reference to the next node in the list
     * @param node the reference to the new next node
     */
    @Override
    public void setNext(Node node) {
        next = node;
    }

    /**
     * A method to get the reference to the next node in the list
     * @return returns the reference to the next node
     */
    @Override
    public Node getNext() {
        return next;
    }

    /**
     * Recursive method to append a new Element to the back
     * @param data the dataelement for the new node
     * @return returns itself
     */
    @Override
    public Node appendBack(DataElement data) {
        next = next.appendBack(data);
        return this; 
    }

    /**
     * Recursive method that appends a new Element in ascending order
     * @param data the dataelement for the new Node
     * @return returns a new Node, if the data is smaller than the
     * data of this node, otherwise returns itself. 
     */
    @Override
    public Node appendSorted(DataElement data) {
        if(this.getData().isGreater(data)) {
            return new DataNode(this, data);
        }
        next = next.appendSorted(data);
        return this;
    }

    /**
     * A method to get a reference of the data in this node
     * @return the data of this Node
     */
    @Override
    public DataElement getData() {
        return data;
    }

    /**
     * Recursive method to print the list in order
     */
    @Override
    public void printList() {
        data.presentation();
        next.printList(); 
    }

    /**
     * Recursive method to search for the first position of an item in the list
     * @param data the data that is being searched
     * @param counter a helper counter to determine the position in the list
     * @return returns the counter, if the data is equal, otherwise it
     * returns the result of the method on the next node with counter+1
     */
    @Override
    public int searchItemPosition(DataElement data, int counter) {
        if(this.getData().equals(data)){
            return counter;
        } else {
            return next.searchItemPosition(data, counter +1);
        }
    }

    /**
     * Recursive method to find the reference to an item at a given position
     * in the list
     * @param position the position in queue that is being searched
     * @param counter a helper counter to determine the current position
     * @return returns the data of this node if the counter is at the given
     * position. Otherwise it returns the result of the method on the next node
     * with counter+1
     */
    @Override
    public DataElement getItemAtPosition(int position, int counter) {
        if(counter == position){
            return this.getData();
        } else {
            return next.getItemAtPosition(position, counter + 1);
        }
    }

    /**
     * Recursive method to check, if an element is in the list.
     * @param data the data that shall be checked
     * @return returns true if the data is in this node, otherwise it returns
     * the result of the next node in the list. 
     */
    @Override
    public boolean contains(DataElement data) {
        if(this.getData().equals(data)){
            return true;
        } else {
            return next.contains(data);
        }
    }

    /**
     * Recursive method to check the length of the list
     * @return returns the result of the method call on next+1
     */
    @Override
    public int length() {
        return next.length() + 1;
    }

    /**
     * Recursive Method to remove a dataelement, if it is present in the list.
     * Note: It removes every occurence of the element!
     * @param the data that shall be deleted
     */
    @Override
    public void remove(DataElement data) {
        if(next.getData().equals(data)){
            next = next.getNext();
        } else {
            next.remove(data);
        }
    }

    /**
     * Removes an element at a specificed position and returns the reference to it.
     * If the next node is the one to remove, it sets a new reference
     * @param position the index in the list that shall be removed
     * @param counter a helper counter to search the right position
     * @return  returns the data of this node, if the counter is equal to position - 1.
     * Otherwise it returns the result of the method call on next with counter+1
     */
    @Override
    public DataElement removeAt(int position, int counter){
        if(counter == position - 1){
            DataElement toReturn = next.getData();
            next = next.getNext();
            return toReturn; 
        } else {
            return next.removeAt(position, counter + 1);
        }
    }

    /**
     * Recursive method to find the last DataNode in the list
     * @param node a helper reference to be returned by the EndNode
     * @return returns the result of the method call on the next in the list
     */
    @Override
    public Node findEnd(Node node) {
        return next.findEnd(this);
    }
    
}
