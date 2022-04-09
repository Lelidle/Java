package List.Compositum.English;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListCompTest {

    MyListComp testList;

    public MyListCompTest(){
        testList = new MyListComp();
        testList.push(new Human("Albus", 18));
        testList.push(new Human("Berti", 62));
        testList.push(new Human("Christa", 55));
        testList.push(new Human("Dora", 7));
        testList.push(new Human("Ethel", 15));
    }

    @Test
    void testPush() {
        MyListComp pushTest = new MyListComp();
        pushTest.push(new Human("Alex", 25));
        pushTest.push(new Human("Albi", 27));
        Human firstHuman = (Human) pushTest.getRoot().getData();
        Human secondHuman = (Human) pushTest.getRoot().getNext().getData();
        Assertions.assertEquals("Albi", firstHuman.getName());
        Assertions.assertEquals("Alex", secondHuman.getName());
    }


    @Test
    void testAppendSorted() {
       MyListComp appendTest = new MyListComp();
       appendTest.appendSorted(new Human("Albi", 27));
       appendTest.appendSorted(new Human("Alex", 15));
       appendTest.appendSorted(new Human("Alex", 25));
       appendTest.appendSorted(new Human("Boris", 18));
       Assertions.assertEquals("Alex", ((Human) appendTest.pop()).getName());
       appendTest.pop();
       appendTest.pop();
       Assertions.assertEquals("Albi", ((Human) appendTest.pop()).getName());
    }

    @Test
    void testLength() {
        Assertions.assertEquals(5, testList.length());
    }

    @Test
    void testConcatenate() {
        MyListComp toConcat = new MyListComp();
        toConcat.push(new Human("Alex", 15));
        toConcat.push(new Human("Boris", 18));
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
        Assertions.assertEquals("Ethel", ((Human) testList.removeAt(1)).getName());
        Assertions.assertEquals("Berti", ((Human) testList.removeAt(3)).getName());
        Assertions.assertEquals(3, testList.length());
    }

    @Test
    void testSearchItemPosition() {
        Assertions.assertEquals(1, testList.searchItemPosition(new Human("Dora", 7)));
        Assertions.assertEquals(0, testList.searchItemPosition(new Human("Ethel", 15)));
    }

    @Test
    void testMap(){
        testList.map((Human h) -> {h.setAge(h.getAge() + 1); return h;});
        Assertions.assertEquals(16, ((Human) testList.pop()).getAge());
    }

    @Test 
    void testFindEnd(){
        Assertions.assertEquals("Albus", ((Human) testList.findEnd().getData()).getName());
    }
}
