package Graph;

public class Node {
    
    private String data;
    private int number; 

    public Node(int number) {
        this.number = number;
    }

    public Node(String data, int number) {
        this.data = data;
        this.number = number;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData(){
        return data;
    }

    public int getNumber(){
        return number; 
    }

}
