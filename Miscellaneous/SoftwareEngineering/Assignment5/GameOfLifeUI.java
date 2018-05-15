import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class GameOfLifeUI extends JPanel {

	GameOfLife game;
	
	public GameOfLifeUI(GameOfLife game) {

        this.game = game;
        
        setPreferredSize(new Dimension(game.numbcols * game.squaresize, game.numbrows * game.squaresize));
		
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				toggleGridValue(e.getX(),e.getY());
			}
		});
	}

	protected void toggleGridValue(int x, int y) {
		int i = x / game.squaresize;
		int j = y / game.squaresize;
		this.game.grid[i][j].state.SetState(!this.game.grid[i][j].state.isAlive());
		repaint();
	}

	public void tick() {
		this.game.advance();
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		//draw background
		drawgrid(g2);
		
		//draw alive cells
		g2.setColor(Color.YELLOW);
		for (int i=0; i<game.grid.length; i++)
			for (int j=0; j<game.grid[0].length; j++) 
				if (game.grid[i][j].state.isAlive()) 
					g2.fill(
                        new Rectangle2D.Double(
                            i * game.squaresize + 1,
                            j*game.squaresize + 1,
                            game.squaresize - 1,
                            game.squaresize - 1
                        )
                    );
	}

	public void drawgrid(Graphics2D g2) {
		//fillbackground
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(getVisibleRect());
		//drawgrid
		g2.setColor(Color.GRAY);
		for (int i=0;i<=game.grid.length;i++)
			g2.drawLine(
                i * game.squaresize,
                0,
                i * game.squaresize,
                game.grid[0].length * game.squaresize
            );
		for (int i=0;i<=game.grid[0].length;i++)
			g2.drawLine(
                0,
                i * game.squaresize,
                game.grid.length * game.squaresize,
                i * game.squaresize
            );
	}	
}

