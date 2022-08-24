package List.Compositum;

/**
 * Abstract class that defines the necessary behaviour of a data element
 * for the list. presentation() presents details on the console for 
 * the given dataelement. isGreater() defines a method for comparison.
 */
public interface DataElement {
    public void presentation();
    public boolean isGreater(DataElement data);
    public boolean equals(Object o);
}
