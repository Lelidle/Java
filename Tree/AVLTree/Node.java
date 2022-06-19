package Tree.AVLTree;

public interface Node{

    public abstract Node insert(int data, Node parent);
    public abstract void rebalance();  
    public abstract int getHeight();
    public abstract int getData();
    public abstract Node getRight();
    public abstract Node getLeft();
    public abstract boolean checkBalance();
    public abstract void setLeft(Node left);
    public abstract void setRight(Node right);
    public abstract void print(Order order);
}
