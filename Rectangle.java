// Benjamin Roux - bsar3

import java.util.*;

public class Rectangle {
    private LinkedList<Vertex> mVertices;
    private LinkedList<Edge> mEdges;
    private LinkedList<Edge> mDiagonals;

    public Rectangle(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        mVertices = new LinkedList<>(Arrays.asList(v1, v2, v3, v4));
        mEdges = new LinkedList<>(Arrays.asList(new Edge(v1, v2), new Edge(v2, v3), new Edge(v3, v4), new Edge(v4, v1)));
        mDiagonals = new LinkedList<>(Arrays.asList(new Edge(v1, v3), new Edge(v2, v4)));
    }

    public LinkedList<Vertex> getVertices() {
        return mVertices;
    }

    public LinkedList<Edge> getEdges() {
        return mEdges;
    }

    public LinkedList<Edge> getDiagonals() {
        return mDiagonals;
    }

    /*
     * Test if a given vertex 'v' is inside of this rectangle
     */
    public boolean isVertexInside(Vertex v) {
        return v.get_x() > mVertices.get(0).get_x() && v.get_x() < mVertices.get(2).get_x() && v.get_y() > mVertices.get(0).get_y() && v.get_y() < mVertices.get(2).get_y();
    }
}
