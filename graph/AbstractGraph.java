package DataStructureAndAlgorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10183960 on 2017/1/26.
 */
public abstract class AbstractGraph<V> implements Graph<V> {

    protected List<V> vertices;         //store vertices(顶点)
    protected List<List<Integer>> neighbors;    //ajacency lists

    protected AbstractGraph(int[][] edges, V[] vertices) {
        this.vertices = new ArrayList<V>();
        for (int i = 0; i < vertices.length; i++) {
            this.vertices.add(vertices[i]);
        }
        createAdjacencyLists(edges, vertices.length);
    }

    protected AbstractGraph(List<Edge> edges, List<V> vertices) {
        this.vertices = vertices;
        createAdjacencyLists(edges, vertices.size());
    }

    protected AbstractGraph(int[][] edges, int numOfVertices) {
        this.vertices = new ArrayList<V>();
        for (int i = 0; i < numOfVertices; i++) {
            vertices.add((V) new Integer(i));
        }
        createAdjacencyLists(edges, numOfVertices);
    }

    protected AbstractGraph(List<Edge> edges, int numOfVertices) {
        this.vertices = new ArrayList<V>();
        for (int i = 0; i < numOfVertices; i++) {
            vertices.add((V) new Integer(i));
        }
        createAdjacencyLists(edges, numOfVertices);
    }

    public static class Edge {
        public int u;
        public int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private void createAdjacencyLists(int[][] edges, int numOfVertices) {
        neighbors = new ArrayList<List<Integer>>();
        for (int i = 0; i < numOfVertices; i++) {
            neighbors.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            neighbors.get(u).add(v);
        }
    }

    private void createAdjacencyLists(List<Edge> edges, int numOfVertices) {
        neighbors = new ArrayList<List<Integer>>();
        for (int i = 0; i < numOfVertices; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (Edge e : edges) {
            neighbors.get(e.u).add(e.v);
        }
    }

    public int getSize() {
        return vertices.size();
    }

    public List<V> getVertices() {
        return vertices;
    }

    public V getVertex(int index) {
        return vertices.get(index);
    }

    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    public List<Integer> getNeighbors(int index) {
        return neighbors.get(index);
    }

    /* 返回某个顶点的相邻节点的个数 */
    public int getDegree(int v) {
        return neighbors.get(v).size();
    }

    public int[][] getAdjacencyMatrix() {
        int[][] adjacencyMatrix = new int[getSize()][getSize()];
        for (int i = 0; i < neighbors.size(); i++) {
            for (int j = 0; j < neighbors.get(i).size(); j++) {
                int v = neighbors.get(i).get(j);
                adjacencyMatrix[i][v] = 1;
            }
        }
        return adjacencyMatrix;
    }

    public void printAdjacencyMatrix() {
        int[][] adjacencyMatrix = getAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j]  + " ");
            }
            System.out.println();
        }
    }

    public void printEdges() {

    }

    public Tree dfs(int v) {
        return null;
    }

    public Tree bfs(int v) {
        return null;
    }


    public class Tree {
        private int root;
        private int[] parent;
        private List<Integer> searchOrders;

        public Tree(int root, int[] parent, List<Integer> searchOrders) {
            this.root = root;
            this.parent = parent;
            this.searchOrders = searchOrders;
        }
        public Tree(int root, int[] parent) {
            this.root = root;
            this.parent = parent;
        }
        public int getRoot() {
            return root;
        }
        public int getParent(int v) {
            return parent[v];
        }
        public List<Integer> getSearchOrders() {
            return searchOrders;
        }
        public int getNumberOfVerticesFound() {
            return searchOrders.size();
        }
        public List<V> getPath(int index) {
            ArrayList<V> path = new ArrayList<V>();
            do {
                path.add(vertices.get(index));
                index = parent[index];
            } while(index != -1);
            return path;
        }
    }
}
