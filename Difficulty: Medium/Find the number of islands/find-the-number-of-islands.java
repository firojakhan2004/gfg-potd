//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
      if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0; // To keep count of islands
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Directions for moving in 8 possible directions
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is land ('1'), we found a new island
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Perform BFS to mark all connected lands as visited
                    bfs(grid, i, j, rowDir, colDir, rows, cols);
                }
            }
        }
        
        return numIslands;
    }

    // Helper method to perform BFS
    private void bfs(char[][] grid, int i, int j, int[] rowDir, int[] colDir, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0'; // Mark the starting land cell as visited
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            
            // Explore all 8 possible directions
            for (int d = 0; d < 8; d++) {
                int newRow = currRow + rowDir[d];
                int newCol = currCol + colDir[d];
                
                // Check if the new position is within bounds and is land ('1')
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // Mark the new land cell as visited
                }
            }
        }
    }
}