package com.pal.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Topological sorting of a Directed Acyclic Graph(DAG)
 */
public class TopologicalSort {
    private int V;

    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSort(int v){
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    void topologicalSortUtil(int v,boolean visited[], Stack<Integer> stack){
        visited[v] = true;
        Integer i;

        Iterator<Integer> itr = adj.get(v).iterator();
        while(itr.hasNext()){
            i = itr.next();
            if(!visited[i])
                topologicalSortUtil(i,visited,stack);
        }

        stack.push(v);
    }

    void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();

        boolean visited[] = new boolean[V];

        //for(int i=0;i< V; i++)
          //  visited[i] = false;

        for (int i=0;i<V;i++)
            if(visited[i] == false)
                topologicalSortUtil(i,visited,stack);

        while(stack.empty() == false)
            System.out.println(stack.pop()+" ");
    }

    public static void main(String args[]){
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5,2);
        graph.addEdge(5,0);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(2,3);
        graph.addEdge(3,1);

        System.out.println("Following is a Topological sort of the given graph");

        graph.topologicalSort();
    }
}
