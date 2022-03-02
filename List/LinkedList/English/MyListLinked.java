package List.LinkedList.English;

import List.ListInterface;

public class MyListLinked implements ListInterface<Human> {

    private Human root;

    /**
     * Constructor for the list, only sets the root to null
     */
    public MyListLinked(){
        root = null;
    }

    /**
     * Sets a new human or calls append on the root human
     * @param human the reference to the human that shall be appended
     */
    @Override
    public void append(Human human) {
        if(root == null) {
            root = human;
        } else {
            root.append(human);
        }
        
    }

    /**
     * Removes the root and returns it, if present
     * @return returns a reference to the former first element
     */
    @Override
    public Human pop() {
        if(root == null){
            System.out.println("The list is empty!");
            return null;
        } else {
            Human toReturn = root;
            root = root.getNext();
            return toReturn;
        }
    }

    /**
     * Prints all the list information by running through all Humans
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
     * Searches for an element at the given position in the list
     * @param position the position in the list, starts at 0!
     * @return returns the list at the given position, can be null!
     */
    @Override
    public Human getItemAtPosition(int position) {
        int counter = 0;
        Human found = root.getItemAtPosition(position, counter);
        return found;
    }

    /**
     * Searches the position of the given human in the list
     * @param human the human that is being searched
     * @return returns the position in the list, starts at 0
     */
    @Override
    public int searchItemPosition(Human human) {
        int counter = 0;
        int searched = root.searchItemPosition(human,counter);
        return searched;
    }

    /**
     * Checks if a human is in the list 
     * @param human the human that is being searched
     * @return returns true, if the human is in the list, false otherwise
     */
    @Override
    public boolean contains(Human human) {
        return root.contains(human);
    }

    /**
     * Calculates the length of the current list
     * @return returns the length of the list
     */
    @Override
    public int length() {
        return root.length();
    }

    /**
     * method for testing
     * @return returns a reference to the current root
     */
    public Human getRoot(){
        return root;
    }

    /**
     * Removes the human at the given position if present and returns it
     * @param position the position that shall be removed
     * @return returns a reference to the removed human
     */
    @Override
    public Human removeAt(int position) {
        int counter = 1;
        return root.removeAt(position, counter);
    }
    
    /**
     * Helper Method to find the end of the list
     * @return returns a reference to the last element of the list.
     */
    public Human findEnd(){
        if(root != null) {
            return root.findEnd();
        } else {
            return null;
        }
    }

    /**
     * Method to concatenate two lists. Only oncatenates if o is an object of
     * type MyList. Otherwise it returns the list without change
     * @param o Object has to be of type MyList to concatenate
     * @return returns the new concatenated list or the old one, if o is not of type MyList
     */
    @Override
    public Object concatenate(Object o) {
        if(!(o instanceof MyListLinked)) {
            return this;
        } 
        MyListLinked toConcat = (MyListLinked) o;
        Human end = this.findEnd();
        end.setNext(toConcat.getRoot());
        return this;
    }
    
}
