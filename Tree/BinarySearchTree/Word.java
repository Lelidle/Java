package Tree.BinarySearchTree;

public class Word implements DataElement {
    private String word; 

    /**
     * Basic constructor that set the attribute word
     * @param word the String that shall be our new word
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * @return returns the current Sting
     */
    public String getData(){
        return word;
    }

    /**
     * Override of the generic equals method
     * @param toCmpare the DataElement to compare to
     * @return returns true, if both words are equal
     */
    @Override
    public boolean equals(DataElement toCompare) {
        if(!(toCompare instanceof Word)) {
            return false;
        }
        if(((Word) toCompare).word.equals(word)) {
            return true;
        }
        return false;
    }

    /**
     * A method to check, if a given DataElement is greater or bigger as this one.
     * @param toCompare the DataElement to compare to
     * @return returns true, if the given DataElement is smaller than this word
     */
    @Override
    public boolean isGreater(DataElement toCompare) {
        if(!(toCompare instanceof Word)) {
            return false;
        }
        if(word.compareTo(((Word) toCompare).word) > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Helper method to print the Word prettier
     * @return returns the String of the word with an additional space
     */
    @Override
    public String toString(){
        return word + " ";
    }
}
