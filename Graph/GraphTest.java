package Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GraphTest {

    private Graph g;

    public GraphTest(){
        g = new Graph();
    }

    @Test
    void testAddEdge() {
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        assertEquals(1, g.getMatrix()[2][4]);
        assertEquals(1, g.getMatrix()[1][3]);
        assertEquals(0, g.getMatrix()[0][2]);
        g.addEdge(3, 2, 5);
        assertEquals(5, g.getMatrix()[3][2]);
    }

    @Test
    void testRemoveEdge() {
        testAddEdge();
        g.removeEdge(2, 3);
        assertEquals(5, g.getMatrix()[3][2]);
    }

    @Test
    void testAddNodes() {
        testAddEdge();
        g.addNodes(2);
        assertEquals(7, g.getNodes().length);
    }

    @Test
    void testTestPath(){
        testAddEdge();
        assertEquals(false, g.callUtility().testPath(1, 0));
        assertEquals(true, g.callUtility().testPath(0, 1));
    }

    @Test
    void testDepthSearch(){
        testAddEdge();
        g.removeEdge(2, 3);
        g.callUtility().depthSearchStart(0);
    }

    @Test
    void testConnectionStrong(){
        testAddEdge();
        assertEquals(false, g.callUtility().testConnectionStrong());
        Graph g2 = new Graph();
        g2.addEdgeBoth(0,1);
        g2.addEdgeBoth(0,2);
        g2.addEdgeBoth(0, 3);
        g2.addEdgeBoth(1, 4);
        g2.addEdgeBoth(2,4);
        g2.addEdgeBoth(3, 4);
        assertEquals(true, g2.callUtility().testConnectionStrong());
    }

    @Test 
    void testConnection(){
        testAddEdge();
        assertEquals(true, g.callUtility().testConnection());
        Graph g2 = new Graph();
        assertEquals(false, g2.callUtility().testConnection());
    }

    @Test 
    void testBroadSearch(){
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.callUtility().broadSearchStart(0);
    }
}
