package List.Compositum.English;
import List.ListInterface;

public class MyListComp implements ListInterface<DataElement>{

    private Node root;

    public MyListComp(){
        root = new EndNode();
    }

    public Node getRoot(){
        return root;
    }
    /**
     * Appends a new Node in front as the new root.
     * @param data the data to fill the Node
     */
    @Override
    public void append(DataElement data) {
        root = new DataNode(root, data);
    }

    public void appendBack(DataElement data) {
        if(root instanceof EndNode){
            root = new DataNode(new EndNode(), data);
        } else {
            root.appendBack(data);
        }
 
    }

    public void appendSorted(DataElement data){
        root.appendSorted(data);
    }

    @Override
    public DataElement pop() {
        if(root == null){
            System.out.println("No list, nothing to remove");
            return null;
        } else {
            DataElement toReturn = root.getData();
            root = root.getNext();
            return toReturn;
        }
    }

    @Override
    public void printList() {
        if(root == null){
            System.out.println("No list here to print!");
        } else {
            root.printList();
        }
    }

    @Override
    public DataElement getItemAtPosition(int position) {
        int counter = 1;
        DataElement found = root.getItemAtPosition(position, counter);
        return found;
    }

    @Override
    public int searchItemPosition(DataElement data) {
        int counter = 0;
        int searched = root.searchItemPosition(data,counter);
        return searched;
    }

    @Override
    public boolean contains(DataElement data) {
        return root.contains(data);
    }

    @Override
    public int length() {
        return root.length();
    }

    @Override
    public DataElement removeAt(int position) {
        int counter = 1;
        return root.removeAt(position, counter);
    }

    /**
     * Finds the last Data Node in the list and returns it
     * @return
     */
    public Node findEnd(){
        if(root != null) {
            return root.findEnd(root);
        } else {
            return null;
        }
    }

    @Override
    public Object concatenate(Object o) {
        if(!(o instanceof MyListComp)){
            return this;
        } 
        MyListComp toConcat = (MyListComp) o;
        Node end = this.findEnd();
        end.setNext(toConcat.getRoot());
        return this;
    }
    
}
