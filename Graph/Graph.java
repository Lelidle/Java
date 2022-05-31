package Graph;

public class Graph {

    private Node[] nodes;
    private double[][] matrix;

    public Graph(){
        nodes = new Node[5];
        for(int i = 0; i < 5; i ++) {
            nodes[i] = new Node(i);
        }
        matrix = new double[5][5];
    }

    public void addEdge(int start, int end, double weight) {
        matrix[start][end] = weight;
    }

    public double[][] getMatrix(){
        return matrix;
    }

    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}