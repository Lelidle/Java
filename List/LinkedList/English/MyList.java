package List.LinkedList.English;

import List.ListInterface;

public class MyList implements ListInterface<Human> {

    private Human root;

    /**
     * Constructor for the list, only sets the root to null
     */
    public MyList(){
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
     */
    @Override
    public Human remove() {
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
     * @param position the position in the list, starts at 1!
     * @return returns the list at the given position, can be null!
     */
    @Override
    public Human getItemAtPosition(int position) {
        int counter = 1;
        Human found = root.getItemAtPosition(position, counter);
        return found;
    }

    @Override
    public int searchItemPosition(Human human) {
        int counter = 0;
        int searched = root.searchItemPosition(human,counter);
        return searched;
    }

    @Override
    public boolean contains(Human human) {
        return root.contains(human);
    }

    @Override
    public int length() {
        return root.length(0);
    }

    public Human getRoot(){
        return root;
    }
    
}
