package List.Array.English;

public class Human {
    
    private String name;
    private int age; 

    /**
     * A constructor that specifies a human
     * @param name the name of the human
     * @param age the age of the human
     */
    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * setter method for the private attribute name
     */
    public void setName(String name){
        this.name = name;
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
     * Helper method for testing, let's a human present the information
     */
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

    /**
     * Method for comparing two humans. Uses only the age to compare
     * @param human the human that shall be compared to this
     * @return returns true if this human is older
     */
    public boolean isGreater(Human human) {
        if(this.getAge() > human.getAge()) {
            return true;
        }
        return false; 
    }
}