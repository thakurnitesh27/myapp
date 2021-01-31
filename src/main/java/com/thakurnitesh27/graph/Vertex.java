package com.thakurnitesh27.graph;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Represents a graph vertex
public class Vertex {

    private List<Vertex> adjacentVertices;
    private VertexColor vertexColor;
    private Vertex parent;
    private Integer snapshotDistance;
    private Integer finalDistance; //used in case of DFS only.
    private String name;


    public Vertex(List<Vertex> adjacentVertices) {
        this.adjacentVertices = ImmutableList.copyOf(adjacentVertices);
    }

    public Vertex(String name) {
        this.name=name;
        this.adjacentVertices = new ArrayList<Vertex>();
        vertexColor=VertexColor.WHITE;
        snapshotDistance=Integer.MIN_VALUE; //represents undefined value
    }

    public ImmutableList<Vertex> getAdjacentVertices() {
        return ImmutableList.copyOf(adjacentVertices);
    }

    public void setAdjacentVertices(List<Vertex> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
    public void addToAdjacencyList(Vertex... vertex){
        adjacentVertices.addAll(Arrays.asList(vertex));
    }

    public VertexColor getVertexColor() {
        return vertexColor;
    }

    public void setVertexColor(VertexColor vertexColor) {
        this.vertexColor = vertexColor;
    }

    public Vertex getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Integer getSnapshotDistance() {
        return snapshotDistance;
    }

    public void setSnapshotDistance(Integer snapshotDistance) {
        this.snapshotDistance = snapshotDistance;
    }

    public Integer getFinalDistance() {
        return finalDistance;
    }

    public void setFinalDistance(Integer finalDistance) {
        this.finalDistance = finalDistance;
    }
}

