package List.LinkedListNode;

public class Node {
    
    private Node next;
    private DataElement data;
    
    /**
     * constructor that initializes the next node as null and sets data
     * @param data the DataElement that is stored in this node
     */
    public Node(DataElement data){
        next = null;
        this.data = data;
    }

    /**
     * Sets the next Node
     * @param node a reference to the Node that shall be the next one
     */
    public void setNext(Node node){
        next = node;
    }
    /**
     * Getter for the reference to the next node of this
     * @return returns a reference to the next node
     */
    public Node getNext(){
        return next;
    }

    /**
     * Recursive method to append a new Element to the back
     * @param data the dataelement for the new node
     * @return returns itself
     */
    public void push(Node node){
        if(next == null){
            next = node;
        } else {
            next.push(node);
        }
    }

    /**
     * A method to get a reference of the data in this node
     * @return the data of this Node
     */
    public DataElement getData() {
        return data;
    }

    /**
     * Recursive method to print the list in order
     */
    public void printList(){
        data.presentation();
        if (next != null) next.printList();
    }

        /**
     * Recursive method to search for the first position of an item in the list
     * @param data the data that is being searched
     * @param counter a helper counter to determine the position in the list
     * @return returns the counter, if the data is equal, otherwise it
     * returns the result of the method on the next node with counter+1. If 
     * the item is not in the list it returns -1.
     */
    public int searchItemPosition(DataElement data, int counter){
        if(this.getData().equals(data)){
            return counter;
        } 
        if(next != null) {
            return next.searchItemPosition(data, counter+1);
        } else {
            return -1;
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
    public Node getItemAtPosition(int position, int counter){
        if(counter == position) {
            return this;
        } else {
            if(next != null) {
                return next.getItemAtPosition(position, counter + 1);
            } else {
                return null; 
            }
        }
    }

    /**
     * Recursive method to check, if an element is in the list.
     * @param data the data that shall be checked
     * @return returns true if the data is in this node, otherwise it returns
     * the result of the next node in the list. 
     */
    public boolean contains(DataElement data) {
        if(this.getData().equals(data)) {
            return true;
        } else {
            if(next != null){
                return next.contains(data);
            } else {
                return false;
            }
            
        }
    }

    /**
     * Recursive method to check the length of the list
     * @return returns the result of the method call on next+1
     */
    public int length(){
        if(next != null){
            return next.length() + 1;
        } else {
            return 1;
        }
    }

    /**
     * Recursive method to find the last node in the list
     * @return returns the result of the method call on the next in the list
     */
    public Node findEnd(){
        if(next == null) {
            return this;
        } else {
            return next.findEnd();
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
    public DataElement removeAt(int position, int counter){
        if(counter == position - 1){
            next = next.getNext();
            return next.getData();
        } else {
            return next.removeAt(position, counter + 1);
        }
    }

}