package List.LinkedList.English;

public class Human {
    
    private String name;
    private int age; 
    private Human next;

    /**
     * A constructor that specifies a human
     * @param name the name of the human
     * @param age the age of the human
     */
    public Human(String name, int age){
        this.name = name;
        this.age = age;
        next = null;
    }

    /**
     * getter method for the private attribute name
     * @return returns the name of the human
     */
    public String getName(){
        return name;
    }

    /**
     * getter method for the private attribute age
     * @return returns the age of the human
     */
    public int getAge(){
        return age;
    }
    /**
     * getter method for the private attribute next
     * @return returns the reference to the next human in the list
     */
    public Human getNext(){
        return next;
    }

    public void setNext(Human human){
        next = human;
    }

    /**
     * Checks if next is a nullpointer, if so it appends the human
     * by referencing it, otherwise it calls append on the next human
     * in the list
     * @param human the reference to the human that is appended
     */
    public void push(Human human) {
        if(next == null) {
            next = human;
        } else {
            next.push(human);
        }
    }

    /**
     * Presents own information and calls printList on the next Human
     * in the last, if there is a next
     */
    public void printList(){
        presentation();
        if (next != null) next.printList();
    }

    /**
     * Searches for the Position of a given Human in the list
     * @param human the object of class Human that needs to be found
     * @param counter a counter to find the position
     * @return return the position of the object or -1 if it is not in the list
     */
    public int searchItemPosition(Human human, int counter){
        if(human.equals(this)){
            return counter;
        } 
        if(next != null) {
            return next.searchItemPosition(human, counter+1);
        } else {
            return -1;
        }
    }

    /**
     * Returns a reference to the human at the given position
     * @param position the position in the list
     * @param counter a counter to find the position recursively
     * @return returns a reference to the searched element
     */
    public Human getItemAtPosition(int position, int counter){
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
     * @param human the human that shall is being checked
     * @return returns true if the data is in this node, otherwise it returns
     * the result of the next node in the list. 
     */
    public boolean contains(Human human) {
        if(human.equals(this)) {
            return true;
        } else {
            if(next != null){
                return next.contains(human);
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
     * Removes an element at a specificed position and returns the reference to it.
     * If the next node is the one to remove, it sets a new reference
     * @param position the index in the list that shall be removed
     * @param counter a helper counter to search the right position
     * @return  returns this human, if the counter is equal to position - 1.
     * Otherwise it returns the result of the method call on next with counter+1
     */
    public Human removeAt(int position, int counter){
        if(counter == position - 1) {
            next = next.getNext();
            return next;
        } else {
            return next.removeAt(position, counter + 1);
        }
    }

    /**
     * Helper method for testing, let's a human present the information
     */
    public void presentation(){
        System.out.println("I am " + name + " and I am " + age + " years old");
    }

    /**
     * A recursive helper method to find the end of the list
     * @return returns itself if there is no next Item
     */
    public Human findEnd(){
        if(next == null) {
            return this;
        } else {
            return next.findEnd();
        }
    }

    /**
     * Overrides the comparison method to check whether the human
     * has the same age and name as this object
     * @param o the compared object
     * @return returns a boolean stating if both objects are equal
     */
    @Override
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(! (o instanceof Human)){
            return false;
        } 
        Human h = (Human) o;
        if(h.getName() == this.name && h.getAge() == this.age){
            return true;
        } else {
            return false;
        }
    }
}
