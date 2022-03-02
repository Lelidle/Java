package List.Compositum.English;

public abstract class Node {
    public abstract void setNext(Node node);
    public abstract Node getNext();
    public abstract Node appendBack(DataElement data);
    public abstract Node appendSorted(DataElement data);
    public abstract DataElement getData();
    public abstract void printList();
    public abstract int searchItemPosition(DataElement data, int counter);
    public abstract DataElement getItemAtPosition(int position, int counter);
    public abstract boolean contains(DataElement data);
    public abstract int length();
    public abstract void remove(DataElement data);
    public abstract DataElement removeAt(int position, int counter);
    public abstract Node findEnd(Node node);
}
