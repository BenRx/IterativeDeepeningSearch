// Benjamin Roux - bsar3

import java.util.*;

public class PathFinder {
    private LinkedList<Vertex> mRoute;
    private Map mMap;

    public PathFinder(LinkedList<Rectangle> obstacles) {
        mMap = new Map(obstacles);
    }

    /*
     * Launch the iterativeDeepening
     */
    public LinkedList<Vertex> findRoute(Vertex start, Vertex end) {
        mRoute = iterativeDeepening(start, end);
        return mRoute;
    }

    private LinkedList<Vertex> iterativeDeepening(Vertex first, Vertex last) {
        for (int depth = 1; true; depth++) {
            LinkedList<Vertex> route = depthFirst(first, last, depth);
            if (route != null) return route;
        }
    }

    private LinkedList<Vertex> depthFirst(Vertex first, Vertex last, int depth) {
        if (depth == 0) {
            return null;
        } else if (first.equals(last)) {
            LinkedList<Vertex> route = new LinkedList<>();
            route.add(first);
            return route;
        } else {
            List<Vertex> nexts = nextConfigs(first);
            for (Vertex next : nexts) {
                LinkedList<Vertex> route = depthFirst(next, last, depth - 1);
                if (route != null) {
                    route.addFirst(first);
                    return route;
                }
            }
            return null;
        }
    }

    /*
     * Recovery of all the available valid jump points for a current vertex 'state'
     */
    private LinkedList<Vertex> nextConfigs(Vertex state) {
        LinkedList<Vertex> neighbours = new LinkedList<>();

        // For all possible jump segments, if the vertex 'state' belongs to one of them then add the associated jump point to the list
        for (Edge validJumps : mMap.getReachableSegments()) {
            if (validJumps.getV1().equals(state)) {
                neighbours.add(validJumps.getV2());
            } else if (validJumps.getV2().equals(state)) {
                neighbours.add(validJumps.getV1());
            }
        }
        return neighbours;
    }
}
