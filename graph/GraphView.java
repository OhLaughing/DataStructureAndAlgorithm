package DataStructureAndAlgorithm.graph;

/**
 * Created by 10183960 on 2017/1/26.
 */
public class GraphView extends javax.swing.JPanel {
    private Graph<? extends Displayable> graph;

    public GraphView(Graph<? extends Displayable> graph) {
        this.graph = graph;
    }

    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        java.util.List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++) {
            int x = vertices.get(i).getX();
            int y = vertices.get(i).getY();
            String name = vertices.get(i).getName();
        }
    }
}
