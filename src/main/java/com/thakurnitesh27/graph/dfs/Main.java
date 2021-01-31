package com.thakurnitesh27.graph.dfs;

import com.google.common.collect.Lists;
import com.sun.tools.javac.util.Pair;
import com.thakurnitesh27.graph.Edge;
import com.thakurnitesh27.graph.Vertex;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Vertex u=new Vertex("u");
        Vertex v=new Vertex("v");
        Vertex w=new Vertex("w");
        Vertex x=new Vertex("x");
        Vertex y=new Vertex("y");
        Vertex z=new Vertex("z");

        u.addToAdjacencyList(x,v);
        v.addToAdjacencyList(y);
        x.addToAdjacencyList(v);

        w.addToAdjacencyList(y,z);
        z.addToAdjacencyList(z);

       List<Vertex> vertices= Lists.newArrayList(u,v,w,x,y,z);
       DepthFirstSearch depthFirstSearch=new DepthFirstSearch(vertices);
        Pair<List<Edge>,List<Edge>> allEdges=depthFirstSearch.search();

        System.out.println("Tree Edges: ");
        List<Edge> edges=allEdges.fst;
        for(Edge edge: edges){
            System.out.println(edge.getSourceVertex().getName()+"["+edge.getSourceVertex().getSnapshotDistance()+"/"+edge.getSourceVertex().getFinalDistance()+"]==="+
                    edge.getSinkVertex().getName()+"["+edge.getSinkVertex().getSnapshotDistance()+"/"+edge.getSinkVertex().getFinalDistance()+"]");
        }


        System.out.println("Non Tree Edges: ");
        List<Edge> nonTreeEdges=allEdges.snd;
        for(Edge edge: nonTreeEdges){
            System.out.println(edge.getSourceVertex().getName()+"["+edge.getSourceVertex().getSnapshotDistance()+"/"+edge.getSourceVertex().getFinalDistance()+"]==="+
                    edge.getSinkVertex().getName()+"["+edge.getSinkVertex().getSnapshotDistance()+"/"+edge.getSinkVertex().getFinalDistance()+"]");
        }


    }
}
