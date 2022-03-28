package List.Compositum.English;
import java.util.function.Function;

import List.ListInterface;

public class MyListComp implements ListInterface<DataElement>{

    private Node root;
    /**
     * Constructor method of the list, sets the root to a new EndNode
     */
    public MyListComp(){
        root = new EndNode();
    }

    /**
     * Helper method, returns a reference to the current root
     * @return returns a reference to the current root
     */
    public Node getRoot(){
        return root;
    }

    /**
     * Appends a new node in front as the new root.
     * @param data the data to fill the Node
     */
    @Override
    public void append(DataElement data) {
        root = new DataNode(root, data);
    }

    /**
     * Appends a new node at the end of the list
     * @param data the data that shall be appended
     */
    public void appendBack(DataElement data) {
        if(root instanceof EndNode){
            root = new DataNode(root, data);
        } else {
            root.appendBack(data);
        }
 
    }

    /**
     * Appends a new node sorted
     * @param data the data that shall be appended
     */
    public void appendSorted(DataElement data){
        root = root.appendSorted(data);
    }

    /**
     * removes the first node of the list and returns a reference to it
     * @return returns a reference to the former root
     */
    @Override
    public DataElement pop() {
        if(root == null){
            System.out.println("No list, nothing to remove");
            return null;
        } else {
            DataElement toReturn = root.getData();
            root = root.getNext();
            return toReturn;
        }
    }

    /**
     * Helper Method to print the list, uses the presentation method of 
     * a dataelement
     */
    @Override
    public void printList() {
        if(root == null){
            System.out.println("No list here to print!");
        } else {
            root.printList();
        }
    }

    /**
     * Recurisve method to return the reference to an item at a given position.
     * If the element is not present, null is returned
     * @param position the position of the element
     * @return returns a reference to the dataelement at the given position
     */
    @Override
    public DataElement getItemAtPosition(int position) {
        int counter = 1;
        DataElement found = root.getItemAtPosition(position, counter);
        return found;
    }

    /**
     * Recursive method to search the position of an item.
     * Only returns the first occurence, if the item is not present in the list,
     * -1 is returned
     * @param data the data that is being searched
     * @return returns the position in the list (starting at 0)
     */
    @Override
    public int searchItemPosition(DataElement data) {
        int counter = 0;
        int searched = root.searchItemPosition(data,counter);
        return searched;
    }

    /**
     * Recursive method to check if a dataelement is present in the list.
     * @param data the data that is being searched
     * @return returns true, if the item is present in the list
     */
    @Override
    public boolean contains(DataElement data) {
        return root.contains(data);
    }

    /**
     * Recursive method to determine the current length of the list
     * @return returns the current length of the list
     */
    @Override
    public int length() {
        return root.length();
    }

    /**
     * Recursive method to remove an item at a given position. 
     * @param position the position of the element
     * @return returns a reference to the element at the given position,
     * returns null, when the position is greater than the length of the list
     */
    @Override
    public DataElement removeAt(int position) {
        if(position == 1) {
            DataElement toReturn = root.getData();
            root = root.getNext();
            return toReturn;
        } else {
            int counter = 1;
            return root.removeAt(position, counter);
        }
    }

    /**
     * Finds the last data node in the list and returns it
     * @return returns a reference to the last data node, returns null,
     * if the list is empty.
     */
    public Node findEnd(){
        if(root != null) {
            return root.findEnd(root);
        } else {
            return null;
        }
    }

    /**
     * A method to concatenate two lists of Type MyListComp.
     * @param o: another list
     * @return returns the concatenated list or an unchanged list, if the 
     * parameter was not of type MyListComp
     */
    @Override
    public Object concatenate(Object o) {
        if(!(o instanceof MyListComp)){
            return this;
        } 
        MyListComp toConcat = (MyListComp) o;
        Node end = this.findEnd();
        end.setNext(toConcat.getRoot());
        return this;
    }
    
    /**
     * A function that takes a function that alters a human and applies it
     * to all humans in the list
     * @param func a function that alters a human
     */
    public  void map(Function<Human, Human> func) {
        Node tmp = root;
        while(tmp instanceof DataNode) {
            func.apply((Human) tmp.getData());
            tmp = tmp.getNext();
        }
    }

}
