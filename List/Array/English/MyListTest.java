package List.Array.English;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListTest {

    MyList testList;

    public MyListTest(){
        testList = new MyList(5);
        testList.append(new Human("Mike", 15));
        testList.append(new Human("Sarah", 27));
        testList.append(new Human("Manuel", 18));
        testList.append(new Human("Sina", 25));
    }

    @Test
    void testAppend() {
        MyList appendTest = new MyList(2);
        appendTest.append(new Human("Mike", 15));
        appendTest.append(new Human("Sarah", 27));
        Assertions.assertEquals("Mike", testList.getQueue()[0].getName());
        Assertions.assertEquals("Sarah", testList.getQueue()[1].getName());
        System.out.println("The queue should be full:");
        appendTest.append(new Human("Balu", 43));
    }

    @Test
    void testAppendWhenFull(){
        testList.append(new Human("Balu", 43));
        testList.appendWhenFull(new Human("Tinker", 24));
        Assertions.assertEquals(6, testList.getQueue().length);
    }

    @Test
    void testRemove() {
        testList.remove();
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
        Assertions.assertEquals(null, testList.getItemAtPosition(4));
        Assertions.assertEquals(h, testList.getItemAtPosition(2));
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


}