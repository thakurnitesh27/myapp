package com.thakurnitesh27.ds;

import java.util.Collection;
import java.util.List;

public class DisjointSetAppl {

    public static void main(String[] args) {
        DisjointSet<String> disjointSet = new DisjointSet<>();
        //Example from page no 506 of CLRS.

        disjointSet.makeSet("c");
        disjointSet.makeSet("h");
        disjointSet.makeSet("b");
        disjointSet.makeSet("e");

        disjointSet.makeSet("f");
        disjointSet.makeSet("d");
        disjointSet.makeSet("g");

        printDisjointSet(disjointSet);

        disjointSet.union("c","h");
        disjointSet.union("c","e");
        disjointSet.union("h","b");
        printDisjointSet(disjointSet);

        disjointSet.union("f","d");
        disjointSet.union("d","g");
        printDisjointSet(disjointSet);

        //connecting two graph.
        disjointSet.union("f","c");
        printDisjointSet(disjointSet);

    }
    public static void printDisjointSet(DisjointSet<String> disjointSet){
        Collection<List<String>> disjointSets= disjointSet.collectDisjointSets();
        disjointSets.forEach(list->{
            System.out.print("{");
            list.forEach(s-> System.out.print(s+","));
            System.out.println("}");
        });
    }
}
