package Tree;

public abstract class Node {
    
    public abstract Node append(DataElement data);
    public abstract void print(Order order);
    public abstract DataElement getData();
    public abstract boolean contains(DataElement data);
    public abstract Node search(DataElement data);
    public abstract Node delete(DataElement data);
    public abstract int getDepthFromHere();
    public abstract Node getLeft();
    public abstract void setLeft(Node left);
    public abstract Node getRight();
    public abstract void setRight(Node right);
    public abstract Node getMaxRightSubtree();
}
