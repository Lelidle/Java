package List.Compositum.English;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListCompTest {

    MyListComp testList;

    public MyListCompTest(){
        testList = new MyListComp();
        testList.append(new Human("Albus", 18));
        testList.append(new Human("Berti", 62));
        testList.append(new Human("Christa", 55));
        testList.append(new Human("Dora", 7));
        testList.append(new Human("Ethel", 15));
    }

    @Test
    void testAppend() {
        MyListComp appendTest = new MyListComp();
        appendTest.append(new Human("Alex", 25));
        appendTest.append(new Human("Albi", 27));
        Human firstHuman = (Human) appendTest.getRoot().getData();
        Human secondHuman = (Human) appendTest.getRoot().getNext().getData();
        Assertions.assertEquals("Albi", firstHuman.getName());
        Assertions.assertEquals("Alex", secondHuman.getName());
    }

    @Test
    void testAppendBack() {
        MyListComp appendTest = new MyListComp();
        appendTest.appendBack(new Human("Alex", 15));
        appendTest.appendBack(new Human("Boris", 18));
        System.out.println(appendTest.getRoot().getNext().getData());
        Human firstHuman = (Human) appendTest.getRoot().getData();
        Human secondHuman = (Human) appendTest.getRoot().getNext().getData();
        Assertions.assertEquals("Alex", firstHuman.getName());
        Assertions.assertEquals("Boris", secondHuman.getName());
    }

    @Test
    void testAppendSorted() {
        // TODO Test has to be implemented
    }

    @Test
    void testLength() {
        Assertions.assertEquals(5, testList.length());
    }

    @Test
    void testConcatenate() {
        MyListComp toConcat = new MyListComp();
        toConcat.appendBack(new Human("Alex", 15));
        toConcat.appendBack(new Human("Boris", 18));
        testList.concatenate(toConcat);
        Assertions.assertEquals(7, testList.length());
    }

    @Test
    void testContains() {
        Assertions.assertEquals(true, testList.contains(new Human("Albus", 18)));
        Assertions.assertEquals(false, testList.contains(new Human("Ambros", 25)));
    }

    @Test
    void testGetItemAtPosition() {
        Assertions.assertEquals("Christa", ((Human) testList.getItemAtPosition(3)).getName());
        Assertions.assertEquals(null, testList.getItemAtPosition(17));
        Assertions.assertEquals(5, testList.length());
    }


    @Test
    void testPop() {
        Assertions.assertEquals("Ethel", ((Human)testList.pop()).getName());
        Assertions.assertEquals("Dora", ((Human)testList.pop()).getName());
        Assertions.assertEquals(3, testList.length());
    }

    @Test
    void testPrintList() {
        System.out.println("=== Printing Test ===");
        testList.printList();
        System.out.println("5 Humans have to be described above for the test to be valid");
    }

    @Test
    void testRemoveAt() {
        Assertions.assertEquals("Christa", ((Human) testList.removeAt(3)).getName());
        Assertions.assertEquals(4, testList.length());
    }

    @Test
    void testSearchItemPosition() {
        Assertions.assertEquals(1, testList.searchItemPosition(new Human("Dora", 7)));
        Assertions.assertEquals(0, testList.searchItemPosition(new Human("Ethel", 15)));
    }
}
