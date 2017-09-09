import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class MineSweeper {

	public static void main(String[] args) {
		
		final int HEIGHT = 10;
		final int WIDTH = 10;
		MineSweeperWindow window = new MineSweeperWindow(HEIGHT,WIDTH);
		
		int[][] board = makeBoard(HEIGHT,WIDTH);
		boolean[][] open = new boolean[HEIGHT][WIDTH];

		computeHints(board);
		
		boolean alive = true;
		while (alive) {
			window.printBoard(board,open);
			int[] move = window.getMove();
			alive = clicked(move[0],move[1],board,open);
		}
		window.printBoard(board,open);
		System.out.println("End of the game.");
	}
	
	public static int[][] makeBoard(int height, int width) {
		int[][] board = new int[height][width];
		int[] height_rand = new int[10];
		int[] width_rand = new int[10];
		int a;
		int b;
		for(int i = 0; i < 10; i++){
			a = ThreadLocalRandom.current().nextInt(0, height);
			b = ThreadLocalRandom.current().nextInt(0, width);
			height_rand[i] = a;
			width_rand[i] = b;
		}
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				board[y][x] = 0;
			}
		}
		for(int j = 0; j < height_rand.length; j++){
			board[height_rand[j]][width_rand[j]] = 9;
		}

	    return board;
	}
	
	public static void computeHints(int[][] array) {
	    int[][] neighbors;
	    int value = 0;
	    for(int i = 0; i < array.length; i++){
	    	for(int j = 0; j < array.length; j++){
	    		if(array[i][j] != 9){
	    			neighbors = check_neighbors(array, i, j);
	    			for(int k = 0; k < neighbors.length; k++){
	    				if(neighbors[k][0] == 9) value++;
	    			}
	    			array[i][j] = value;
	    			value = 0;
	    		}
	    	}
	    }
	}

	public static int[][] check_neighbors(int[][] array, int i, int j){
		int t_l, t_c, t_r, c_l, c_r, b_l, b_c, b_r;
		t_l = t_c = t_r = c_l = c_r = b_l = b_c = b_r = -1;
		int l = array[0].length-1;

		if(i-1 >= 0 && j-1 >= 0) t_l = array[i-1][j-1];
		if(i-1 >= 0) t_c = array[i-1][j];
		if(i-1 >= 0 && j+1 <= l) t_r = array[i-1][j+1];
		if(j-1 >= 0) c_l = array[i][j-1];
		if(j+1 <= l) c_r = array[i][j+1];
		if(i+1 <= l && j-1 >= 0) b_l = array[i+1][j-1];
		if(i+1 <= l) b_c = array[i+1][j];
		if(i+1 <= l && j+1 <= l) b_r = array[i+1][j+1];
		int[][] neighbors = {{t_l, i-1, j-1}, {t_c, i-1, j}, {t_r, i-1, j+1}, {c_l, i, j-1}, {c_r, i, j+1}, {b_l, i+1, j-1}, {b_c, i+1, j}, {b_r, i+1, j+1}};
		return neighbors;
	}

	public static boolean clicked(int y, int x, int[][] board, boolean[][] open) {
		//This should also open all the empty spaces related to the empty box being open
		//but I couldn't figure out why my recursion wasn't being called and I was tired
		//So I left it the way it is. It can still open all the empty squares around the
		//one being open.
		int new_x, new_y;
		new_x = new_y = 0;
		if(!open[y][x]){
			open[y][x] = true;
			if(board[y][x] == 9) return false;
			if(board[y][x] > 0 && board[y][x] < 9) return true;
			int[][] neighbors = check_neighbors(board, x, y);
			for(int i = 0; i < neighbors.length; i++){
				if(neighbors[i][0] >= 0 && neighbors[i][0] < 9){
					new_x = neighbors[i][2];
					new_y = neighbors[i][1];
					open[new_x][new_y] = true;
					clicked(new_x, new_y, board, open);
				}
			}
		}
		return true;
	}
}
