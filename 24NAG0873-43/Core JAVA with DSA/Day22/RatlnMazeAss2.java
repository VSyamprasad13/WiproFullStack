package day22assignments;

public class RatInMazeass2 {
	  private static final int N = 6;  // Size of the maze

	    // Function to solve the maze problem
	    public static boolean solveMaze(int[][] maze) {
	        int[][] solution = new int[N][N];

	        // Initialize solution matrix with 0s
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                solution[i][j] = 0;
	            }
	        }

	        if (solveMazeUtil(maze, 0, 0, solution) == false) {
	            System.out.println("No solution exists");
	            return false;
	        }

	        printSolution(solution);
	        return true;
	    }

	    // A utility function to check if x, y is valid index for N*N maze
	    private static boolean isSafe(int[][] maze, int x, int y) {
	        // If (x, y) is within maze and it's a valid path
	        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	    }

	    // A recursive utility function to solve the Maze problem
	    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
	        // If (x, y) is the goal, return true
	        if (x == N - 1 && y == N - 1) {
	            solution[x][y] = 1;
	            return true;
	        }

	        // Check if maze[x][y] is valid
	        if (isSafe(maze, x, y) == true) {
	            // Mark x, y as part of solution path
	            solution[x][y] = 1;

	            // Move forward in x direction
	            if (solveMazeUtil(maze, x + 1, y, solution)) {
	                return true;
	            }

	            // If moving in x direction doesn't give a solution then move down in y direction
	            if (solveMazeUtil(maze, x, y + 1, solution)) {
	                return true;
	            }

	            // If none of the above movements work then BACKTRACK: unmark x, y as part of solution path
	            solution[x][y] = 0;
	            return false;
	        }

	        return false;
	    }

	    // Function to print the solution matrix
	    private static void printSolution(int[][] solution) {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.print(solution[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int[][] maze = {
	            { 0, 0, 1, 0, 0, 0 },
	            { 0, 1, 0, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 1 }
	        };

	        solveMaze(maze);
	    }

}
