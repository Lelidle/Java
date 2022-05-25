package Tree.AVLTree;

public class AvlTree {
    
    private Node root;

    public AvlTree(){
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    public void insert(int data) {
        if(root == null) {
            root = new DataNode(data);
        } else {
            root.insert(data);
        }
        rebalance();
    }

    private void rebalance() {
        root.rebalance();
    }


}
