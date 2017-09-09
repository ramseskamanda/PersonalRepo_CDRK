import java.util.*;
import java.lang.Math;

public class MatrixTacToe{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double[][] nm = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		double[][] pq = {{1}, {2}, {3}};
		double[][] res = matmul(nm, pq);

		print_matrix(nm);
		System.out.println("----------");
		print_matrix(pq);
		System.out.println("----------");
		print_matrix(res);
		System.out.println("Start bonus game? 0=yes, 1=no");
		int Yn = in.nextInt();
		if(Yn == 0) bonus();
	}

	public static void print_matrix(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static double[][] matmul(double[][] a, double[][] b){
		if(a[0].length != b.length) return null;

	   int n = a[0].length;
	   int m = a.length;
	   int p = b[0].length;
	 
	   double ans[][] = new double[m][p];
	 
	   for(int i = 0;i < m;i++){
	      for(int j = 0;j < p;j++){
	         for(int k = 0;k < n;k++){
	            ans[i][j] += a[i][k] * b[k][j];
	          }
	       }
	   }
	   return ans;
	}

	public static void bonus(){
		double[][] game = init();
		int turn_counter = 0;
		while(true){
			int[] move = moves(turn_counter);
			boolean o = check_move(move, game);
			game = add_move(o, move, game);
			print_board(game);
			if(check_winning_condition(game)){
				System.out.println("Game Over.");
				break;
			}
			turn_counter+=1;
		}
	}

	public static void print_board(double[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print("|");
				if(board[i][j] != 0){
					System.out.print(board[i][j] + "|");
				} else {
					System.out.print(" |");
				}
			}
			System.out.println();
		}
	}

	public static double[][] init(){
		double[][] board = new double[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = 0;
			}
		}
		print_board(board);
		return board;
	}

	public static int[] moves(int counter){
		Scanner in = new Scanner(System.in);
		int x;
		int y;
		int type;
		while(true){
			System.out.println("Please enter coordinates between 0 and 2 for both x and y: ");
			x = in.nextInt();
			y = in.nextInt();
			if(x <= 2 && x >= 0 && y <= 2 && y >= 0) break;
		}
		int temp = x;
		x = y;
		y = temp;
		if(counter % 2 == 0){
			type = 2;
		} else {
			type = 1;
		}
		int[] coordinates = {x, y, type};
		return coordinates;
	}

	public static boolean check_move(int[] moves_to_check, double[][] board){
		if(board[moves_to_check[0]][moves_to_check[1]] > 0) return false;
		return true;
	}

	public static double[][] add_move(boolean b, int[] move,double[][] board){
		if(b){
			board[move[0]][move[1]] = move[2];
		} else {
			System.out.println("Invalid postion.");
			int[] new_coords = moves(move[2]);
			board[new_coords[0]][new_coords[1]] = new_coords[2];
		}
		return board;
	}

	public static boolean check_winning_condition(double[][] board){
		boolean straight = check_straight(board);
		boolean vertical = check_vertical(board);
		boolean diagonal = check_diagonals(board);
		if(diagonal || straight || vertical) return true;
		return false;
	}

	public static boolean check_straight(double[][] board){
		for(int type = 1; type < 3; type++){
			if(board[0][0] == type && board[0][1] == type && board[0][2] == type) return true;
			if(board[1][0] == type && board[1][1] == type && board[1][2] == type) return true;
			if(board[2][0] == type && board[2][1] == type && board[2][2] == type) return true;
		}
		return false;
	}

	public static boolean check_vertical(double[][] board){
		for(int type = 1; type < 3; type++){
			if(board[0][0] == type && board[1][0] == type && board[2][0] == type) return true;
			if(board[0][1] == type && board[1][1] == type && board[2][1] == type) return true;
			if(board[0][2] == type && board[1][2] == type && board[2][2] == type) return true;
		}
		return false;
	}

	public static boolean check_diagonals(double[][] board){
		for(int type = 1; type < 3; type++){
			if(board[0][0] == type && board[1][1] == type && board[2][2] == type) return true;
			if(board[0][2] == type && board[1][1] == type && board[2][0] == type) return true;
		}
		return false;
	}
}
