package Tree.AVLTree;

public class EndNode implements Node{

    @Override
    public Node insert(int data) {
        return new DataNode(data);   
    }

    @Override
    public void rebalance() {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getData() {
        return 0;
    }

    @Override
    public Node getRight() {
        return null;
    }

    @Override
    public Node getLeft() {
        return null;
    }
    
}
