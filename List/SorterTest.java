package List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import List.Array.Human;
import List.Array.MyListArray;


public class SorterTest {

    MyListArray testListArr;
    Sorter sorter = new Sorter();

    public SorterTest(){
        testListArr = new MyListArray(6);
        testListArr.push(new Human("Argos", 25));
        testListArr.push(new Human("Bailey", 45));
        testListArr.push(new Human("Cherry", 7));
        testListArr.push(new Human("Daisy", 33));
    }

    @Test
    void testBubbleSortArr() {
        sorter.bubbleSort(testListArr);
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    }

    @Test
    void testInsertionSortArr() {
        sorter.insertionSort(testListArr);
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    }

    @Test
    void testSelectionSortArr(){
        sorter.selectionSort(testListArr);
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    }

    @Test
    void testMergeSort(){
        sorter.mergeSort(testListArr, 0, testListArr.length()-1);
        testListArr.printList();
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    }

    @Test
    void testQuickSort(){
        sorter.quickSort(testListArr, 0, testListArr.length()-1);
        testListArr.printList();
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    }

    @Test
    void testHeapSort(){
        sorter.heapSort(testListArr);
        testListArr.printList();
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    } 


    @Test
    void testSort(){
        sorter.sort(testListArr, SortingMethod.BUBBLE);
        testListArr.printList();
    }
}
