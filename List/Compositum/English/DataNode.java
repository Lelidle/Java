package List.Compositum.English;

public class DataNode extends Node {

    private Node next;
    private DataElement data;

    /**
     * constructor that initializes the next node as null and sets data
     * @param data the DataElement that is stored in this node
     */
    public DataNode(Node node, DataElement data){
        next = node;
        this.data = data;
    }

    @Override
    public void setNext(Node node) {
        next = node;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public Node appendBack(DataElement data) {
        next = next.appendBack(data);
        return this; 
    }

    @Override
    public void appendSorted(DataElement Data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public DataElement getData() {
        return data;
    }

    @Override
    public void printList() {
        data.presentation();
        next.printList(); 
    }

    @Override
    public int searchItemPosition(DataElement data, int counter) {
        if(this.getData().equals(data)){
            return counter;
        } else {
            return next.searchItemPosition(data, counter +1);
        }
    }

    @Override
    public DataElement getItemAtPosition(int position, int counter) {
        if(counter == position){
            return this.getData();
        } else {
            return next.getItemAtPosition(position, counter + 1);
        }
    }

    @Override
    public boolean contains(DataElement data) {
        if(this.getData().equals(data)){
            return true;
        } else {
            return next.contains(data);
        }
    }

    @Override
    public int length(int counter) {
        return next.length(counter + 1);
    }

    @Override
    public void remove(DataElement data) {
        if(next.getData().equals(data)){
            next = next.getNext();
        }
    }
    
}
