package List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import List.Array.Human;
import List.Array.MyArrayList;
import List.Compositum.MyCompositum;

public class RunTimeAnalysis {
    
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // The test you want to do:
        appendTest();
        long finishTime = System.nanoTime();
        System.out.println();
        System.out.println("The whole test took: " + (finishTime-startTime)*Math.pow(10,-9) + " seconds");
    }
    
    public static void appendTest(){
        String path = "C:/Users/lehrer/OneDrive - FWU EU CLOUD/Code Schule/Java 11/List/bigTest.csv";
        MyArrayList arrTest = new MyArrayList(10);
        MyCompositum compTest = new MyCompositum();
        System.out.println("======== Test 1 - ArrayList ========");
        long startTime = System.nanoTime();
        try {
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);
            try {
                while(reader.ready()){
                    String[] infos = reader.readLine().split(",");
                    arrTest.push(new Human(infos[0], Integer.parseInt(infos[1])));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Append Test unsorted took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println();

        MyArrayList arrTestTwo = new MyArrayList(10);
        startTime = System.nanoTime();
        try {
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);
            try {
                for(int i = 0; i < 10000; i++){
                    String[] infos = reader.readLine().split(",");
                    arrTestTwo.appendSorted(new Human(infos[0], Integer.parseInt(infos[1])));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        System.out.println("Append Test sorted took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println(); 

        startTime = System.nanoTime();
        arrTest.concatenate(arrTestTwo);
        endTime = System.nanoTime();
        System.out.println("Concatenating the two lists took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println(); 

        startTime = System.nanoTime();
        arrTest.getItemAtPosition(45000);
        endTime = System.nanoTime();
        System.out.println("Finding the 45000-th element took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println();

        startTime = System.nanoTime();
        arrTest.searchItemPosition(new Human("Tim", 14));
        endTime = System.nanoTime();
        System.out.println("Finding the human Solomon age 51 took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println();

        System.out.println("======== Test 2 - Compositum ========");
        startTime = System.nanoTime();
        try {
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);
            try {
                while(reader.ready()){
                    String[] infos = reader.readLine().split(",");
                    compTest.push(new List.Compositum.Human(infos[0], Integer.parseInt(infos[1])));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        System.out.println("Append Test unsorted took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println();

        MyCompositum compTestTwo = new MyCompositum();
        startTime = System.nanoTime();
        try {
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);
            try {
                for(int i = 0; i < 10000; i++){
                    String[] infos = reader.readLine().split(",");
                    compTestTwo.appendSorted(new List.Compositum.Human(infos[0], Integer.parseInt(infos[1])));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        System.out.println("Append Test sorted took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println();
        
        startTime = System.nanoTime();
        compTestTwo.concatenate(compTest);
        endTime = System.nanoTime();
        System.out.println("Concatenating the two lists took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        System.out.println();

        System.out.println("The searching in the linked List blows up due to too high recursion stacks :(");
        //startTime = System.nanoTime();
        //compTest.getItemAtPosition(45000);
        //endTime = System.nanoTime();
        //System.out.println("Finding the 45000-th element took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        //System.out.println();

        //startTime = System.nanoTime();
        //compTest.searchItemPosition(new List.Compositum.English.Human("Solomon", 51));
        //endTime = System.nanoTime();
        //System.out.println("Finding the human Solomon age 51 took " + (endTime - startTime)*Math.pow(10, -9) + " seconds");
        //System.out.println();
    }
}
