package Tree;

public class DataNode extends Node {

    DataElement data;
    Node left;
    Node right;

    public DataNode(DataElement data){
        this.data = data;
        left = new EndNode();
        right = new EndNode();
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


}