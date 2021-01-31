package com.thakurnitesh27.graph.bfs;

import com.google.common.collect.ImmutableList;
import com.sun.javafx.collections.ElementObservableListDecorator;
import com.sun.tools.javac.util.Pair;
import com.thakurnitesh27.graph.Edge;
import com.thakurnitesh27.graph.Vertex;
import com.thakurnitesh27.graph.VertexColor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    private Vertex sourceVertexFromWhereToSearch;
    private Queue<Vertex> queue;
    private List<Edge> treeEdgeList;
    private List<Edge> nonTreeEdgeList;

    public BreadthFirstSearch(Vertex sourceVertexFromWhereToSearch) {
        this.sourceVertexFromWhereToSearch = sourceVertexFromWhereToSearch;
        sourceVertexFromWhereToSearch.setVertexColor(VertexColor.GRAY);
        sourceVertexFromWhereToSearch.setSnapshotDistance(0);
        sourceVertexFromWhereToSearch.setParent(null);

        //search();
    }

    public Pair<List<Edge>,List<Edge>> search() {

        treeEdgeList = new ArrayList<Edge>();
        nonTreeEdgeList=new ArrayList<Edge>();
        queue = new LinkedList<Vertex>();
        queue.add(sourceVertexFromWhereToSearch);


        while (!queue.isEmpty()) {
            Vertex sourceVertex = queue.poll();
            ImmutableList<Vertex> adjacencyList = sourceVertex.getAdjacentVertices();
            for (Vertex vertex : adjacencyList) {
                if (vertex.getVertexColor().equals(VertexColor.WHITE)) {
                    Edge edge = new Edge(sourceVertex, vertex);
                    treeEdgeList.add(edge);
                    vertex.setVertexColor(VertexColor.GRAY);
                    vertex.setParent(sourceVertex);
                    vertex.setSnapshotDistance(sourceVertex.getSnapshotDistance() + 1);
                    queue.add(vertex);
                }
                else {
                    nonTreeEdgeList.add(new Edge(sourceVertex, vertex));
                }
            }
            sourceVertex.setVertexColor(VertexColor.BLACK);

        }

        return Pair.of(treeEdgeList,nonTreeEdgeList);

    }

//    private void printPath() {
//        int identation = edgeList.size();
//        for (int j = 0; j < edgeList.size(); j++) {
//            for (int i = 0; i < identation; i++) {
//                System.out.print("\t");
//            }
//            Edge currentEdge = edgeList.get(j);
//            System.out.println(currentEdge.getSourceVertex() + "[" + currentEdge.getSourceVertex().getSnapshotDistance() + "]");
//
//
//        }
//    }
}
