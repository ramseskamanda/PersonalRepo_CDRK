import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class GameOfLife {

	public Cell[][] grid;
	public int squaresize;
	public int numbrows;
	public int numbcols;
	
	public GameOfLife(int numbrows, int numbcols, int squaresize) {
		
		this.numbrows = numbrows;
		this.numbcols = numbcols;
        this.squaresize = squaresize;
		// init grid
		grid = new Cell[numbcols][numbrows];
		for (int i=0; i<numbcols; i++)
			for (int j=0; j<numbrows; j++)
				grid[i][j] = Cell.dead;
		// choose some initial configuration
		// multiple inits might interfere with the shape behavior
		initGlider();
		initSmallExploder();
		initTumbler();
	}

	public void advance() {
		Cell[][] newgrid = new Cell[grid.length][grid[0].length];
		
		for (int i=0; i<grid.length; i++)
			for (int j=0; j<grid[0].length; j++)
				newgrid[i][j] = Cell.dead;
		
		for (int i=0; i<grid.length; i++)
			for (int j=0; j<grid[0].length; j++) 
				if ((grid[i][j].state.isAlive()) && (nbrOfNeighbors(i,j) < 2))
					newgrid[i][j] = Cell.dead;
				else if ((grid[i][j].state.isAlive()) && (2 <= nbrOfNeighbors(i,j)) && (nbrOfNeighbors(i,j) <= 3))
					newgrid[i][j] = Cell.alive;
				else if ((grid[i][j].state.isAlive()) && (3 < nbrOfNeighbors(i,j)))
					newgrid[i][j] = Cell.dead;
				else if ((!grid[i][j].state.isAlive()) && (nbrOfNeighbors(i,j) == 3))
					newgrid[i][j] = Cell.alive;
		
		grid = newgrid;
	}

	private int nbrOfNeighbors(int x, int y) {
		int result = 0;
		if ((0 <= x-1) && (0 <= y-1) && (grid[x-1][y-1].state.isAlive())) result++;
		if ((0 <= x-1) && (grid[x-1][y].state.isAlive())) result++;
		if ((0 <= x-1) && (y+1 < grid[0].length) && (grid[x-1][y+1].state.isAlive())) result++;
		if ((0 <= y-1) && (grid[x][y-1].state.isAlive())) result++;
		if ((y+1 < grid[0].length) && (grid[x][y+1].state.isAlive())) result++;
		if ((x+1 < grid.length) && (0 <= y-1) && (grid[x+1][y-1].state.isAlive())) result++;
		if ((x+1 < grid.length) && (grid[x+1][y].state.isAlive())) result++;
		if ((x+1 < grid.length) && (y+1 < grid[0].length) && (grid[x+1][y+1].state.isAlive())) result++;
		return result;
	}

	private void initSmallExploder() {
		grid[30][31] = Cell.alive;
		grid[30][32] = Cell.alive;
		grid[31][30] = Cell.alive;
		grid[31][31] = Cell.alive;
		grid[31][33] = Cell.alive;
		grid[32][31] = Cell.alive;
		grid[32][32] = Cell.alive;
	}

	private void initGlider() {
		grid[21][20] = Cell.alive;
		grid[22][21] = Cell.alive;
		grid[22][22] = Cell.alive;
		grid[21][22] = Cell.alive;
		grid[20][22] = Cell.alive;
	}
	
	private void initTumbler() {
		grid[30][23] = Cell.alive;
		grid[30][24] = Cell.alive;
		grid[30][25] = Cell.alive;
		grid[31][20] = Cell.alive;
		grid[31][21] = Cell.alive;
		grid[31][25] = Cell.alive;
		grid[32][20] = Cell.alive;
		grid[32][21] = Cell.alive;
		grid[32][22] = Cell.alive;
		grid[32][23] = Cell.alive;
		grid[32][24] = Cell.alive;
		grid[34][20] = Cell.alive;
		grid[34][21] = Cell.alive;
		grid[34][22] = Cell.alive;
		grid[34][23] = Cell.alive;
		grid[34][24] = Cell.alive;
		grid[35][20] = Cell.alive;
		grid[35][21] = Cell.alive;
		grid[35][25] = Cell.alive;
		grid[36][23] = Cell.alive;
		grid[36][24] = Cell.alive;
		grid[36][25] = Cell.alive;
	}	
}

