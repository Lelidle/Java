package List.LinkedListNode.English;

public class Human implements DataElement{
    
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

    public String getName(){
        return name;
    }

    public void presentation(){
        System.out.println("I am " + name + " and I am " + age + " years old");
    }

}