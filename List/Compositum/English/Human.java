package List.Compositum.English;

public class Human extends DataElement {
    
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
     * Helper method to get the age of the human
     * @return returns the age of the human
     * @return
     */
    public int getAge(){
        return age;
    }

    /**
     * Helper method to set the age of the human
     * @param age the new age of the Human
     */
    public void setAge(int age){
        if(age >= 0 && age <=200){
            this.age = age;
        } else {
            System.out.println("Das kann kein menschliches Alter sein!");
        }
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

    /**
     * Method for comparing two humans. Uses only the age to compare
     * @param human the human that shall be compared to this
     * @return returns true if this human is older
     */
    @Override
    public boolean isGreater(DataElement data) {
        Human human = null;
        try {
            human = (Human) data;
        } catch (Exception e) {
            System.out.println("The element for the comparison is not a human!");
        }
        if(this.getAge() > human.getAge()) {
            return true;
        }
        return false; 
    }

}
