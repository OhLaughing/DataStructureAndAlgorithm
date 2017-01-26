package DataStructureAndAlgorithm.graph;

import javax.swing.*;

/**
 * Created by gustaov on 2017/1/26.
 */
public class DisplayUSMap extends JApplet {
    private City[] vertices = {new City("Seattle", 75, 50),
            new City("San Francisco", 50, 210),
            new City("Los Angeles", 75, 275),
            new City("Denver", 275, 175),
            new City("Kansas", 400, 245),
            new City("Chicago", 450, 100),
            new City("Boston", 700, 80),
            new City("New York", 675, 120),
            new City("Atlanta", 575, 295),
            new City("Miami", 600, 400),
            new City("Dallas", 408, 325),
            new City("Houston", 450, 360)
    };

    private int[][] edges = {
            {0,1},{0,3},{0,5},
            {1,0},{1,2},{1,3},
            {2,1},{2,3},{2,4},{2,10},
            {3,0},{3,1},{3,2},{3,4},{3,5},
            {4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
            {5,0},{5,3},{5,4},{5,6},{5,7},
            {6,5},{6,7},
            {7,4},{7,5},{7,6},{7,8},
            {8,4},{8,7},{8,9},{8,10},{8,11},
            {9,8},{9,11},
            {10,2},{10,4},{10,8},{10,11},
            {11,8},{11,9},{11,10}
    };

    private Graph<City> graph = new UnweightedGraph<City>(edges, vertices);

    public DisplayUSMap() {
        add(new GraphView(graph));
    }

    static class City implements Displayable {
        private int x, y;
        private String name;

        public City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
