package List.LinkedListNode.English;

import List.ListInterface;

public class MyList implements ListInterface<Node>{
    
    private Node root;

    public MyList(){
        root = null;
    }

    public Node getRoot() {
        return root; 
    }

    @Override
    public void append(Node node){
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
    public Node remove(){
        if(root.equals(null)){
            System.out.println("No list, nothing to remove");
            return null;
        } else {
            Node toReturn = root;
            root = root.getNext();
            return toReturn;
        }
    }


    @Override
    public Node getItemAtPosition(int position) {
        int counter = 1;
        Node found = root.getItemAtPosition(position, counter);
        return found;
    }

    @Override
    public int searchItemPosition(Node node) {
        int counter = 0;
        int searched = root.searchItemPosition(node,counter);
        return searched;
    }

    @Override
    public boolean contains(Node node) {
        return root.contains(node);
    }

    @Override
    public int length() {
        return root.length(0);
    }


}
