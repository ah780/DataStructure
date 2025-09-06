package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class TraverselGraph {
    public static void main(String[] args) {

    }


    public static void BFS(int start, MyGraphList graph) {

        Queue<Integer> q = new LinkedList<>();
        boolean viseted[] = new boolean[graph.v];
        q.offer(start);
        viseted[start] = true;
        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");
            for (int n : graph.adjList.get(node)) {
                if (!viseted[n]) {
                    viseted[n] = true;
                    q.offer(n);
                }
            }
        }
    }

    public static void DFS(int node, boolean viseted[], MyGraphList graph) {

        viseted[node] = true;
        System.out.print(node + " ");

        for (int n : graph.adjList.get(node)) {
            if (!viseted[n]) {
                viseted[n] = true;
                DFS(n, viseted, graph);
            }
        }


    }


}
