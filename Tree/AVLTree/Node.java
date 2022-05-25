package Tree.AVLTree;

public interface Node{

    public abstract Node insert(int data);
    public abstract void rebalance();  
    public abstract int getHeight();
    public abstract int getData();
    public abstract Node getRight();
    public abstract Node getLeft();


}
