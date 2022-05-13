package Tree;

public class DataNode extends Node {

    private DataElement data;
    private Node left;
    private Node right;

    public DataNode(DataElement data){
        this.data = data;
        left = new EndNode();
        right = new EndNode();
    }

    @Override
    public Node getLeft(){
        return left;
    }

    @Override
    public Node getRight(){
        return right;
    }

    @Override
    public DataElement getData(){
        return data;
    }

    @Override
    public Node append(DataElement data) {
        if(data.isGreater(this.data)) {
            right = right.append(data);
        } else {
            left = left.append(data);
        }
        return this; 
    }

    @Override
    public void print(Order order) {
        if(order == Order.PRE) {
            System.out.print(data.toString());
            left.print(order);
            right.print(order);
        } else if (order == Order.IN) {
            left.print(order);
            System.out.print(data.toString());
            right.print(order);
        } else if (order == Order.POST) {
            left.print(order);
            right.print(order);
            System.out.print(data.toString());
        } 
    }

    @Override
    public boolean contains(DataElement data) {
        if(data.equals(this.data)) {
            return true;
        }
        if(data.isGreater(this.data)){
            return right.contains(data);
        } else {
            return left.contains(data);
        }
    }

    @Override
    public Node search(DataElement data) {
        if(data.equals(this.data)){
            return this;
        } 
        if(data.isGreater(this.data)) {
            return right.search(data);
        } else {
            return left.search(data);
        }
    }

    @Override
    public Node delete(DataElement data) {
        if(data.isGreater(this.data)) {
            if(right.getData().equals(data)) {
                Node oldRight = right;
                right = right.getMaxRightSubtree();
                right.setLeft(oldRight.getLeft());
                right.setRight(oldRight.getRight());
                return oldRight;
            } else {
                return right.delete(data);
            }
        } else {
            if(left.getData().equals(data)) {
                Node oldLeft = left;
                left = left.getMaxRightSubtree();
                left.setRight(oldLeft.getRight());
                left.setLeft(oldLeft.getLeft());
                return oldLeft;
            } else {
                return left.delete(data);
            }
        }
    }

    public int getDepthFromHere(){
        return Math.max(left.getDepthFromHere() + 1, right.getDepthFromHere() + 1);
    }

    @Override
    public Node getMaxRightSubtree() {
        if(right.getRight().getData() == null) {
            Node tmp = right;
            right = right.getRight();
            return tmp;
        } else {
            return right.getMaxRightSubtree();
        }
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }

}