// Benjamin Roux - bsar3

import java.util.*;

public class Main {
    public static void main(String args[]) {
        LinkedList<Rectangle> obstacles = new LinkedList<>(Arrays.asList(
                new Rectangle(new Vertex(20, 13), new Vertex(20, 14), new Vertex(23, 14), new Vertex(23, 13)),
                new Rectangle(new Vertex(6, 6), new Vertex(6, 13), new Vertex(9, 13), new Vertex(9, 6)),
                new Rectangle(new Vertex(15, 10), new Vertex(15, 19), new Vertex(17, 19), new Vertex(17, 10)),
                new Rectangle(new Vertex(13, 17), new Vertex(13, 19), new Vertex(17, 19), new Vertex(17, 17)),
                new Rectangle(new Vertex(20, 12), new Vertex(20, 16), new Vertex(23, 16), new Vertex(23, 12)),
                new Rectangle(new Vertex(13, 9), new Vertex(13, 10), new Vertex(13, 10), new Vertex(14, 9)),
                new Rectangle(new Vertex(20, 16), new Vertex(20, 17), new Vertex(22, 17), new Vertex(22, 16)),
                new Rectangle(new Vertex(2, 12), new Vertex(2, 16), new Vertex(4, 16), new Vertex(4, 12)),
                new Rectangle(new Vertex(8, 4), new Vertex(8, 11), new Vertex(10, 11), new Vertex(10, 4)),
                new Rectangle(new Vertex(13, 12), new Vertex(13, 15), new Vertex(21, 15), new Vertex(21, 12)),
                new Rectangle(new Vertex(1, 7), new Vertex(1, 11), new Vertex(6, 11), new Vertex(6, 7)),
                new Rectangle(new Vertex(13, 15), new Vertex(13, 20), new Vertex(17, 20), new Vertex(17, 15)),
                new Rectangle(new Vertex(13, 14), new Vertex(13, 18), new Vertex(15, 18), new Vertex(15, 14)),
                new Rectangle(new Vertex(19, 15), new Vertex(19, 18), new Vertex(22, 18), new Vertex(22, 15)),
                new Rectangle(new Vertex(12, 8), new Vertex(12, 12), new Vertex(17, 12), new Vertex(17, 8)),
                new Rectangle(new Vertex(19, 20), new Vertex(19, 21), new Vertex(23, 21), new Vertex(23, 20))));

        LinkedList<Edge> puzzles = new LinkedList<>(Arrays.asList(
                new Edge(new Vertex(23, 16), new Vertex(8, 4)),
                new Edge(new Vertex(23, 14), new Vertex(6, 11)),
                new Edge(new Vertex(23, 13), new Vertex(6, 7)),
                new Edge(new Vertex(23, 12), new Vertex(6, 6)),
                new Edge(new Vertex(22, 18), new Vertex(2, 12)),
                new Edge(new Vertex(22, 17), new Vertex(1, 11)),
                new Edge(new Vertex(21, 12), new Vertex(19, 15)),
                new Edge(new Vertex(20, 12), new Vertex(17, 15)),
                new Edge(new Vertex(19, 15), new Vertex(17, 10)),
                new Edge(new Vertex(17, 12), new Vertex(13, 15)),
                new Edge(new Vertex(17, 10), new Vertex(13, 14)),
                new Edge(new Vertex(23, 21), new Vertex(1, 7))));

        // Instantiation of the pathfinder with the given obstacles
        PathFinder pf = new PathFinder(obstacles);
        int i = 0;
        for (Edge puzzle : puzzles) {
            // Retrieving the route for a given problem
            LinkedList<Vertex> route = pf.findRoute(puzzle.getV1(), puzzle.getV2());

            System.out.println("=== PROBLEM " + i + " ===");
            System.out.println("=== Start = " + puzzle.getV1().toString() + " End = " + puzzle.getV2().toString() + " ===");
            System.out.println("=== ROUTE ===");

            // Formatting results
            StringBuilder formattedResult = new StringBuilder();
            int j = 0;
            for (Vertex v : route) {
                System.out.println(v.toString());
                if (j == route.size() - 1) {
                    formattedResult.append(v.toString());
                } else {
                    formattedResult.append(v.toString()).append(" ");
                }
                j++;
            }

            // Writing results in a file
            try {
                FileCreator.createFile(i + ".txt", formattedResult.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            i++;
            System.out.println();
        }
    }
}
