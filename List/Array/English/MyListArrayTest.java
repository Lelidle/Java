package List.Array.English;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListArrayTest {

    MyListArray testList;

    public MyListArrayTest(){
        testList = new MyListArray(5);
        testList.push(new Human("Mike", 15));
        testList.push(new Human("Sarah", 27));
        testList.push(new Human("Manuel", 18));
        testList.push(new Human("Sina", 25));
    }

    @Test
    void testPush() {
        MyListArray pushTest = new MyListArray(2);
        pushTest.push(new Human("Mike", 15));
        pushTest.push(new Human("Sarah", 27));
        Assertions.assertEquals("Mike", pushTest.getQueue()[0].getName());
        Assertions.assertEquals("Sarah", pushTest.getQueue()[1].getName());
        System.out.println("The queue should be full:");
        pushTest.push(new Human("Balu", 43));
    }

    @Test
    void testAppendWhenFull(){
        testList.push(new Human("Balu", 43));
        testList.appendWhenFull(new Human("Tinker", 24));
        Assertions.assertEquals(6, testList.length());
    }

    @Test
    void testPop() {
        Human h = testList.pop();
        Assertions.assertEquals("Mike", h.getName());
        Assertions.assertEquals("Sarah",testList.getQueue()[0].getName());
    }

    @Test
    void testPrintList() {
        System.out.println("===This is a printtest===");
        testList.printList();
        System.out.println("=== Passed if there are four humans described above ===");
    }

    @Test
    void testGetItemAtPosition() {
        Human h = testList.getQueue()[2];
        Assertions.assertEquals(null, testList.getItemAtPosition(5));
        Assertions.assertEquals(h, testList.getItemAtPosition(3));
    }

    @Test
    void testSearchItemPosition() {
        Human h = new Human("Sarah", 27);
        Assertions.assertEquals(1, testList.searchItemPosition(h));
    }

    @Test
    void testContains() {
        Assertions.assertEquals(true, testList.contains(new Human("Sarah",27)));
        Assertions.assertEquals(false, testList.contains(new Human("Blade", 104)));
    }

    @Test
    void testLength() {
        Assertions.assertEquals(4, testList.length());
    }

    @Test
    void testRemoveAt(){
        Human h = testList.removeAt(2);
        Assertions.assertEquals("Sarah", h.getName());
        Assertions.assertEquals(null, testList.getItemAtPosition(4));
    }

    @Test 
    void testConcatenate(){
        MyListArray toConcat = new MyListArray(2);
        toConcat.push(new Human("Alice", 18));
        toConcat.push(new Human("Bob", 25));
        testList = (MyListArray) testList.concatenate(toConcat);
        Assertions.assertEquals(6, testList.length());
    }

    @Test
    void testAppendSorted(){
        MyListArray sortedTest = new MyListArray(1);
        sortedTest.appendSorted(new Human("Alice", 25));
        sortedTest.printList();
        System.out.println();
        sortedTest.appendSorted(new Human("Bob", 34));
        sortedTest.printList();
        System.out.println();
        sortedTest.appendSorted(new Human("Fred", 18));
        sortedTest.printList();
        Assertions.assertEquals("Fred", sortedTest.pop().getName());
        sortedTest.pop();
        Assertions.assertEquals("Bob", sortedTest.pop().getName());
    }
}