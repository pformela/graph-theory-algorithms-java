import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BredthFirstSearch {
    private int numNodes;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public BredthFirstSearch(int numNodes, ArrayList<ArrayList<Integer>> adjacencyList) {
        this.numNodes = numNodes;
        this.adjacencyList = adjacencyList;
    }

    private int[] solve(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        boolean[] visited = new boolean[numNodes];
        visited[node - 1] = true;

        int[] prev = new int[numNodes];

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            ArrayList<Integer> neighbours = adjacencyList.get(currentNode - 1);

            for (int next : neighbours) {
                if (!visited[next - 1]) {
                    q.add(next);
                    visited[next - 1] = true;
                    prev[next - 1] = currentNode;
                }
            }
        }

        return prev;
    }

    private ArrayList<Integer> reconstructPath(int startNode, int endNode, int[] prev) {
        ArrayList<Integer> path = new ArrayList<>();

        for (int i = endNode; i != 0; i = prev[i - 1]) {
            path.add(i);
        }

        // reverse path
        if (path.get(path.size() - 1) == startNode) return path;
        else return new ArrayList<Integer>();
    }

    private ArrayList<Integer>  bfs(int startNode, int endNode) {
        int[] prev = solve(startNode);

        return reconstructPath(startNode, endNode, prev);
    }
}
