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
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printEdges() {

    }

    public Tree dfs(int v) {
        List<Integer> searchOrders = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        boolean[] isVisited = new boolean[vertices.size()];

        dfs(v, parent, searchOrders, isVisited);
        return new Tree(v, parent, searchOrders);
    }

    private void dfs(int v, int[] parent, List<Integer> searchOrders, boolean[] isVisited) {
        searchOrders.add(v);
        isVisited[v] = true;

        for (int i : neighbors.get(v)) {
            if (!isVisited[i]) {
                parent[i] = v;
                dfs(i, parent, searchOrders, isVisited);
            }
        }
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
            } while (index != -1);
            return path;
        }
    }

    public java.util.List<Integer> getHamiltonianPath(V vertex) {
        return getHamiltonianPath(getIndex(vertex));
    }

    public List<Integer> getHamiltonianPath(int v) {
        int[] next = new int[getSize()];
        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
        }
        boolean[] isVisited = new boolean[getSize()];

        List<Integer> result = null;

        for (int i = 0; i < getSize(); i++) {
            reorderNeigborsBaseOnDegree(neighbors.get(i));
        }
        if (getHamiltonianPath(v, next, isVisited)) {
            result = new ArrayList<Integer>();
            int vertex = v;
            while (vertex != -1) {
                result.add(vertex);
                vertex = next[vertex];
            }
        }
        return result;
    }

    private void reorderNeigborsBaseOnDegree(List<Integer> list) {
        for (int i = list.size(); i >= 1; i--) {
            int currentMaxDegree = getDegree(list.get(0));
            int currentMaxIndex = 0;

            for (int j = 0; j < i; j++) {
                if (currentMaxDegree < getDegree(list.get(j))) {
                    currentMaxDegree = getDegree(list.get(j));
                    currentMaxIndex = j;
                }
            }
            if (currentMaxIndex != i) {
                int temp = list.get(currentMaxIndex);
                list.set(currentMaxIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }

    private boolean allVisited(boolean[] isVisited) {
        boolean result = true;

        for (int i = 0; i < getSize(); i++) {
            result = result & isVisited[i];
        }
        return result;
    }

    private boolean getHamiltonianPath(int v, int[] next, boolean[] isVisited) {
        isVisited[v] = true;

        if (allVisited(isVisited))
            return true;

        for (int i = 0; i < neighbors.get(v).size(); i++) {
            int u = neighbors.get(v).get(i);
            if (!isVisited[u] && getHamiltonianPath(u, next, isVisited)) {
                next[v] = u;
                return true;
            }
        }
        isVisited[v] = false;
        return false;
    }
}
