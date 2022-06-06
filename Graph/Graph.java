package Graph;

import java.util.LinkedList;

import List.Array.English.MyListArray;

public class Graph {

    private Node[] nodes;
    private double[][] matrix;
    private boolean[] visited;
    private LinkedList<Integer> queue;

    /**
     * Generic constructor. Builds a graph with 5 nodes and no edges.
     * The nodes have no further properties
     */
    public Graph(){
        nodes = new Node[5];
        for(int i = 0; i < 5; i ++) {
            nodes[i] = new Node(i);
        }
        matrix = new double[5][5];
    }

    /**
     * Builds a graph with an array of nodes, no edges are defined.
     * @param nodes an array of nodes for the graph
     */
    public Graph(Node[] nodes) {
        this.nodes = nodes;
        matrix = new double[nodes.length][nodes.length];
    }

    /**
     * A Constructor for a graph out of a adjacency matrix. The nodes have no properties
     * other than their number.
     * @param matrix the adjacency matrix to which a graph shall be build.
     */
    public Graph(double[][] matrix) {
        int n = matrix.length;
        if(n != matrix[0].length) {
            System.err.println("The matrix has to be square!");
            return;
        }
        this.matrix = matrix;
        nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
    }

    /**
     * Constructor to build a Graph out of an array of nodes and a fitting adjacency matrix.
     * @param nodes the array of nodes that is being used to build.
     * @param matrix the adjacency matrix that is being used to build.
     */
    public Graph(Node[] nodes, double[][] matrix) {
        int n = matrix.length;
        if(n != matrix[0].length) {
            System.err.println("The matrix has to be square!");
            return;
        } else if(n != nodes.length) {
            System.err.println("Matrix and nodearray do not match in size");
        }
        this.nodes = nodes;
        this.matrix = matrix;
    }

    /**
     * Helper method to test.
     * @return returns a reference to the node array.
     */
    public Node[] getNodes(){
        return nodes;
    }

    /**
     * Adds new nodes to the Graph and numbers them accordingly. No further data
     * is added with this method. The adjacency matrix is extended.
     * @param count the number of nodes to be added.
     */
    public void addNodes(int count){
        int n = nodes.length;
        Node[] tmp = new Node[n + count];
        for(int i = 0; i < n + count; i++) {
            if(i < n ) {
                tmp[i] = nodes[i];
            } else {
                tmp[i] = new Node(i);
            }
        }
        nodes = tmp;
        double[][] tmpMatrix = new double[n+count][n+count];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmpMatrix[i][j] = matrix[i][j];
            }
        }
        matrix = tmpMatrix;
    }

    /**
     * Adds an edge by setting the adjacency matrix at the corresponding spot to 1.
     * @param start the start node.
     * @param end the end node.
     */
    public void addEdge(int start, int end){
        matrix[start][end] = 1;
    }

    /**
     * adds an weighed edge by setting the adjacency matrix at the corresponding spot to the weight.
     * @param start the number of the start node.
     * @param end the number of the end node.
     * @param weight the weight of the new edge.
     */
    public void addEdge(int start, int end, double weight) {
        matrix[start][end] = weight;
    }


    /**
     * adds an unweighed edge in both directions by setting the adjacency matrix at the corresponding spots to 1.
     * @param start the number of the start node
     * @param end the number of the end node
     */

     public void addEdgeBoth(int start, int end) {
         matrix[start][end] = 1;
         matrix[end][start] = 1;
     }


    /**
     * adds an weighed edge in both directions by setting the adjacency matrix at the
     *  corresponding spots to the weight.
     * @param start the number of the start node.
     * @param end the number of the end node.
     * @param weight the weight of the new edge.
     */
    public void addEdgeBoth(int start, int end, double weight) {
        matrix[start][end] = weight;
        matrix[end][start] = weight;
    }

    /**
     * Removes an edge by setting the adjacency matrix at the corresponding spot to 0.
     * @param start the number of the start node of the edge.
     * @param end the number of the end node of the edge.
     */
    public void removeEdge(int start, int end) {
        matrix[start][end] = 0;
    }

    /**
     * returns a reference to the adjacency matrix.
     * @return the reference to the adjacency matrix.
     */
    public double[][] getMatrix(){
        return matrix;
    }

    /**
     * Starts a recursive depth Search at the given node.
     * @param nodeNumber the number of the node to start the search at.
     */
    public void depthSearchStart(int nodeNumber) {
        this.visited = new boolean[nodes.length];
        depthSearch(nodeNumber);
    }

    /**
     * Actual recursive Implementation of the depth Search.
     * @param nodeNumber the number of the starting node.
     */
    private void depthSearch(int nodeNumber){
        visited[nodeNumber] = true; 
        System.out.println(nodeNumber + " visited!");
        for(int i = 0; i < nodes.length; i++) {
            if(matrix[nodeNumber][i] != 0 && !visited[i]) {
                depthSearch(i);
            }
        }
    }

    /**
     * A method to test, whether two nodes are connected.
     * @param start the number of the node to start at.
     * @param end the number of the node to end.
     * @return returns true, if there is a path between both.
     */
    public boolean testPath(int start, int end) {
        depthSearchStart(start);
        return visited[end];
    }

    /**
     * Tests, if the graph is strongly connected by calling a DFS on every node.
     * If any node is not reachable at any point the graph is not connected strong.
     * @return returns true if the graph is strongly connected.
     */
    public boolean testConnectionStrong(){
        for(int i = 0; i < nodes.length; i++) {
            depthSearchStart(i);
            for(int j = 0; j < visited.length; j++) {
                if(!visited[j]) return false;
            }
        }
        return true;
    }

    /**
     * Tests, if a directed Graph is connected by testing for a node from which
     * every other node is reachable.
     * @return returns true, if the graph is connected.
     */
    public boolean testConnection(){
        for(int i = 0; i < nodes.length; i++) {
            depthSearchStart(i);
            int counter = 0;
            for(int j = 0; j < visited.length; j++) {
                counter++;
                if(!visited[j]) break;
            }
            if(counter == visited.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to print the contents of the adjacency matrix. 
     */
    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void broadSearchStart(int nodeNumber) {
        visited = new boolean[nodes.length];
        queue = new LinkedList<Integer>();
        broadSearch(nodeNumber);
    }

    public void broadSearch(int nodeNumber) {
        visited[nodeNumber] = true;
        System.out.println(nodeNumber + " visited!");
        for(int i = 0; i < nodes.length; i++) {
            if(matrix[nodeNumber][i] != 0 && !visited[i]) {
                queue.addLast(i);
            }
        }
        if(!queue.isEmpty()) broadSearch(queue.pop());
    }

}