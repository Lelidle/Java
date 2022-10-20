package List.LinkedListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListNodeTest {

    private MyLinkedListNode testList;
    
    public MyLinkedListNodeTest(){
        testList = new MyLinkedListNode();
        testList.push(new Human("Helmut Schmidt" , 25));
        testList.push(new Human("Max Mustermann", 27));
        testList.push(new Human("Gesine Schwan", 35));
        testList.push(new Human("Helmut Kohl", 64));
        testList.push(new Human("Bill Gates", 57));
    }
    
    @Test
    void testPush() {
        MyLinkedListNode appendTest = new MyLinkedListNode();
        appendTest.push(new Human("Bob",25));
        Assertions.assertNotEquals(null, appendTest.getRoot());
    }

    @Test
    void testPrintList() {
        System.out.println("=== Printing Test ===");
        testList.printList();
        System.out.println("There should be five humans be described above");
        System.out.println();
    }

    @Test
    void testHuman() {
        Human human = new Human("Bob", 25);
        Assertions.assertEquals("Bob", human.getName());
    }

    @Test
    void testContains() {
        Human h = new Human("Helmut Kohl", 64);
        Assertions.assertEquals(true, testList.contains(h));
    }

    @Test
    void testGetItemAtPosition() {
        
    }

    @Test
    void testLength() {
        
    }

    @Test
    void testRemove() {
        
    }

    @Test
    void testSearchItemPosition() {
        
    }


}
