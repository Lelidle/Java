package Graph;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Converter {


    public static void main(String[] args) {
        /*
        Defining a new Graph. The implementation needs to work with an
        adjacency matrix of type int[][], double[][] or boolean[][]
        */
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 3);
        g.printMatrix();
        convert(g.getMatrix(), "test");
    }
    /*
    public static void convert(int[][] matrix, String filename) {
        if(matrix.length != matrix[0].length) {
            System.err.println("It has to be a square matrix");
            return;
        }
        int n = matrix.length;
        double[][] tmp = new double[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = (double) matrix[i][j];
            }
        }
        convert(matrix, filename);
    }
    */
    public static void convert(double[][] matrix, String filename) {
        String result = "digraph G { \n\n";
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != 0) {
                    result += "    " + i + " -> " + j + "\n";
                }
            }
        }
        result += "}";
        String workingDir = System.getProperty("user.dir");
        Path filePath = Paths.get(workingDir+File.separator+"\\Graph\\Dot\\" + filename + ".dot");
        System.out.println(filePath);
        File file = new File(filePath.toString());

        try(FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = result.getBytes();
            bos.write(bytes);
            bos.close();
            fos.close();
            System.out.print("Save successfull.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    } 
}
