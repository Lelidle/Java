package List.Array.English;
import List.ListInterface;
import List.Sorter;
import List.SortingMethod;

public class MyListArray implements ListInterface<Human> {

    private Human[] queue;
    private int count;
    private SortingMethod sortingMethod = SortingMethod.BUBBLE; 

    /**
     * Constructor for the List, internally represented as an array
     * @param length defines the length of the list
     */
    public MyListArray(int length) {
        queue = new Human[length];
        count = 0;
    }
    /**
     * Helper getter method for testing
     * @return returns the current array that represents the list
     */
    public Human[] getQueue() {
        return queue;
    }

    public void setQueue(Human[] queue){
        this.queue = queue;
    }

    public void setSortingMethod(SortingMethod method){
        sortingMethod = method;
    }

    /**
     * appends a new human, does not work when the list is full
     * @param human only objects of class Human can be appended
     */
    @Override
    public void append(Human human) {
        if(count < queue.length) {
            queue[count] = human;
            count++;
        } else {
            appendWhenFull(human);
        }         
    }

    /**
     * A method that appends a Human once the queue is full.
     * @param human only objects of class Human can be appended
     */
    public void appendWhenFull(Human human) {
        Human[] newQueue = new Human[queue.length + 10];
        for(int i = 0; i < queue.length; i++){
            newQueue[i] = queue[i];
        }
        count++;
        newQueue[queue.length] = human;
        queue = newQueue;
    }

    /**
     * Prints all Humans in the list, using the presentation function of Humans
     */
    @Override
    public void printList() {
        for(int i = 0; i < queue.length; i++){
            if(queue[i] == null) {
                break;
            }
            queue[i].presentation();
        }
    }

    /**
     * removes the first element of the list
     * @return a reference to the former first element of the list
     */
    @Override
    public Human pop() {
        Human toReturn = queue[0];
        for(int i = 0; i < queue.length -1; i++){
            if (queue[i+1] == null){
                break;
            }
            queue[i] = queue[i+1];
        }
        queue[queue.length-1] = null;
        return toReturn;
    }

    /**
     * Finds and returns the Human at the specified position
     * Returns null, when there is no element!
     * @param position the position in the array (starts at 1!)
     */
    @Override
    public Human getItemAtPosition(int position) {
        return queue[position-1];
    }

    /**
     * A method to determine the current length of the Queue
     * @return returns the length of the current fill status of the array
     */
    @Override
    public int length(){
        int counter = 0;
        for(int i = 0; i < queue.length;i++){
            if(queue[i] != null) counter++;
        }
        return counter;
    }

    /**
     * Searches a specified human in the queue and returns the position
     * @param searchValue an object of class Human that is being searched
     * @return returns -1, if the human is not in the list
     */
    @Override
    public int searchItemPosition(Human human) {
        for(int i = 0; i < queue.length; i++){
            if(queue[i].equals(human)){
                return i;
            }
        }
        System.out.println("The item is not in the list");
        return -1;
    }

    /**
     * Checks if a human is currently in the queue
     * @param human the human that is being looked for
     * @return the boolean that models the answer to the question
     */
    @Override
    public boolean contains(Human human) {
        for(int i = 0; i < queue.length; i++) {
            if(human.equals(queue[i])) return true;
        }
        return false;
    }
    
    /**
     * Removes the human at the given position (position starts at 1!)
     * @param position the position of the human to remove, starts at 1
     * @return returns a reference to the removed human
     */
    @Override
    public Human removeAt(int position) {
        Human toReturn = queue[position - 1];
        for(int i = position; i < queue.length - 1; i++) {
            queue[i] = queue[i+1];
        }
        queue[queue.length-1] = null;
        return toReturn;
    }
    
    /**
     * Method to concatenate two lists. Only oncatenates if o is an object of
     * type MyList. Otherwise it returns the list without change
     * @param o Object has to be of type MyList to concatenate
     * @return returns the new concatenated list or the old one, if o is not of type MyList
     */
    @Override
    public Object concatenate(Object o) {
        if(!(o instanceof MyListArray)) {
            System.out.println("Concatenation failed, Object is not of the same type");
            return this;
        } else {
            MyListArray toConcat = (MyListArray) o;
            MyListArray newList = new MyListArray(this.getQueue().length + toConcat.getQueue().length -1);
            int counter = 0;
            for(int i = 0; i < this.length();i++) {
                if(queue[i] != null){
                    counter++;
                    newList.getQueue()[i] = queue[i];
                } else {
                    break;
                }
            }
            for(int i = 0; i < toConcat.length(); i++){
                newList.getQueue()[counter + i] = toConcat.getQueue()[i];
            }
            return newList;
        }
    }
    /**
     * appends the Human in an ascending order (compared by age).
     * Sorting Method can be chosen by using setSortingMethod(method).
     * @param human the human to append
     */
    public void appendSorted(Human human) {
        if(queue[0] == null){
            queue[0] = human;
            count++;
        } else {
            this.append(human);
            Sorter sorter = new Sorter();
            sorter.sort(this, sortingMethod);
        }
    }
}
