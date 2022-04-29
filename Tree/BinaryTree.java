package Tree;

public class BinaryTree {
    Node root;

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
        root.append(data);
    }

}