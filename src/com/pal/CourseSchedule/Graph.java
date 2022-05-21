package com.pal.CourseSchedule;

import java.util.ArrayList;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> g;

    Graph(int v){
        V = v;
        g = new ArrayList<ArrayList<Integer>>(V);
        for(int i=0;i<V;i++){
           g.add(new ArrayList<Integer>());
        }
    }

    ArrayList<ArrayList<Integer>> addEdge(int v, int w){
        g.get(v).add(w);

        return g;
    }
}
