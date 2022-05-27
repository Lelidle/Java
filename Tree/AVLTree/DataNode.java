package Tree.AVLTree;

public class DataNode implements Node{

    int data;
    int count;
    Node left;
    Node right;


    public DataNode(int data){
        this.data = data;
        count  = 1;
        left = new EndNode();
        right = new EndNode();
    }

    public Node insert(int data){
        if(data > this.data) {
            right = right.insert(data);
        } else if(data == this.data) {
            count++;
        } else {
            left = left.insert(data);
        }
        return this;
    }
    
    public void rebalance(){
        int balance = right.getHeight() - left.getHeight();
        if(balance < 2) {
            right.rebalance();
            left.rebalance();
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

    public Node getLeft(){
        return left;
    }

}
