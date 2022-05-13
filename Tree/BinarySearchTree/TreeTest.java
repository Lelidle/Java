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
    void testAppend() {
        tree.append(new Word("biene"));
        tree.append(new Word("apfel"));
        tree.append(new Word("abba"));
        tree.append(new Word("quader"));
        tree.append(new Word("auto"));

    }

    @Test
    void testPrint(){
        testAppend();
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
        testAppend();
        assertEquals(true, tree.search(new Word("abba")));
        assertNotEquals(true, tree.search(new Word("bibber")));
    }

    @Test
    void testGetDepthFromHere(){
        testAppend();
        tree.append(new Word("aaaa"));
        assertEquals(4, tree.getRoot().getDepthFromHere());
        assertEquals(3, tree.getRoot().getLeft().getDepthFromHere());
        assertEquals(1, tree.getRoot().getRight().getDepthFromHere());
    }

    @Test
    void searchTest(){
        testAppend();
        Node test = tree.search(new Word("auto"));
        Word testWord = (Word) ((DataNode) test).getData();
        assertEquals("auto", testWord.getData());
    }

    @Test
    void testGetMaxRightSubtree(){
        testAppend();
        assertEquals("quader", ((Word) ((DataNode) tree.getRoot().getMaxRightSubtree()).getData()).getData());
        assertEquals("auto", ((Word) ((DataNode) tree.getRoot().getLeft().getMaxRightSubtree()).getData()).getData());
        tree.print(Order.PRE);
    }

    @Test 
    void testDelete(){
        testAppend();
        tree.print(Order.PRE);
        System.out.println();
        assertEquals("quader", ((Word)((DataNode) tree.getRoot().delete(new Word("quader"))).getData()).getData());
        tree.print(Order.PRE);
        tree.delete(new Word("apfel"));
        System.out.println();
        tree.print(Order.PRE);
    }
}
