package List.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    private MyLinkedList testList;

    public MyLinkedListTest(){
        testList = new MyLinkedList();
        testList.push(new Human("Dave",19));
        testList.push(new Human("Martha", 51));
        testList.push(new Human("Tim", 45));
        testList.push(new Human("Adalbert", 65));
    }

    @Test
    void testPush() {
        MyLinkedList pushTest = new MyLinkedList();
        pushTest.push(new Human("Manuel", 18));
        Assertions.assertEquals("Manuel", pushTest.getRoot().getName());
    }

    @Test
    void testContains() {
        Assertions.assertEquals(true, testList.contains(new Human("Tim", 45)));
        Assertions.assertEquals(false, testList.contains(new Human("Tim", 44)));
    }

    @Test
    void testGetItemAtPosition() {
        Assertions.assertEquals("Martha", ((Human) testList.getItemAtPosition(1)).getName());
        Assertions.assertEquals(null, testList.getItemAtPosition(5));
    }

    @Test
    void testLength() {
        Assertions.assertEquals(4, testList.length());
    }

    @Test
    void testPrintList() {
        System.out.println("=== Printing Test ===");
        testList.printList();
        System.out.println("=== Four humans have to be described above to pass. ===");
    }

    @Test
    void testPop() {
        Human h = new Human("Dave", 19);
        Assertions.assertEquals(h, testList.pop());
    }

    @Test
    void testSearchItemPosition() {
        Human h = new Human("Adalbert", 65);
        Assertions.assertEquals(3, testList.searchItemPosition(h));
    }
    
    @Test
    void testConcatenate(){
        MyLinkedList toConcat = new MyLinkedList();
        toConcat.push(new Human("Morris", 15));
        toConcat.push(new Human("Jonathan", 25));
        testList = (MyLinkedList) testList.concatenate(toConcat);
        Assertions.assertEquals(6, testList.length());
        Assertions.assertEquals("Jonathan", testList.findEnd().getName());
    }
}
