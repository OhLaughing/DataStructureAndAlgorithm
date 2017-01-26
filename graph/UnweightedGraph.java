package DataStructureAndAlgorithm.graph;

import java.util.List;

/**
 * Created by 10183960 on 2017/1/26.
 */
public class UnweightedGraph<V> extends AbstractGraph<V> {

    public UnweightedGraph(int[][] edges, V[] vertices) {
        super(edges, vertices);
    }

    public UnweightedGraph(List<Edge> edges, List<V>vertices) {
        super(edges, vertices);
    }

    public UnweightedGraph(List<Edge> edges, int numOfVertices) {
        super(edges,numOfVertices);
    }

    public UnweightedGraph(int[][] edges, int numOfVertices) {
        super(edges, numOfVertices);
    }
}
