package com.thakurnitesh27.graph.bfs;

import com.sun.tools.javac.util.Pair;
import com.thakurnitesh27.graph.Edge;
import com.thakurnitesh27.graph.Vertex;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Vertex v= new Vertex("v");

        Vertex r=new Vertex("r");
        r.addToAdjacencyList(v);

        Vertex s=new Vertex("s");
        Vertex w=new Vertex("w");
        Vertex t=new Vertex("t");
        Vertex x=new Vertex("x");
        Vertex u=new Vertex("u");
        Vertex y=new Vertex("y");

        s.addToAdjacencyList(r,w);
        w.addToAdjacencyList(s,t,x);
        t.addToAdjacencyList(w,x,u);
        x.addToAdjacencyList(t,w,u,y);
        u.addToAdjacencyList(t,x,y);
        y.addToAdjacencyList(x,u,y);
        //See structure of graph from page no 533 of CLRS.(BFS example)


        //Let s be the source vertex from which we want to find the distance to each vertex.
        BreadthFirstSearch breadthFirstSearch=new BreadthFirstSearch(s);
        Pair<List<Edge> ,List<Edge>>  allEdges=breadthFirstSearch.search();
        System.out.println("Tree Edges: ");
        List<Edge> edges=allEdges.fst;
        for(Edge edge: edges){
            System.out.println(edge.getSourceVertex().getName()+"["+edge.getSourceVertex().getSnapshotDistance()+"]==="+
                               edge.getSinkVertex().getName()+"["+edge.getSinkVertex().getSnapshotDistance()+"]");
        }


        System.out.println("Non Tree Edges: ");
        List<Edge> nonTreeEdges=allEdges.snd;
        for(Edge edge: nonTreeEdges){
            System.out.println(edge.getSourceVertex().getName()+"["+edge.getSourceVertex().getSnapshotDistance()+"]==="+
                    edge.getSinkVertex().getName()+"["+edge.getSinkVertex().getSnapshotDistance()+"]");
        }



    }
}
