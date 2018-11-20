package com.travel.world.routeFinder;

import com.travel.world.travelMap.Station;

import java.util.*;
import java.util.Map;


class Graph {
    /* One edge of the graph (only used by Graph constructor) */
    public static class Edge {
        public final String v1, v2;
        public final int dist;

        public Edge(String v1, String v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

    }
    private final java.util.Map<String, Station> graph; // mapping of vertex names to Vertex objects, built from a set of Edges
    /** Builds a graph from a set of edges */
    public Graph(Edge[] edges) {
        graph = new HashMap<>(edges.length);

        //one pass to find all vertices
        createEdges(edges);
    }
    public Graph(int edges) {
        graph = new HashMap<>(edges);
    }
    public void addEdge(String v1, String v2, int dist) {
        createEdges(new Edge[]{new Edge(v1, v2, dist)});
    }
    private void createEdges(Edge[] edges) {
        for (Edge e : edges) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, new Station(e.v1));
            if (!graph.containsKey(e.v2)) graph.put(e.v2, new Station(e.v2));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
            graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    /** Runs dijkstra using a specified source vertex */
    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Station source = graph.get(startName);
        NavigableSet<Station> q = new TreeSet<>();

        // set-up vertices
        for (Station v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /* Implementation of dijkstra's algorithm using a binary heap. */
    private void dijkstra(final NavigableSet<Station> q) {
        Station u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Station, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }
    /** Prints the path from the source to every vertex (output order is not guaranteed) */
    public void printAllPaths() {
        for (Station v : graph.values()) {
            v.printPath();
            System.out.println();
        }
    }
}


public class Dijkstra {
    private static final Graph.Edge[] GRAPH = {
            new Graph.Edge("a", "b", 8),
            new Graph.Edge("a", "c", 2),
            new Graph.Edge("a", "d", 5),
            new Graph.Edge("b", "d", 2),
            new Graph.Edge("b", "f", 13),
            new Graph.Edge("c", "d", 2),
            new Graph.Edge("c", "e", 5),
            new Graph.Edge("d", "e", 1),
            new Graph.Edge("d", "g", 3),
            new Graph.Edge("e", "g", 1),
            new Graph.Edge("f", "g", 2),
            new Graph.Edge("f", "h", 3),
            new Graph.Edge("g", "h", 6),
            new Graph.Edge("g", "f", 2),
    };
    private static final String START = "a";
    private static final String END = "i";

    public static void main(String[] args) {
        Graph g = new Graph(GRAPH);
        g.addEdge("h","i",7);
        g.dijkstra(START);
        g.printPath(END);
    }
}
