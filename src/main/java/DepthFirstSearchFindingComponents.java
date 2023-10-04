import java.util.ArrayList;

public class DepthFirstSearchFindingComponents {
    private int numNodes;
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int count = 0;
    private int[] components;
    private boolean[] visited;

    public DepthFirstSearchFindingComponents(int numNodes, ArrayList<ArrayList<Integer>> adjacencyList) {
        this.numNodes = numNodes;
        this.adjacencyList = adjacencyList;
        this.components = new int[numNodes];
        this.visited = new boolean[numNodes];
    }

    public void findComponents() {
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
    }

    public void dfs(int currentNode) {
        visited[currentNode - 1] = true;
        components[currentNode - 1] = count;

        for (int next : adjacencyList.get(currentNode - 1)) {
            if (!visited[next - 1]) dfs(next);
        }
    }
}
