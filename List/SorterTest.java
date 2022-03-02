package List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import List.Array.English.Human;
import List.Array.English.MyListArray;
import List.Compositum.English.MyListComp;

public class SorterTest {

    MyListArray testListArr;
    MyListComp testListComp;
    Sorter sorter = new Sorter();

    public SorterTest(){
        testListArr = new MyListArray(6);
        testListArr.append(new Human("Argos", 25));
        testListArr.append(new Human("Bailey", 45));
        testListArr.append(new Human("Cherry", 7));
        testListArr.append(new Human("Daisy", 33));

        testListComp = new MyListComp();
        testListComp.append(new List.Compositum.English.Human("Argos", 25));
        testListComp.append(new List.Compositum.English.Human("Bailey", 45));
        testListComp.append(new List.Compositum.English.Human("Cherry", 7));
        testListComp.append(new List.Compositum.English.Human("Daisy", 33));
    }

    @Test
    void testBubbleSortArr() {
        sorter.bubbleSortArr(testListArr);
        testListArr.printList();
        Assertions.assertEquals("Cherry", (testListArr.pop()).getName());
        testListArr.pop();
        testListArr.pop();
        Assertions.assertEquals("Bailey", testListArr.pop().getName());
    }

    @Test
    void testInsertionSortArr() {
        sorter.insertionSortArr(testListArr);
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
