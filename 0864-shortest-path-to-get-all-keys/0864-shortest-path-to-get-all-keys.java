class Solution {

    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int allKeys = 0;
        int startRow = -1;
        int startCol = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    allKeys |= (1 << (c - 'a'));
                }
            }
        }
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][64]; 
        State initialState = new State(startRow, startCol, 0);
        queue.offer(initialState);
        visited[startRow][startCol][0] = true;
        int steps = 0; 
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State currentState = queue.poll();
                if (currentState.keys == allKeys) return steps;
                for (int[] direction : directions) {
                    int newRow = currentState.row + direction[0];
                    int newCol = currentState.col + direction[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        char newCell = grid[newRow].charAt(newCol);
                        if (newCell == '#') continue;                     
                        int newKeys = currentState.keys;
                        if (newCell >= 'a' && newCell <= 'f') newKeys |= (1 << (newCell - 'a'));
                        if (newCell >= 'A' && newCell <= 'F' && 
                        ((currentState.keys >> (newCell - 'A')) & 1) == 0) continue;
                        if (!visited[newRow][newCol][newKeys]) {
                            State newState = new State(newRow, newCol, newKeys);
                            queue.offer(newState);
                            visited[newRow][newCol][newKeys] = true;
                        }
                    }
                }
            }
            steps++; 
        }
        return -1;
    }
    private class State {
        int row;
        int col;
        int keys;

        public State(int row, int col, int keys) {
            this.row = row;
            this.col = col;
            this.keys = keys;
        }
    }
}