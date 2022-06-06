package Tree.BinarySearchTree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class TreeTest {

    private BinaryTree tree;

    public TreeTest(){
        tree = new BinaryTree();
    }

    @Test
    void testInsert() {
        tree.insert(new Word("biene"));
        tree.insert(new Word("apfel"));
        tree.insert(new Word("abba"));
        tree.insert(new Word("quader"));
        tree.insert(new Word("auto"));

    }

    @Test
    void testPrint(){
        testInsert();
        System.out.println("Pre-Order, expected: biene apfel abba auto quader");
        tree.print(Order.PRE);
        System.out.println();
        System.out.println("In-Order, expected: abba apfel auto biene quader");
        tree.print(Order.IN);
        System.out.println();
        System.out.println("Post-Order: abba auto apfel quader biene");
        tree.print(Order.POST);
    }

    @Test
    void testSearch(){
        testInsert();
        //assertEquals(new Word("abba"), tree.search(new Word("abba")).getData());
        assertEquals(null, tree.search(new Word("bibber")));
    }

    @Test
    void testGetDepthFromHere(){
        testInsert();
        tree.insert(new Word("aaaa"));
        assertEquals(4, tree.getRoot().getDepthFromHere());
        assertEquals(3, tree.getRoot().getLeft().getDepthFromHere());
        assertEquals(1, tree.getRoot().getRight().getDepthFromHere());
    }

    @Test
    void searchTest(){
        testInsert();
        Node test = tree.search(new Word("auto"));
        Word testWord = (Word) ((DataNode) test).getData();
        assertEquals("auto", testWord.getData());
    }

    @Test
    void testGetMaxRightSubtree(){
        testInsert();
        assertEquals("quader", ((Word) ((DataNode) tree.getRoot().getMaxRightSubtree()).getData()).getData());
        assertEquals("auto", ((Word) ((DataNode) tree.getRoot().getLeft().getMaxRightSubtree()).getData()).getData());
        tree.print(Order.PRE);
    }

    @Test 
    void testDelete(){
        testInsert();
        tree.print(Order.PRE);
        System.out.println();
        assertEquals("quader", ((Word)((DataNode) tree.getRoot().delete(new Word("quader"))).getData()).getData());
        tree.print(Order.PRE);
        tree.delete(new Word("apfel"));
        System.out.println();
        tree.print(Order.PRE);
    }
}
