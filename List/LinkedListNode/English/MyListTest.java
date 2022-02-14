package List.LinkedListNode.English;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListTest {

    private MyList testList;

    public MyListTest(){
        testList.append(new Node(new Human("Helmut Schmidt" , 25)));
        testList.append(new Node(new Human("Max Mustermann", 27)));
        testList.append(new Node(new Human("Gesine Schwan", 35)));
        testList.append(new Node(new Human("Helmut Kohl", 64)));
        testList.append(new Node(new Human("Bill Gates", 57)));
    }

    @Test
    void testAppend() {
        MyList appendTest = new MyList();
        testList.append(new Node(new Human("Bob",25)));
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
        Assertions.assertEquals(true, testList.contains(new Node(h)));
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
