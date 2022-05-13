package Tree.BinarySearchTree;

public class Word extends DataElement {
    private String word; 

    public Word(String word) {
        this.word = word;
    }

    public String getData(){
        return word;
    }

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
    
    @Override
    public String toString(){
        return word + " ";
    }
}
