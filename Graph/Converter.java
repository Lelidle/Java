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
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2,7);
        g.addEdge(1, 3, 5.2);
        g.addEdge(1, 4, 7.3);
        g.addEdge(2, 3, 10);
        g.addEdge(2, 4, 14);
        g.addEdge(3, 4, 9);
        g.addEdge(4, 0, 11);
        g.addEdge(4, 3, 0.5);
        g.printMatrix();
        int[][] test = new int[5][5];
        test[0][3] = 1;
        test[1][4] = 1;
        test[3][4] = 1;
        convertToDot(g.getMatrix(), "test2", Mode.NONE);
    }
    
    public static void convert(boolean[][] matrix, String filename, Mode mode) {
        if(matrix.length != matrix[0].length) {
            System.err.println("The given matrix has to be square!");
            return;
        }
        int n = matrix.length;
        double[][] tmp = new double[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j]) tmp[i][j] = 1;
            }
        }
        convertToDot(tmp, filename, mode);
    }

    public static void convertToDot(int[][] matrix, String filename, Mode mode) {
        if(matrix.length != matrix[0].length) {
            System.err.println("The given matrix has to be square!");
            return;
        }
        int n = matrix.length;
        double[][] tmp = new double[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = (double) matrix[i][j];
            }
        }
        convertToDot(tmp, filename, mode);
    }
    
    public static void convertToDot(double[][] matrix, String filename, Mode mode) {
        String result = constructString(matrix, mode);
        String workingDir = System.getProperty("user.dir");
        Path directoryPath = Paths.get(workingDir+File.separator+"Graph\\Dot");

        File directory = new File(directoryPath.toString());
        if (! directory.exists()){
            directory.mkdir();
        }

        /*
        * Dot directory path has to be modified depending on the used working directory. If it is called in the same folder
        * the Graph\\ has to be removed.
        */
        Path filePath = Paths.get(workingDir+File.separator+"Graph\\Dot"+File.separator + filename + ".dot");
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

    private static String constructString(double[][] matrix, Mode mode) {
        String result;
        if(mode == Mode.WEIGHED || mode == Mode.NONE) {
            result = "graph { \n\n";
        } else {
            result = "digraph { \n\n";
        }
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != 0) {
                    if(mode == Mode.DIRECTED || mode == Mode.DIRECTEDWEIGHED) {
                        result += "    " + i + " -> " + j;
                        if(mode == Mode.DIRECTEDWEIGHED) {
                            result += " [label= " + matrix[i][j] + "]";
                        }
                    } else {
                        result += "    " + i + " -- " + j;
                        if(mode == Mode.WEIGHED) {
                            result += " [label= " + matrix[i][j] + "]";
                        }
                    }
                    result += "\n";
                    }
                }
            }
        return result += "\n}";
    }
}
