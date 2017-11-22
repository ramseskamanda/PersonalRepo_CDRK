import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class LAB4{

	public static void showHouseAssignment(){
		JFrame f = new JFrame("LAB4");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000, 2000);
		House h = new House(100, 100);
		f.add(h);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		OlympicRingViewer BHITS = new OlympicRingViewer();
		BHITS.showUsWhatYouveGot();
	}
}


class House extends JComponent{
	private int base_x;
	private int base_y;
	
	public House(int base_x, int base_y){
		super();
		this.base_x = base_x;
		this.base_y = base_y;
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.drawRect(base_x, base_y, 150, 200);
		g2.drawRect(base_x+25, base_y+50, 20, 100);
		g2.drawRect(base_x+75, base_y+25, 10, 25);
		g2.drawRect(base_x+90, base_y+150, 30, 50);
		drawTriangle(g2, base_x, base_y, 150, 75);
	}

	public void drawTriangle(Graphics2D g2, int x, int y, int w, int h){
		g2.drawLine(x+w, y, x+(w/2), y-h);
		g2.drawLine(x, y, x+(w/2), y-h);
	}
}

class OlympicRingViewer{
	JFrame f;

	public OlympicRingViewer(){
		f = new JFrame("Olympic Rings");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000, 2000);
		OlympicRingComponent OR = new OlympicRingComponent(50, 50);
		f.add(OR);		
	}

	public void showUsWhatYouveGot(){
		f.setVisible(true);
	}
}

class OlympicRingComponent extends JComponent{
	int base_x;
	int base_y;

	public OlympicRingComponent(int x, int y){
		super();
		base_x = x;
		base_y = y;
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(8.0f));
		drawRing(g2, base_x, base_y, Color.BLUE);
		drawRing(g2, base_x*3, base_y, Color.BLACK);
		drawRing(g2, base_x*5, base_y, Color.RED);
		drawRing(g2, base_x*2, base_y*2, Color.YELLOW);
		drawRing(g2, base_x*4, base_y*2, Color.GREEN);		
	}

	public void drawRing(Graphics2D g2, int x, int y, Color c){
		g2.setColor(c);
		g2.drawOval(x, y, 100, 100);
	}
}