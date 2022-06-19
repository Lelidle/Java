package Tree.AVLTree;

public class EndNode implements Node{

    @Override
    public Node insert(int data, Node parent) {
        return new DataNode(data, parent);   
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

    @Override
    public boolean checkBalance() {
        return true;
    }

    @Override
    public void setLeft(Node left) {}

    @Override
    public void setRight(Node right) {}
    
    @Override
    public void print(Order order) {return;}
}
