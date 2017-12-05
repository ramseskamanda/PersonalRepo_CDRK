import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class LAB6{

	public static void main(String[] args) {
		JFrame f = new JFrame("Circle Maker");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 200);
		f.setLayout(new FlowLayout());
		CircleMaker c = new CircleMaker();
		TruckDrawer t = new TruckDrawer(f);
		//Label l = new Label("DRAW ANY CIRCLE YOU WANT!");
		//f.add(l);
		//f.add(c); //Assignement 1
		f.add(t); //Assignment 2
		f.setVisible(true);
	}
}

class CircleMaker extends JPanel{
	private static boolean previous_click;
	private static Point center;
	private static Point outter;
	private static int radius;

	public CircleMaker(){
		addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		    	if(!previous_click)
		    		center = e.getPoint();
		    	else outter = e.getPoint();
				previous_click = !previous_click;
				if(center != null && outter != null){
					radius = (int) Math.sqrt(Math.pow((outter.x - center.x), 2) + Math.pow((outter.y - center.y), 2));
					repaint();
				}
				System.out.println("Center: " + center);
				System.out.println("Outter: " + outter);
		    }
		});
	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		if(radius != 0){
			g.fillOval(center.x - radius, center.y - radius, radius*2, radius*2);
			center = null;
			outter = null;
			radius = 0;
		}
	}
}

class TruckDrawer extends JPanel{

	public TruckDrawer(JFrame frame){
		super();
		truckButton button = new truckButton("Start!");
		truckTextField text = new truckTextField("", 10);
		frame.add(text);
		frame.add(button);
	}

	class truckButton extends JButton{
		private int x;
		private int y;
		private int width;
		private int height;

		public truckButton(String label){
			super(label);
			addActionListener(new ClickListener());
		}

		@Override
		public void paintBorder(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.GREEN);
			g2d.setStroke(new BasicStroke(4.0f));
			g2d.drawRect(this.getX() - (this.getWidth() / 2) - 1, this.getY() - (this.getHeight() / 4) + 1, this.getWidth(), this.getHeight());
		}
	}

	class truckTextField extends JTextField{
		public truckTextField(String label, int columns){
			super(label, columns);
		}

		@Override
		public void paintBorder(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.GREEN);
			g2d.setStroke(new BasicStroke(4.0f));
			g2d.drawRect(this.getX() - (this.getWidth() / 2) - 1, this.getY() - (this.getHeight() / 4) + 1, this.getWidth(), this.getHeight());
		}
	}

	class ClickListener implements ActionListener{
		private int clicked;
		public void actionPerformed(ActionEvent event){
			clicked += 1;
			System.out.println("I was clicked " + clicked +" time(s)!");
		}
	}
}