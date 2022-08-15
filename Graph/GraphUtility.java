package Graph;

import java.util.LinkedList;

public class GraphUtility {
    
    private boolean[] visited;
    private LinkedList<Integer> queue;
    private double[][] matrix;
    private Node[] nodes;
    

    public GraphUtility(Graph g) {
        matrix = g.getMatrix();
        nodes = g.getNodes();
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
        //System.out.println(nodeNumber + " visited!");
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

    public boolean testConnectionStrongParallel() {

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

class CustomFred extends Thread {

    private double[][] matrix;
    private Node[] nodes;
    private boolean[] visited;
    private LinkedList<Integer> queue;    
    private int nodeNumber;

    public CustomFred(double[][] matrix, Node[] nodes, int nodeNumber) {
        this.matrix = matrix;
        this.nodes = nodes;
        this.nodeNumber = nodeNumber;

    }

    public void run() {
        this.visited = new boolean[nodes.length];
        depthSearch(nodeNumber);
    }


     /**
     * Actual recursive Implementation of the depth Search.
     * @param nodeNumber the number of the starting node.
     */
    private void depthSearch(int nodeNumber){
        visited[nodeNumber] = true; 
        //System.out.println(nodeNumber + " visited!");
        for(int i = 0; i < nodes.length; i++) {
            if(matrix[nodeNumber][i] != 0 && !visited[i]) {
                depthSearch(i);
            }
        }
    }
}