import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter extends JPanel{

	public static final double EURO2DOLLAR = 1.18;
	public static final double EURO2POUND = 0.88;
	public static final double POUND2DOLLAR = 1.32;
	public static final double POUND2EURO = 1.13;
	public static final double DOLLAR2EURO = 0.84;
	public static final double DOLLAR2POUND = 0.75;
	public static double amount;
	public static int transaction_id;
	public static Label result = new Label();

	public Converter(JFrame frame){
		super();
		JComboBox dropdown = new JComboBox(new String[]{
			"Select conversion rate",
			 "Euro to Dollar",
			 "Euro to Pound",
			 "Pound to Dollar",
			 "Pound to Euro",
			 "Dollar to Pound",
			 "Dollar to Euro"});
		JTextField text = new JTextField("Insert Amount Here.");
		JButton button = new JButton("Convert!");
		frame.add(text);		
		frame.add(dropdown);
		frame.add(button);
		frame.add(result);
		dropdown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = (String) dropdown.getSelectedItem();
				switch(s){
					case "Select conversion rate": transaction_id = 0; break;
					case "Euro to Dollar": transaction_id = 1; break;
					case "Euro to Pound": transaction_id = 2; break;
					case "Pound to Dollar": transaction_id = 3; break;
					case "Pound to Euro": transaction_id = 4; break;
					case "Dollar to Euro": transaction_id = 5; break;
					case "Dollar to Pound": transaction_id = 6; break;
				}
			}
		});
		text.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String a = text.getText();
					amount = Double.parseDouble(a);
				} catch(Exception ex) {showErrorMessage("Invalid amount entered.");}
				convert(transaction_id);
			}
		});
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				try{
					String a = text.getText();
					amount = Double.parseDouble(a);
				} catch(Exception ex) {showErrorMessage("Invalid amount entered.");}
				convert(transaction_id);
			}
		});
	}

	public static void showErrorMessage(String message){
		JFrame error = new JFrame("Error!");
		error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		error.setLayout(new FlowLayout());
		error.setSize(400, 300);
		Label e = new Label("Invalid Operation: " + message);
		JButton close = new JButton("O.K.");
		error.add(e);
		error.add(close);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				error.dispose();
			}
		});
		error.setVisible(true);
	}

	public static void showResult(int transaction_id){
		switch(transaction_id){
			case 1: result.setText(String.valueOf(amount) + " U.S. Dollars"); break;
			case 2: result.setText(String.valueOf(amount) + " British Pounds"); break;
			case 3: result.setText(String.valueOf(amount) + " U.S. Dollars"); break;
			case 4: result.setText(String.valueOf(amount) + " Euros"); break;
			case 5: result.setText(String.valueOf(amount) + " Euros"); break;
			case 6: result.setText(String.valueOf(amount) + " British Pounds"); break;
		}
	}

	public static void convert(int transaction_id){
		switch(transaction_id){
			case 0: showErrorMessage("Invalid conversion rate."); break;
			case 1: {amount*=EURO2DOLLAR; showResult(transaction_id); amount = 0; break;}
			case 2: {amount*=EURO2POUND; showResult(transaction_id); amount = 0; break;}
			case 3: {amount*=POUND2DOLLAR; showResult(transaction_id); amount = 0; break;}
			case 4: {amount*=POUND2EURO; showResult(transaction_id); amount = 0; break;}
			case 5: {amount*=DOLLAR2EURO; showResult(transaction_id); amount = 0; break;}
			case 6: {amount*=DOLLAR2POUND; showResult(transaction_id); amount = 0; break;}
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Currency Converter");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(700, 100);
		f.setLayout(new GridLayout());
		Converter c = new Converter(f);
		f.add(c);
		f.setVisible(true);
	}
}