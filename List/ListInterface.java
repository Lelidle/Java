package List;

public interface ListInterface<T> {
    
    public void push(T value);
    public T pop();
    public T removeAt(int position);
    public void printList();
    public T getItemAtPosition(int position);
    public int searchItemPosition(T searchValue);
    public boolean contains(T searchValue);
    public int length();
    public Object concatenate(Object o);

}