// Benjamin Roux - bsar3

import java.util.*;

public class Map {
    private LinkedList<Rectangle> mObstacles;
    private LinkedList<Edge> mReachableSegments;


    public Map(LinkedList<Rectangle> obstacles) {
        mObstacles = obstacles;

        // Computing all valid jump segments
        mReachableSegments = computeReachablePoints();
    }

    /*
     * For all vertex compute all valid jump segments according to all obstacles edges
     */
    private LinkedList<Edge> computeReachablePoints() {
        LinkedList<Edge> reachableSegments = new LinkedList<>();

        // For all rectangles
        for (Rectangle rectangleA : mObstacles) {
            // For all of their vertices
            for (Vertex vertexA : rectangleA.getVertices()) {
                // Check if A is not inside a rectangle
                if (!isVertexInsideAnyObstacle(vertexA)) {
                    // For all rectangles
                    for (Rectangle rectangleB : mObstacles) {
                        // For all of their vertices
                        for (Vertex vertexB : rectangleB.getVertices()) {
                            // Check if B is not inside a rectangle and if A != B
                            if (!isVertexInsideAnyObstacle(vertexB) && !vertexA.equals(vertexB)) {
                                Edge edge = new Edge(vertexA, vertexB);
                                // Check if [A, B] does not cross a rectangle diagonal and if [A, B] does not cross any rectangle edge
                                if (!isEdgeCrossAnObstacleDiagonal(edge) && !isEdgeInterceptAnyObstacleEdges(edge)) {
                                    // Stock it into reachableSegments list avoiding duplicate
                                    boolean contain = false;
                                    for (Edge e : reachableSegments) {
                                        if (edge.equals(e)) {
                                            contain = true;
                                            break;
                                        }
                                    }
                                    if (!contain) {
                                        reachableSegments.add(edge);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return reachableSegments;
    }

    /*
     * Test if the vertex 'v' is inside of any rectangle of the map
     */
    private boolean isVertexInsideAnyObstacle(Vertex v) {
        for (Rectangle rectangle : mObstacles) {
            if (rectangle.isVertexInside(v)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Test if the edge 'edge' intercept any rectangle edge
     */
    private boolean isEdgeInterceptAnyObstacleEdges(Edge edge) {
        for (Rectangle obstacles : mObstacles) {
            for (Edge obstacleEdge : obstacles.getEdges()) {
                if (Vertex.linesIntersect(edge.getV1(), edge.getV2(), obstacleEdge.getV1(), obstacleEdge.getV2())) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Test if the edge 'edge' intercept any rectangle diagonal
     */
    private boolean isEdgeCrossAnObstacleDiagonal(Edge edge) {
        for (Rectangle r : mObstacles) {
            for (Edge diagonal : r.getDiagonals()) {
                if (Vertex.linesIntersect(edge.getV1(), edge.getV2(), diagonal.getV1(), diagonal.getV2())) {
                    return true;
                }
            }
        }
        return false;
    }

    public LinkedList<Edge> getReachableSegments() {
        return mReachableSegments;
    }
}
