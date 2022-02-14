package List.LinkedListNode.English;

public class Node {
    
    private Node next;
    private Human value;
    
    /**
     * constructor
     * Initializes the next node as null;
     */
    public Node(Human human){
        next = null;
        value = human;
    }

    /**
     * Sets the next Node
     * @param node a reference to the Node that shall be the next one
     */
    public void setNext(Node node){
        next = node;
    }
    /**
     * Returns the next following Node.
     */
    public Node getNext(){
        return next;
    }

    /**
     * 
     * @param node
     */
    public void append(Node node){
        if(next == null){
            next = node;
        } else {
            next.append(node);
        }
    }

    public Object getInfo() {
        return value;
    }

    public void printList(){
        value.presentation();
        if (next != null) next.printList();
    }

    public int searchItemPosition(Node node, int counter){
        if(node.equals(this)){
            return counter;
        } 
        if(next != null) {
            return next.searchItemPosition(node, counter+1);
        } else {
            return -1;
        }
    }

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

    public boolean contains(Node node) {
        if(node.equals(this)) {
            return true;
        } else {
            if(next != null){
                return next.contains(node);
            } else {
                return false;
            }
            
        }
    }

    public int length(int counter){
        if(next != null){
            return next.length(counter + 1);
        } else {
            return counter +1;
        }
    }
}