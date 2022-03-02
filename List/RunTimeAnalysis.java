package List;

public class RunTimeAnalysis {
    
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // The test you want to do:
        appendTest();
        long finishTime = System.nanoTime();
        System.out.println("The test took: " + (finishTime-startTime) + " nanoseconds");
    }

    public static void appendTest(){
        
    }

}
