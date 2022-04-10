package List;

import List.Array.English.Human;
import List.Array.English.MyListArray;

/**
 * All Methods are public for testing purposes, should be private, 
 * used with the sort function
 */

public class Sorter {
    
    /**
     * Calls the Sorting method to sort the given list
     * @param toSort the list to sort
     * @param method the method that shall be used
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

    /**
     * Sorts the given List with bubble Sort
     * @param toSort the List to sort
     */
    public void bubbleSort(MyListArray toSort) {
        //reducing the problem to the sorting of a standard array
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        //optional, if no swap is made the loop can stop, enhances performance a bit
        boolean swapped = false;
        /*Compares each element to the next one in the list and swaps if it is greater
        than the next one. The isGreater method is necessary as it is not a primitive type*/
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++) {
                if(queue[j].isGreater(queue[j+1])){
                    swapped = true; 
                    Human tmp = queue[j];
                    queue[j] = queue[j+1];
                    queue[j+1] = tmp;
                }
            }
            //stops if no changes have been made in this loop => list is sorted
            if(!swapped) break;
        }
    }

    /**
     * Sorts the given List with Insertion Sort
     * @param toSort the List to sort
     */
    public void insertionSort(MyListArray toSort) {
        //reducing the problem to the sorting of a standard array
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        /*Divides the array in a sorted and unsorted part. It iterates over the
        unsorted part and puts the next element into the right spot in the
        sorted part thus enhancing it by one.
        */
        for(int i = 1; i < n; i++){
            //The reference to the element that shall be placed next
            Human tmp = queue[i];
            int j = i - 1; //Defines the part of the array that is sorted
            // Moves every element that is greater up one spot until it finds the right spot for the new element.
            //isGreater is necessary as it is not a primitive type.
            while(j >= 0 && queue[j].isGreater(tmp)){
                queue[j+1] = queue[j];
                j--;
            }
            //puts the new element at the found spot
            queue[j+1] = tmp;
        }
    }

    /**
     * Sorts the given List with Selection Sort
     * @param toSort the List to sort
     */
    public void selectionSort(MyListArray toSort) {
        //reducing the problem to the sorting of a standard array
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        /*In each cycle the smallest element is found and swapped to the front, forming an
        already sorted part of the array that grows by one each cycle.
        isGreater is necessary as it is not a primitive type.
        */
        for(int i = 0; i < n -1; i++){
            // the index of the smallest element
            int index = i;
            //finds the current smalles element
            for(int j = i + 1; j < n; j++) {
                if(queue[index].isGreater(queue[j])) {
                    index = j;
                }
            }
            //swaps it to the appropriate position in the sorted part
            Human tmp = queue[index];
            queue[index] = queue[i];
            queue[i] = tmp;
        }
    }

    /**
     * Sorts the given List with Merge Sort - main method
     * @param toSort the List to sort
     */
    public void mergeSort(MyListArray toSort, int left, int right){
        /*As long as the array can be split reasonably, it is cut in the middle
        and both halves are sorted recursively. After both are merged.
        */
        if(left < right) {
            int middle = left + (right-left)/2;
            mergeSort(toSort, left, middle);
            mergeSort(toSort, middle + 1, right);
            merge(toSort, left, middle, right);
        }
    }

    /**
     * The merge method of the MergeSort, it arranges the elements according to the 
     * found sorting. Helper method.
     * @param toSort the list to sort
     * @param left the index of the left border of the given subarray
     * @param middle the index of the middle element of the given subarray
     * @param right the index of the right border of the given subarray
     */
    public void merge(MyListArray toSort, int left, int middle, int right){
        //calculates the sizes of the subarrays
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;
        //reducing the problem to the sorting of a standard array
        Human[] queue = toSort.getQueue();
        //Defining temporary arrays to store the ordered values
        Human[] Left = new Human[sizeLeft];
        Human[] Right = new Human[sizeRight];
        //Copying of the data into the temporary arrays:
        for(int i = 0; i < sizeLeft; i++) {
            Left[i] = queue[left + i];
        }
        for(int j = 0; j < sizeRight; j++) {
            Right[j] = queue[middle + 1 + j];
        }
        //starting indices of the subarrays and the new merged array
        int i=0,j=0, k=left;
        //Works on both sides and puts the smaller values into the accurate position in the actual list
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
        //If the left temporary array has still elements they are store at the end
        while(i < sizeLeft) {
            queue[k] = Left[i];
            i++;
            k++;
        } 
        //If the right temporary array has still elements they are store at the end
        while(j < sizeRight){
            queue[k] = Right[j];
            j++;
            k++;
        }
    }

    /**
     * Sorts the given List with Quick Sort - main method
     * @param toSort the list to sort
     * @param low the index of the left border of the given subarray
     * @param high the index of the right border of the given subarray
     */
    public void quickSort(MyListArray toSort, int low, int high) {
        //Stopping condition for the recursion
        if(low < high) {
            //Via partition the array is sorted into a correct positioned pivot and
            //two unsorted subarrays on which quickSort is called again
            int pivot = partition(toSort, low, high);
            quickSort(toSort, low, pivot - 1);
            quickSort(toSort, pivot + 1, high);
        }
    }

    /**
     * Helper method for the quickSort that puts the pivot in the right position and 
     * all elements smaller than the pivot left, and those greater than the pivot right
     * of it in the array.
     * @param toSort the array to sort
     * @param low the index of the left border of the given subarray
     * @param high the index of the right border of the given subarray
     * @return the index of the correctly positioned pivot element
     */
    public int partition(MyListArray toSort, int low, int high) {
        //reducing the problem to the sorting of a standard array
        Human[] queue = toSort.getQueue();
        //The rightmost element is set as pivot, other implementations possible!
        Human piv = queue[high];
        //the starting point for the comparisons to part the array around the pivot
        int i = low - 1;
        // If the pivot is greater than the current position j, they are swapped
        for(int j = low; j < high; j++) {
            if(piv.isGreater(queue[j])) {
                i++;
                Human tmp = queue[i];
                queue[i] = queue[j];
                queue[j] = tmp;
            }
        }
        //swapping the pivot to the correct position
        Human temp = queue[i + 1];
        queue[i + 1] = queue[high];
        queue[high] = temp;
        //returning the pivot index
        return i + 1;
    }

    /**
     * Sorts the given List with Heap Sort - main method
     * @param toSort the list to sort
     */
     public void heapSort(MyListArray toSort) {
        //reducing the problem to the sorting of a standard array
        int n = toSort.length();
        Human[] queue = toSort.getQueue();
        //Building a heap out of the given array
        for(int i = n/2-1; i >=0; i--){
            heapify(queue, n, i);
        }
        //Removing the root of the heap and replacing it with the last element, 
        //restoring the heap structure afterwards
        for(int i = n-1; i >=0;i--){
            Human tmp = queue[0];
            queue[0] = queue[i];
            queue[i] = tmp;
            heapify(queue, i, 0);
        } 
    }

    /**
     * Helper method for the heap sort, restoring the heap property
     * @param queue the array to heapify
     * @param n the length of the array
     * @param i the index to start
     */
    public void heapify(Human[] queue, int n, int i){
        //Initializing indizes for the root, the first left child and the first right child
        int root = i, left = 2*i+1, right = 2*i + 2;
        //If the left child is greater the new root is the left child
        if(left < n && queue[left].isGreater(queue[root])) {
            root = left;
        }
        //If the right child is greater the new root is the right child
        if(right < n && queue[right].isGreater(queue[root])){
            root = right;
        }
        //If the root has changed the new root has to be swapped there and the 
        //method has to be called again with the new root
        if(root != i){
            Human tmp = queue[i];
            queue[i] = queue[root];
            queue[root] = tmp;
            heapify(queue, n, root);
        }
        
    } 
}
