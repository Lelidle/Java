package List.Compositum.English;

import List.ListInterface;

public class MyList implements ListInterface<DataElement>{

    private Node root;

    public MyList(){
        root = new EndNode();
    }

    public Node getRoot(){
        return root;
    }
    /**
     * Appends a new Node in front as the new root.
     * @param data the data to fille the Node
     */
    @Override
    public void append(DataElement data) {
        root = new DataNode(root, data);
    }

    @Override
    public DataElement remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void printList() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public DataElement getItemAtPosition(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int searchItemPosition(DataElement searchValue) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(DataElement searchValue) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
