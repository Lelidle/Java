package Tree.AVLTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AvlTreeTest {

    AvlTree testTree = new AvlTree();

    @Test
    void testInsert() {
        testTree.insert(5);
        testTree.insert(7);
        testTree.insert(3);
        testTree.insert(8);
        assertEquals(3, testTree.getRoot().getLeft().getData());
        assertEquals(7, testTree.getRoot().getRight().getData());
        assertEquals(8, testTree.getRoot().getRight().getRight().getData());
    }
}
