package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyGraphList {

    int v;
    List<LinkedList<Integer>> adjList;

    public MyGraphList(int v) {
        this.v = v;
        adjList = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int j : adjList.get(i)) {
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }

}
