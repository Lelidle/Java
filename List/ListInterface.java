package List;

public interface ListInterface<T> {
    
    public void append(T value);
    public T remove();
    public void printList();
    public T getItemAtPosition(int position);
    public int searchItemPosition(T searchValue);
    public boolean contains(T searchValue);
    public int length();
    
}