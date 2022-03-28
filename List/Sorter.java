package List;

import List.Array.English.Human;
import List.Array.English.MyListArray;

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
    public void sort(MyListArray toSort, SortingMethod method) {
        if(toSort instanceof MyListArray) {
            switch(method){
                case BUBBLE:
                bubbleSort(toSort);
                break;
                case INSERTION:
                insertionSort(toSort);
                break;
                case SELECTION:
                selectionSort(toSort);
                break;
                case MERGE:
                mergeSort(toSort, 0, toSort.length() - 1);
                break;
                case QUICK:
                quickSort(toSort,0, toSort.length() - 1);
                break;
                case HEAP:
                heapSort(toSort);
                break;
                default:
                System.out.println("An unknown method has been given, bubbleSort was used");
                bubbleSort((MyListArray) toSort);
                break;
            }
        } else {
            System.out.println("A list of a not supported type was given");
        }
    }

    public void bubbleSort(MyListArray toSort) {
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

    public void insertionSort(MyListArray toSort) {
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

    public void selectionSort(MyListArray toSort) {
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        for(int i = 0; i < n -1; i++){
            int index = i;
            for(int j = i + 1; j < n; j++) {
                if(queue[index].isGreater(queue[j])) {
                    index = j;
                }
            }
            Human tmp = queue[index];
            queue[index] = queue[i];
            queue[i] = tmp;
        }
        toSort.setQueue(queue);
    }

    public void mergeSort(MyListArray toSort, int left, int right){
        if(left < right) {
            int middle = left + (right-left)/2;
            mergeSort(toSort, left, middle);
            mergeSort(toSort, middle + 1, right);
            merge(toSort, left, middle, right);
        }
    }

    public void merge(MyListArray toSort, int left, int middle, int right){
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;
        Human[] queue = toSort.getQueue();
        Human[] Left = new Human[sizeLeft];
        Human[] Right = new Human[sizeRight];
        //Copying of the data into the temporary arrays:
        for(int i = 0; i < sizeLeft; i++) {
            Left[i] = queue[left + i];
        }
        for(int j = 0; j < sizeRight; j++) {
            Right[j] = queue[middle + 1 + j];
        }
        //starting indices of the partial arrays and the new merged array
        int i=0,j=0, k=left;
        while(i < sizeLeft && j < sizeRight) {
            if(Right[j].isGreater(Left[i])) {
                queue[k] = Left[i];
                i++;
            } else {
                queue[k] = Right[j];
                j++;
            }
            k++;
        }
        while(i < sizeLeft) {
            queue[k] = Left[i];
            i++;
            k++;
        } 
        while(j < sizeRight){
            queue[k] = Right[j];
            j++;
            k++;
        }
        toSort.setQueue(queue);
    }

    public void quickSort(MyListArray toSort, int low, int high) {
        if(low < high) {
            int pivot = partition(toSort, low, high);
            quickSort(toSort, low, pivot - 1);
            quickSort(toSort, pivot + 1, high);
        }
    }

    public int partition(MyListArray toSort, int low, int high) {
        Human[] queue = toSort.getQueue();
        Human piv = queue[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(piv.isGreater(queue[j])) {
                i++;
                Human tmp = queue[i];
                queue[i] = queue[j];
                queue[j] = tmp;
            }
        }
        Human temp = queue[i + 1];
        queue[i + 1] = queue[high];
        queue[high] = temp;
        toSort.setQueue(queue); 
        return i + 1;
    }

    public void heapSort(MyListArray toSort) {
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        for(int i = n/2 -1; i >=0;i--){
            heapify(queue, n,i);
        }

        for(int i = n - 1; i >= 0; i--){
            Human tmp = queue[0];
            queue[0] = queue[i];
            queue[i] = tmp; 
            heapify(queue, i, 0);
        }
        toSort.setQueue(queue);
    }

    public void heapify(Human[] queue, int n, int i){
        int root = i, left = 2*i+1, right = 2*i + 2;
        System.out.println("Left: " + left + " Right: " + right);
        if(left < n && queue[left].isGreater(queue[root])) {
            root = left;
        }
        if(right < n && queue[right].isGreater(queue[root])){
            root = right;
        }
        if(root != i){
            Human tmp = queue[i];
            queue[i] = queue[root];
            queue[root] = tmp;
        }
        heapify(queue, n, root);
    }
}
