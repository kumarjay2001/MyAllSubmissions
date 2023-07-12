class Solution {
    public boolean DFS(int s, List<List<Integer>> graph, boolean[] visited, boolean[] dfsVisited, boolean[] checkCycle) {
        visited[s] = dfsVisited[s] = true; 
        for (int it : graph.get(s)) {
            if (!visited[it]) {
                if (DFS(it, graph, visited, dfsVisited, checkCycle))
                    return checkCycle[s] = true;
            } else if (dfsVisited[it]) { 
                return checkCycle[s] = true; 
            }
        }
        dfsVisited[s] = false; 
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        boolean[] visited = new boolean[v];
        boolean[] dfsVisited = new boolean[v];
        boolean[] checkCycle = new boolean[v];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                DFS(i, adjList, visited, dfsVisited, checkCycle);
        }

        for (int i = 0; i < v; i++) {
            if (!checkCycle[i])
                ans.add(i);
        }

        return ans;
    }
}