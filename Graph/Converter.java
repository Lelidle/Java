package Graph;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Converter {


    public static void main(String[] args) {
        /*
        Defining a new Graph. The implementation needs to work with an
        adjacency matrix of type int[][], double[][] or boolean[][]
        Test case:
        */
        /*
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
        convertToDot(g.getMatrix(), "test2", Mode.DIRECTEDWEIGHED);
        */
        /*
         * Other direction: Rudimentary parsing of a dot file to get an adjacency matrix for Java
         * Test Case
         */
        double[][] test = convertToMatrix("C:\\Users\\lehrer\\OneDrive - FWU EU CLOUD\\Emacs\\code\\School\\Java 11\\Graph\\Dot\\test3.dot");
        System.out.println();
        printArray(test);
    }
    
    /**
     * Overloaded helper method, takes a boolean adjacency matrix and converts it into a
     * double array to start the conversion
     * @param matrix the adjacency to be converted into a dotfile
     * @param filename the name of the file to which shall be saved
     * @param mode determines wether it will be an (un)directed or (un)weighed Graph. See Enum Mode.
     */
    public static void convertToDot(boolean[][] matrix, String filename, Mode mode) {
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

    /**
     * Overloaded helper method, takes an integer adjacency matrix and converts it into a
     * double array to start the conversion
     * @param matrix the adjacency to be converted into a dotfile
     * @param filename the name of the file to which shall be saved
     * @param mode determines wether it will be an (un)directed or (un)weighed Graph. See Enum Mode.
     */
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
    
    /**
     * Converts a given adjacency matrix into a corresponding dot file. Supports directed and weighed
     * graphs but does not give the option to style the dot graph.
     * @param matrix the adjacency to be converted into a dotfile
     * @param filename the name of the file to which shall be saved
     * @param mode determines wether it will be an (un)directed or (un)weighed Graph. See Enum Mode.
     */
    public static void convertToDot(double[][] matrix, String filename, Mode mode) {
        //Building the dot file in a single String;
        String result = constructString(matrix, mode);
        String workingDir = System.getProperty("user.dir");
        /*
        * Dot directory path has to be modified depending on the used working directory. If it is called in the same folder
        * the Graph\\ has to be removed.
        */
        Path directoryPath = Paths.get(workingDir+File.separator+"Graph\\Dot");
        //Creating the directory if it is not yet there
        File directory = new File(directoryPath.toString());
        if (! directory.exists()){
            directory.mkdir();
        }
        //Same as above.
        Path filePath = Paths.get(workingDir+File.separator+"Graph\\Dot"+File.separator + filename + ".dot");
        File file = new File(filePath.toString());
        //Writing to the new file via OutputStream
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

    /**
     * the actual method to build the String that represents the dotfile.
     * @param matrix the given adjacency matrix to convert.
     * @param mode specifies whether the graph shall be (un)weighed or (un)directed. See Enum Mode.
     * @return returns the String that respresents the dotfile.
     */
    private static String constructString(double[][] matrix, Mode mode) {
        String result;
        //If the graph is undirected the graph keyword is sufficient. Otherwise it needs to be digraph.
        if(mode == Mode.WEIGHED || mode == Mode.NONE) {
            result = "graph { \n\n";
        } else {
            result = "digraph { \n\n";
        }
        int n = matrix.length;
        
        // There has to be a prettier way..
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                double element = matrix[i][j];
                if(element != 0) {
                    if(mode == Mode.DIRECTED || mode == Mode.DIRECTED_WEIGHED) {
                        result += "    " + i + " -> " + j;
                        if(mode == Mode.DIRECTED_WEIGHED) {
                            if(element % 1 == 0) {
                                result += " [label= " + (int) element + "]";
                            } else {
                                result += " [label= " + element + "]";
                            }
                        }
                    } else {
                        result += "    " + i + " -- " + j;
                        if(mode == Mode.WEIGHED) {
                            if(element % 1 == 0) {
                                result += " [label= " + (int) element + "]";
                            } else {
                                result += " [label= " + element + "]";
                            }
                        }
                    }
                    result += "\n";
                    }
                }
            }
        return result += "\n}";
    }

    /**
     * Takes a given dot file and converts it to an adjacency matrix. Not yet robust, it 
     * needs a dot file in which the nodes are named after integers. Assumes the biggest
     * integer as maximum of nodes plus 1 (so there is a Node 0), even if other nodes are
     * not connected in between.
     * Currently assumes a dot file with edges of the form:
     * int --|-> int [label = double]
     * with the label being optional. 
     * TODO: Compatibility with edges of form String --|-> String and robust against not parsable labels
     * @param filepath the Path to the file that shall be converted as String.
     * @return Returns the converted adjacency Matrix or null, if something went wrong :)
     */
    public static double[][] convertToMatrix(String filepath){
        double[][] result = null;
        try {
            // directed and graph necessary to determine for which symbols we search or if it is a graph at all
            FileReader fr = new FileReader(new File(filepath));
            BufferedReader br = new BufferedReader(fr);
            String line;
            boolean directed = false;
            boolean graph = false;
            //Stripping contents to List first for easier handling
            LinkedList<String> fileContent = new LinkedList<String>();
            while((line=br.readLine()) != null) {
                fileContent.add(line);
            }
            
            //Searching for digraph or graph keyword in the file
            for(String l : fileContent) {
                Matcher mDigraph = Pattern.compile("digraph").matcher(l);
                Matcher mGraph = Pattern.compile("graph").matcher(l);
                if(mDigraph.find()) {
                    directed = true; 
                    graph = true;
                } else if(mGraph.find()) {
                    graph = true;
                }
            }

            // If none of the keywords have been found the process stops.
            if(!graph) return null;

            //Calls the aproppriate Helper Method dependand on the mode.
            if(directed) {
                result = buildDirectedMatrix(fileContent);
            } else {
                result = buildMatrix(fileContent);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Helper Method to parse the content of the dotfile and build an 
     * undirected graph adjacency matrix out of it.
     * @param fileContent Linked List of Strings that represent the lines of the dotfile.
     * @return returns the built adjacency matrix or null.
     */
    private static double[][] buildMatrix(LinkedList<String> fileContent) {
        /*
         * HashMap to store the positions and edge weights, cannot be stored
         * into the array directly as the input has to be parsed to know the amount
         * of nodes. The Set is necessary to calculate the amount of distinct nodes.
         */
        HashMap<Integer[], Double> edgeValues= new HashMap<Integer[],Double>();
        Set<Integer> sizeCalcSet = new LinkedHashSet<Integer>(); 
        //Parsing line by line
        for(String l : fileContent) {
            //All lines that have no "edge Arrow" in them will not be looked at.
            Matcher mArrow = Pattern.compile("--").matcher(l);
            //If there is a label present it is assumed, that the graph is weighed.
            Matcher mLabel = Pattern.compile("label").matcher(l);
            //If there is no label, the weight is assumed to be 1 ("there")
            double weight = 1;
            if(mArrow.find()) {
                if(mLabel.find()){
                    //Parsing the label information inside of [...]
                    String label = l.substring(l.indexOf("[") + 1, l.indexOf("]"));
                    //Parsing the double value out of the determined String
                    weight = Double.parseDouble(label.substring(label.indexOf("=") + 1,label.length()).trim());
                    //Cutting the line to only use the information of connected nodes after.
                    l = l.substring(0, l.indexOf("[") -1);
                }
                l = l.trim();
                //Parsing the beginning and end nodes of the represented edge
                int start = Integer.parseInt(l.substring(0, l.indexOf("-")).trim());
                int end = Integer.parseInt(l.substring(l.indexOf("-") + 2, l.length()).trim());
                //Use information about both nodes to add the number to the Set of Node numbers
                sizeCalcSet.add(start);
                sizeCalcSet.add(end);
                Integer[] input = {start,end};
                //Storing into the HashMap
                edgeValues.put(input, weight);
            }
        }

        //TODO Use maximum in set to calc Size
        double[][] result = new double[sizeCalcSet.size()][sizeCalcSet.size()];
        //Using the HashMap to build the adjacency Matrix
        edgeValues.forEach((position, weight) -> {
            result[position[0]][position[1]] = weight;
            result[position[1]][position[0]] = weight;
        });
        return result;
    } 

        /**
     * Helper Method to parse the content of the dotfile and build an 
     * directed graph adjacency matrix out of it.
     * @param fileContent Linked List of Strings that represent the lines of the dotfile.
     * @return returns the built adjacency matrix or null.
     */
    private static double[][] buildDirectedMatrix(LinkedList<String> fileContent) {
        //See Method above for comments
        HashMap<Integer[], Double> edgeValues= new HashMap<Integer[],Double>();
        Set<Integer> sizeCalcSet = new LinkedHashSet<Integer>(); 
        for(String l : fileContent) {
            Matcher mArrow = Pattern.compile("->").matcher(l);
            Matcher mLabel = Pattern.compile("label").matcher(l);
            double weight = 1;
            if(mArrow.find()) {
                if(mLabel.find()){
                    String label = l.substring(l.indexOf("[") + 1, l.indexOf("]"));
                    weight = Double.parseDouble(label.substring(label.indexOf("=") + 1,label.length()).trim());
                    //System.out.println(weight);
                    l = l.substring(0, l.indexOf("[") -1);
                }
                l = l.trim();
                int start = Integer.parseInt(l.substring(0, l.indexOf("-")).trim());
                //System.out.print("Start: " + start);
                int end = Integer.parseInt(l.substring(l.indexOf(">") + 1, l.length()).trim());
                //System.out.println(" and ends at " + end);
                sizeCalcSet.add(start);
                sizeCalcSet.add(end);
                Integer[] input = {start,end};
                edgeValues.put(input, weight);
            }
        }
        double[][] result = new double[sizeCalcSet.size()][sizeCalcSet.size()];
        edgeValues.forEach((key, value) -> result[key[0]][key[1]] = value);
        return result;
    }

    /**
     * Helper method to test print the arrays
     * @param arr the array to be printed
     */
    private static void printArray(double[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
