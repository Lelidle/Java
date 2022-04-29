package Tree;

public class EndNode extends Node {

    @Override
    public Node append(DataElement data) {
        return new DataNode(data);
    }
    
}
