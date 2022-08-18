package List.LinkedListNode;

public class Human extends DataElement{
    
    private String name;
    private int age; 

    /**
     * constructor for a basic human
     * @param name name of the human
     * @param age age of the human
     */
    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * Helper method to get the Name of the human
     * @return returns the name of the human
     */
    public String getName(){
        return name;
    }

    /**
     * Helper method to get the age of the humn
     * @return returns the age of the human
     * @return
     */
    public int getAge(){
        return age;
    }

    /**
     * Helper method for testing, let's a human present the information
     */
    @Override
    public void presentation(){
        System.out.println("I am " + name + " and I am " + age + " years old");
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