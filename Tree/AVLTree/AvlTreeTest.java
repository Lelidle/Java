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

    @Test 
    void testCheckBalance() {
        testInsert();
        assertEquals(true, testTree.checkBalance());
    }

    @Test
    void testRebalance() {
        testTree.insert(3);
        testTree.printTree(Order.PRE);
        System.out.println();
        testTree.insert(2);
        testTree.printTree(Order.PRE);
        System.out.println();
        testTree.insert(4);
        testTree.printTree(Order.PRE);
        System.out.println();
        testTree.insert(6);
        testTree.printTree(Order.PRE);
        System.out.println();
        testTree.insert(5); 
        testTree.printTree(Order.PRE);
        System.out.println();
        /*
        assertEquals(6, testTree.getRoot().getRight().getRight().getData());
        testTree.insert(7);
        System.out.println();
        testTree.printTree(Order.PRE);
        assertEquals(4, testTree.getRoot().getData());
        assertEquals(6 , testTree.getRoot().getRight().getData());
        assertEquals(3, testTree.getRoot().getLeft().getData());
        assertEquals(5, testTree.getRoot().getLeft().getRight().getData());
        assertEquals(2, testTree.getRoot().getLeft().getLeft().getData());
        */
    }

}
