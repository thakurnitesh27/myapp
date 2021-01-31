package com.thakurnitesh27.graph.dfs;

import com.google.common.collect.ImmutableList;
import com.sun.tools.javac.util.Pair;
import com.thakurnitesh27.graph.Edge;
import com.thakurnitesh27.graph.Vertex;
import com.thakurnitesh27.graph.VertexColor;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

   // private Vertex sourceVertexFromWhereToSearch;
    private List<Vertex> vertices;
    int distance=0;
    private List<Edge> treeEdgesList;
    private List<Edge> nonTreeEdgesList;

    public DepthFirstSearch(/*Vertex sourceVertexFromWhereToSearch,*/ List<Vertex> vertices) {
      //  this.sourceVertexFromWhereToSearch = sourceVertexFromWhereToSearch;
        this.vertices=vertices;

    }

    public Pair<List<Edge>,List<Edge>> search(){
        treeEdgesList=new ArrayList<Edge>();
        nonTreeEdgesList=new ArrayList<Edge>();

        for(Vertex vertex: vertices){
            if(vertex.getVertexColor().equals(VertexColor.WHITE)){
                search(vertex);
            }
        }

        return Pair.of(treeEdgesList,nonTreeEdgesList);




    }

    private void search(Vertex vertex){
        vertex.setSnapshotDistance(++distance);
        vertex.setVertexColor(VertexColor.GRAY);

        ImmutableList<Vertex> adjacencyList=vertex.getAdjacentVertices();
        for(Vertex adjacentVertex:adjacencyList){

            if(adjacentVertex.getVertexColor().equals(VertexColor.WHITE)){
                adjacentVertex.setParent(vertex);
                treeEdgesList.add(new Edge(vertex,adjacentVertex));
                search(adjacentVertex);
            }
            else {
                nonTreeEdgesList.add(new Edge(vertex,adjacentVertex));
            }
        }
        vertex.setFinalDistance(++distance);
        vertex.setVertexColor(VertexColor.BLACK);
    }
}
