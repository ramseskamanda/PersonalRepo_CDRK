import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ButtonViewer{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT =300;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		JButton button = new JButton("Click me!");
		JButton button2 = new JButton("No! Click me!");
		frame.add(button);
		frame.add(button2);
		ActionListener listener1 = new ClickListener();
		ActionListener listener2 = new ClickListener();
		button.addActionListener(listener1);
		button2.addActionListener(listener2);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ClickListener implements ActionListener{
	private int clicked;
	public void actionPerformed(ActionEvent event){
		clicked += 1;
		System.out.println("I was clicked " + clicked +" time(s)!");
	}
}