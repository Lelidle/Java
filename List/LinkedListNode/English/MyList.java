package List.LinkedListNode.English;

import List.ListInterface;

public class MyList implements ListInterface<DataElement>{
    
    private Node root;

    public MyList(){
        root = null;
    }

    public Node getRoot() {
        return root; 
    }

    @Override
    public void append(DataElement data){
        Node node = new Node(data);
        if(root == null) {
            root = node;
        } else {
            root.append(node);
        }
    }

    @Override
    public void printList() {
        if(root == null){
            System.out.println("No list here to print!");
        } else {
            root.getNext().printList();
        }
    }

    @Override
    public DataElement remove(){
        if(root.equals(null)){
            System.out.println("No list, nothing to remove");
            return null;
        } else {
            DataElement toReturn = root.getData();
            root = root.getNext();
            return toReturn;
        }
    }


    @Override
    public DataElement getItemAtPosition(int position) {
        int counter = 1;
        Node found = root.getItemAtPosition(position, counter);
        return found.getData();
    }

    @Override
    public int searchItemPosition(DataElement data) {
        int counter = 0;
        int searched = root.searchItemPosition(new Node(data),counter);
        return searched;
    }

    @Override
    public boolean contains(DataElement data) {
        return root.contains(new Node(data));
    }

    @Override
    public int length() {
        return root.length();
    }


}
