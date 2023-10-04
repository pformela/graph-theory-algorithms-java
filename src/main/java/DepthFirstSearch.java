import java.util.ArrayList;

public class DepthFirstSearch {
    private int numNodes;
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private boolean[] visited;

    public DepthFirstSearch(int numNodes, ArrayList<ArrayList<Integer>> adjacencyList) {
        this.numNodes = numNodes;
        this.adjacencyList = adjacencyList;
        this.visited = new boolean[numNodes];
    }

    public void dfs(int currentNode) {
        if (visited[currentNode - 1]) return;
        visited[currentNode - 1] = true;

        for (int next : adjacencyList.get(currentNode - 1)) {
            dfs(next);
        }
    }

    public static void main(String[] args) {
        int startNode = 1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        // dfs(startNode);
    }

}
