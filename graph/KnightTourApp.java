package DataStructureAndAlgorithm.graph;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by gustaov on 2017/2/2.
 */
public class KnightTourApp extends JApplet {
    private KnightTourModel model = new KnightTourModel();
    private PaintKnightTour paintKnightTour = new PaintKnightTour();
    private JTextField ktfRow = new JTextField(2);
    private JTextField ktfColumn = new JTextField(2);
    private JButton jbtSearch = new JButton("Search");

    private static class PaintKnightTour extends JPanel {
        private List<Integer> path;

        public PaintKnightTour() {
            setBorder(BorderFactory.createLineBorder(Color.black, 1));
        }

        public void displayPath(List<Integer> path) {
            this.path = path;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < 8; i++) {
                g.drawLine(0, i * getHeight() / 8, getWidth(), i * getHeight() / 8);
            }
            for (int i = 0; i < 8; i++) {
                g.drawLine(i * getWidth() / 8, 0, (int) i * getWidth() / 8, i * getHeight() / 8);
            }
            if (path == null) return;

            for (int i = 0; i < path.size(); i++) {
                int u = path.get(i);
                int v = path.get(i + 1);

                g.drawLine((u % 8) * getWidth() / 8 + getWidth() / 16,
                        (u / 8) * getHeight() / 8 + getHeight() / 16,
                        (v % 8) * getWidth() / 8 + getWidth() / 16,
                        (v / 8) * getHeight() / 8 + getHeight() / 16 );
            }
        }
    }
}
