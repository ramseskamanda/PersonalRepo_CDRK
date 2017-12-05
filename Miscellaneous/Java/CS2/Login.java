import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Login extends JPanel{

	private static String username;
	private static String password;
	private static String user;
	private static int trials;

	public Login(JFrame frame){
		super();
		JTextField usernameField = new JTextField("Username");
		JTextField passwordField = new JTextField("Password");
		JButton button = new JButton("Login");
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(button);
		usernameField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				if(usernameField.getText().equals("Username"))
			    	usernameField.setText("");
			}

			public void focusLost(FocusEvent e) {
				if(usernameField.getText().equals(""))
					usernameField.setText("Username");
			}
		});
		passwordField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				username = usernameField.getText();
				password = passwordField.getText();
				verify();
			}
		});
		passwordField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals("Password"))
			    	passwordField.setText("");
			}

			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals(""))
					passwordField.setText("Password");
			}
		});
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				username = usernameField.getText();
				password = passwordField.getText();
				verify();
			}
		});
	}

	public static void verify(){
		String line;
		username = username.toLowerCase();
		user = username + " " + password;
		System.out.println("User: " + user);
		try{
			FileReader f = new FileReader("login_file.txt");
			BufferedReader b = new BufferedReader(f);
			while((line = b.readLine()) != null){
				if(line.equals(user)){
					showWelcomePage(username);
					return;
				}
			}
			trials += 1;
			if(trials >= 3)
				System.exit(0);
			showErrorMessage();
		} catch (IOException e){ System.out.println("File Not Found."); }
	}

	public static void showWelcomePage(String user){
		JFrame welcome = new JFrame("Welcome Page");
		welcome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		welcome.setSize(400, 400);
		welcome.setLayout(new FlowLayout());
		Label w = new Label("Welcome, " + username + "!");
		welcome.add(w);
		welcome.setVisible(true);
	}

	public static void showErrorMessage(){
		JFrame welcome = new JFrame("Error Page");
		welcome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		welcome.setSize(400, 400);
		welcome.setLayout(new FlowLayout());
		Label w = new Label("Password or username is incorrect!");
		JButton b = new JButton("O.K.");
		b.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ welcome.dispose(); } });
		welcome.add(w);
		welcome.add(b);
		welcome.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Login Page");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 400);
		f.setLayout(new FlowLayout());
		Login l = new Login(f);
		f.add(l);
		f.setVisible(true);
	}
}