package islands;

public class FindNumberOfIslandsFunction {
	public int numIslands(char[][] grid) {
		// Error checking
		if (grid == null || grid.length == 0) {
			return 0;
		}

		// number of islands
		int numOfIslands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// If we see 1
				if (grid[i][j] == '1') {
					numOfIslands += dfs(grid, i, j);
				}
			}
		}

		return numOfIslands;
	}

	public int dfs(char[][] grid, int i, int j) {
		// Error checking
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return 0;
		}

		// If the index we are on is 1, then set it to 0 so we don't revisit it
		grid[i][j] = '0';

		// Down
		dfs(grid, i + 1, j);

		// Up
		dfs(grid, i - 1, j);

		// To the right
		dfs(grid, i, j + 1);

		// To the left
		dfs(grid, i, j - 1);

		return 1;
	}
}