package Tree;

public class EndNode extends Node {

    @Override
    public Node append(DataElement data) {
        return new DataNode(data);
    }

    @Override
    public void print(Order o) {
        return;
    }

    @Override
    public DataElement getData(){
        return null;
    }

    @Override
    public boolean contains(DataElement data) {
        return false;
    }

    @Override
    public Node delete(DataElement data) {
        return this;
    }
    
    @Override
    public int getDepthFromHere(){
        return 0;
    }

    @Override
    public Node getLeft() {
        return this;
    }

    @Override
    public Node getRight() {
        return this;
    }

    @Override
    public Node getMaxRightSubtree() {
        return this;
    }

    @Override
    public Node search(DataElement data) {
        return this;
    }

    @Override
    public void setLeft(Node left) {}

    @Override
    public void setRight(Node right) {}

}
