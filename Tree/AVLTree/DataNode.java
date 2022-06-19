package Tree.AVLTree;

public class DataNode implements Node{

    private int data;
    private int count;
    private int balancefactor;
    private Node left;
    private Node right;
    private Node parent;

    public DataNode(int data, Node parent){
        this.parent = parent;
        this.data = data;
        count  = 1;
        left = new EndNode();
        right = new EndNode();
    }

    public Node insert(int data, Node parent){
        if(data > this.data) {
            right = right.insert(data, this);
        } else if(data == this.data) {
            count++;
            this.parent = parent;
        } else {
            left = left.insert(data, this);
        }
        return this;
    }
    
    public void rebalance(){
        int balance = left.getHeight() - right.getHeight();
        if(Math.abs(balance) < 2) {
            right.rebalance();
            left.rebalance();
        } else if(balance == -2) {
            Node tmp = right.getLeft();
            Node tmpRight = right;
            right.setLeft(this);
            right = tmp;
            parent = tmpRight;
        } 
    }

    public boolean checkBalance() {
        int balance = left.getHeight() - right.getHeight();
        System.out.println("balance of Node " + data + " is " + balance);
        if(Math.abs(balance) >= 2) {
            return false;
        } else {
            return (right.checkBalance() && left.checkBalance());
        }
    }

    public int getHeight(){
            return Math.max(left.getHeight() + 1, right.getHeight() + 1);
    }

    public int getData(){
        return data;
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft(){
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void print(Order order) {
        if(order == Order.PRE) {
            System.out.print("Node " + data + " -- ");
            left.print(order);
            right.print(order);
        } else if (order == Order.IN) {
            left.print(order);
            System.out.print("Node " + data + " -- ");
            right.print(order);
        } else if (order == Order.POST) {
            left.print(order);
            right.print(order);
            System.out.print("Node " + data + " -- ");
        } 
    }

}
