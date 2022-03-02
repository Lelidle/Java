package List.LinkedList.English;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListLinkedTest {

    private MyListLinked testList;

    public MyListLinkedTest(){
        testList = new MyListLinked();
        testList.append(new Human("Dave",19));
        testList.append(new Human("Martha", 51));
        testList.append(new Human("Tim", 45));
        testList.append(new Human("Adalbert", 65));
    }

    @Test
    void testAppend() {
        MyListLinked appendTest = new MyListLinked();
        appendTest.append(new Human("Manuel", 18));
        Assertions.assertEquals("Manuel", appendTest.getRoot().getName());
    }

    @Test
    void testContains() {
        Assertions.assertEquals(true, testList.contains(new Human("Tim", 45)));
        Assertions.assertEquals(false, testList.contains(new Human("Tim", 44)));
    }

    @Test
    void testGetItemAtPosition() {
        Assertions.assertEquals(new Human("Martha", 51), testList.getItemAtPosition(2));
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
        MyListLinked toConcat = new MyListLinked();
        toConcat.append(new Human("Morris", 15));
        toConcat.append(new Human("Jonathan", 25));
        testList = (MyListLinked) testList.concatenate(toConcat);
        Assertions.assertEquals(6, testList.length());
        Assertions.assertEquals("Jonathan", testList.findEnd().getName());
    }
}
