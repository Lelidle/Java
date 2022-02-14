package List.Array.English;
import List.ListInterface;

public class MyList implements ListInterface<Human> {

    private Human[] queue;
    private int count;

    /**
     * Constructor for the List, internally represented as an array
     * @param length defines the length of the list
     */
    public MyList(int length) {
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
            System.out.println("The queue is full! Sorry!");
        }         
    }

    /**
     * A method that appends a Human once the queue is full.
     * @param human only objects of class Human can be appended
     */
    public void appendWhenFull(Human human) {
        Human[] newQueue = new Human[queue.length + 1];
        for(int i = 0; i < queue.length; i++){
            newQueue[i] = queue[i];
        }
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
     */
    @Override
    public Human remove() {
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
     * @param position the position in the array
     */
    @Override
    public Human getItemAtPosition(int position) {
        return queue[position];
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
    
}
