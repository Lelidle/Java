package List;

import List.Array.English.Human;
import List.Array.English.MyListArray;
import List.Compositum.English.MyListComp;

/**
 * All Methods are public for testing purposes, should be private, 
 * used with the sort function
 */

public class Sorter {
    
    /**
     * 
     * @param toSort
     * @param method
     */
    public void sort(ListInterface toSort, SortingMethod method) {
        if(toSort instanceof MyListArray) {
            MyListArray switching = (MyListArray) toSort;
            switch(method){
                case BUBBLE:
                bubbleSortArr(switching);
                break;
                case INSERTION:
                insertionSortArr(switching);
                break;
                case SELECTION:
                // TODO implement SELECTIOn Sort
                break;
                case MERGE:
                // TODO Implement Merge Sort
                break;
                case QUICK:
                // TODO implement Quick Sort
                break;
                case RADIX:
                // TODO implement Radix Sort
                break;
                case HEAP:
                break;
                case BUCKET:
                break;
                default:
                System.out.println("A wrong method has been given, bubbleSort was used");
                bubbleSortArr((MyListArray) toSort);
                break;
            }
        } else if(toSort instanceof MyListComp){
            MyListComp switching = (MyListComp) toSort;
            switch(method){
                case BUBBLE:
                bubbleSortComp(switching);
                break;
                case INSERTION:
                insertionSortComp(switching);
                break;
                case SELECTION:
                // TODO implement SELECTIOn Sort
                break;
                case MERGE:
                // TODO Implement Merge Sort
                break;
                case QUICK:
                // TODO implement Quick Sort
                break;
                case RADIX:
                // TODO implement Radix Sort
                break;
                case HEAP:
                break;
                case BUCKET:
                break;
                default:
                System.out.println("A wrong method has been given, bubbleSort was used");
                bubbleSortArr((MyListArray) toSort);
                break;
            }
        } else {
            System.out.println("A list of a not supported type was given");
        }
    }

    public void bubbleSortArr(MyListArray toSort) {
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        boolean swapped = false; //optional, if no swap is made the loop can stop
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++) {
                if(queue[j].isGreater(queue[j+1])){
                    swapped = true; 
                    Human tmp = queue[j];
                    queue[j] = queue[j+1];
                    queue[j+1] = tmp;
                }
            }
            if(!swapped) break;
        }
        toSort.setQueue(queue);
    }

    public void bubbleSortComp(MyListComp toSort){
        int n = toSort.length();
        boolean swapped = false;
        for(int i = 0; i < n; i++) {
           
        }
    }

    public void insertionSortArr(MyListArray toSort) {
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        for(int i = 1; i < n; i++){
            Human tmp = queue[i];
            int j = i - 1; //Defines the part of the array that is sorted
            while(j >= 0 && queue[j].isGreater(tmp)){
                queue[j+1] = queue[j];
                j--;
            }
            queue[j+1] = tmp;
        }
        toSort.setQueue(queue);
    }

    public void insertionSortComp(MyListComp toSort) {

    }
}
