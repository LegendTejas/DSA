package Backtracking;
import java.util.*;

public class Nqueens {

	    // Main method to solve N-Queens problem
	    public List<List<String>> solveNQueens(int n) {
	        List<List<String>> allBoards = new ArrayList<>(); // Stores all valid board configurations
	        char[][] board = new char[n][n]; // N x N chessboard

	        // Optimization: Arrays to track column and diagonal attacks  (no need to check all 8 directions Only three: upper-left diagonal, upper-right diagonal, and vertical above 
	        //(because we place queens column by column, left to right).)
	        
	        boolean[] cols = new boolean[n];           // Tracks occupied columns
	        boolean[] diag1 = new boolean[2 * n - 1];   // Tracks '\' diagonals (row - col + n - 1)
	        boolean[] diag2 = new boolean[2 * n - 1];   // Tracks '/' diagonals (row + col)

	        // Start backtracking from the first row
	        solve(0, board, allBoards, cols, diag1, diag2);
	        return allBoards; // Return all valid solutions
	    }

	    // Recursive backtracking function to place queens row by row
	    private void solve(int row, char[][] board, List<List<String>> res,
	                       boolean[] cols, boolean[] diag1, boolean[] diag2) {
	        int n = board.length;

	        // Base case: If all queens are placed, add the board to result
	        if (row == n) {
	            res.add(construct(board));
	            return;
	        }

	        // Try placing a queen in each column of the current row
	        for (int col = 0; col < n; col++) {
	            int d1 = row - col + n - 1; // Calculate index for '\' diagonal
	            int d2 = row + col;         // Calculate index for '/' diagonal

	            // If current position is under attack, skip it
	            if (cols[col] || diag1[d1] || diag2[d2]) continue;

	            // Place the queen and mark the attacks
	            board[row][col] = 'Q';
	            cols[col] = diag1[d1] = diag2[d2] = true;

	            // Recur to place queen in next row
	            solve(row + 1, board, res, cols, diag1, diag2);

	            // Backtrack: Remove the queen and unmark the attacks
	            board[row][col] = '\0'; // Reset cell (optional, for clarity)
	            cols[col] = diag1[d1] = diag2[d2] = false;
	        }
	    }

	    // Convert the board from 2D char array to a list of strings
	    private List<String> construct(char[][] board) {
	        List<String> result = new ArrayList<>();
	        for (char[] row : board) {
	            StringBuilder sb = new StringBuilder();
	            for (char cell : row) {
	                sb.append(cell == 'Q' ? 'Q' : '.'); // Fill '.' for empty and 'Q' for queen
	            }
	            result.add(sb.toString());
	        }
	        return result;
	    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter value of n: ");
	    int n = sc.nextInt();
	
	    Nqueens nq = new Nqueens();
	    List<List<String>> solutions = nq.solveNQueens(n);
	
	    System.out.println("Total solutions: " + solutions.size());
	    for (List<String> board : solutions) {
	        for (String row : board) {
	            System.out.println(row);
	        }
	        System.out.println("\n"); // Print an empty line between boards
	    }
	    
	    sc.close();
	    
	}
}

//Time Complexity: O(N!), since there are N choices at each row in the worst case.

//Space Complexity:
//O(N²) for the board,
//O(N) for cols, diag1, and diag2,
//plus output space for the results.