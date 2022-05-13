package Tree;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = new EndNode();
    }

    public void setRoot(DataElement data) {
        root = new DataNode(data);
    }

    public Node getRoot() {
        return root;
    }

    public void append(DataElement data){
        root = root.append(data);
    }

    public void print(Order order) {
        root.print(order);
    }

    public boolean contains(DataElement data) {
        return root.contains(data);
    }

    public Node search(DataElement data) {
        return root.search(data);
    }

    public Node delete(DataElement data) {
        if(data.equals(((DataNode) root).getData())) {
            Node oldRoot = root;
            root = root.getMaxRightSubtree();
            return oldRoot;
        } 
        return root.delete(data);


    }
}