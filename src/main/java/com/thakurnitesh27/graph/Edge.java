package com.thakurnitesh27.graph;

public class Edge {

    private  final Vertex sourceVertex;
    private final Vertex sinkVertex;

    public Edge(Vertex sourceVertex, Vertex sinkVertex) {
        this.sourceVertex = sourceVertex;
        this.sinkVertex = sinkVertex;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public Vertex getSinkVertex() {
        return sinkVertex;
    }
}
