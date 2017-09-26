package calculatorMain;
/* Created a Simple Calculator with a running digital clock using Java Swing */
/* By Glenn Nelson*/

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.applet.Applet;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MyCalculator extends Applet{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5422239548345251140L;
	private JFrame frame;
private JLabel lblClock;
private String suffix;
private JTextField textField;
int firstNum;
int secondNum;
int result;
String operations;
String answer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCalculator window = new MyCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//sets the clock 
	public void clock(){
		
		Thread clock = new Thread(){
		public void run(){
			try {
				//creates an endless loop so the time will stay current
				while(true){
				//gets the current time
				Calendar t = new GregorianCalendar();
				int hourOfDay = t.get(Calendar.HOUR_OF_DAY);
				int hour = t.get(Calendar.HOUR);
				
				int minute = t.get(Calendar.MINUTE);
				int second = t.get(Calendar.SECOND);
				if(hourOfDay == 0){
					hourOfDay = 12;
				}
				if(hourOfDay <= 12){
					suffix = "AM";
				}else{
					suffix = "PM";
				}				
				//sets the current time into the calculator
				lblClock.setText( hour + ":" + minute + ":" + second +" "+ suffix);
				
				sleep(1000);
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		
		}
	};
		
	clock.start();
	}
	/**
	 * Create the application.
	 */
	public MyCalculator() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 303, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 lblClock = new JLabel("Clock");
		 lblClock.setBackground(Color.RED);
		 lblClock.setForeground(Color.WHITE);
		lblClock.setBounds(207, 11, 70, 30);
		frame.getContentPane().add(lblClock);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(41, 60, 188, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton backbtn = new JButton("<-");
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String backspace = null;
				if(textField.getText().length() >0){
					StringBuilder st = new StringBuilder(textField.getText());
					st.deleteCharAt(textField.getText().length() -1);
					backspace = st.toString();
					textField.setText(backspace);
					
				}
			}
		});
		backbtn.setBounds(41, 91, 50, 34);
		frame.getContentPane().add(backbtn);
		
		JButton clearbtn = new JButton("C");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		clearbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		clearbtn.setBackground(Color.BLACK);
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBounds(101, 91, 50, 34);
		frame.getContentPane().add(clearbtn);
		
		JButton percentbtn = new JButton("%");
		percentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Integer.parseInt(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		percentbtn.setForeground(Color.WHITE);
		percentbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		percentbtn.setBackground(Color.BLACK);
		percentbtn.setBounds(163, 91, 50, 34);
		frame.getContentPane().add(percentbtn);
		
		JButton button_7_1 = new JButton("7");
		button_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String EnterNumber = textField.getText() + button_7_1.getText();
				textField.setText(EnterNumber);
			}
		});
		button_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7_1.setBackground(Color.BLACK);
		button_7_1.setForeground(Color.WHITE);
		button_7_1.setBounds(41, 138, 50, 34);
		frame.getContentPane().add(button_7_1);
		
		JButton button_8_1 = new JButton("8");
		button_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_8_1.getText();
				textField.setText(EnterNumber);
			}
		});
		button_8_1.setForeground(Color.WHITE);
		button_8_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_8_1.setBackground(Color.BLACK);
		button_8_1.setBounds(101, 138, 49, 34);
		frame.getContentPane().add(button_8_1);
		
		JButton button_9_1 = new JButton("9");
		button_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_9_1.getText();
				textField.setText(EnterNumber);
			}
		});
		button_9_1.setBackground(Color.BLACK);
		button_9_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_9_1.setForeground(Color.WHITE);
		button_9_1.setBounds(163, 136, 49, 36);
		frame.getContentPane().add(button_9_1);
		
		JButton addbtn = new JButton("+");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Integer.parseInt(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		addbtn.setBackground(Color.BLACK);
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		addbtn.setForeground(Color.WHITE);
		addbtn.setBounds(228, 91, 49, 36);
		frame.getContentPane().add(addbtn);
		
		JButton minusbtn = new JButton("-");
		minusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Integer.parseInt(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		minusbtn.setForeground(Color.WHITE);
		minusbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		minusbtn.setBackground(Color.BLACK);
		minusbtn.setBounds(228, 136, 49, 36);
		frame.getContentPane().add(minusbtn);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_6.getText();
				textField.setText(EnterNumber);
			}
			
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(41, 186, 50, 34);
		frame.getContentPane().add(button_6);
		
		JButton button_5_1 = new JButton("5");
		button_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_5_1.getText();
				textField.setText(EnterNumber);
			}
		});
		button_5_1.setForeground(Color.WHITE);
		button_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5_1.setBackground(Color.BLACK);
		button_5_1.setBounds(101, 186, 50, 34);
		frame.getContentPane().add(button_5_1);
		
		JButton button_4_1 = new JButton("4");
		button_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_4_1.getText();
				textField.setText(EnterNumber);
			}
		});
		button_4_1.setForeground(Color.WHITE);
		button_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4_1.setBackground(Color.BLACK);
		button_4_1.setBounds(163, 186, 50, 34);
		frame.getContentPane().add(button_4_1);
		
		JButton multbtn = new JButton("*");
		multbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Integer.parseInt(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		multbtn.setForeground(Color.WHITE);
		multbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		multbtn.setBackground(Color.BLACK);
		multbtn.setBounds(227, 186, 50, 34);
		frame.getContentPane().add(multbtn);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_3.getText();
				textField.setText(EnterNumber);
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(41, 231, 50, 34);
		frame.getContentPane().add(button_3);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_2.getText();
				textField.setText(EnterNumber);
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(101, 231, 50, 34);
		frame.getContentPane().add(button_2);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button_1.getText();
				textField.setText(EnterNumber);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(163, 231, 50, 34);
		frame.getContentPane().add(button_1);
		
		JButton dividebtn = new JButton("/");
		dividebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Integer.parseInt(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		dividebtn.setForeground(Color.WHITE);
		dividebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		dividebtn.setBackground(Color.BLACK);
		dividebtn.setBounds(227, 231, 50, 34);
		frame.getContentPane().add(dividebtn);
		
		JButton button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + button0.getText();
				textField.setText(EnterNumber);
				
			}
		});
		button0.setForeground(Color.WHITE);
		button0.setFont(new Font("Tahoma", Font.BOLD, 14));
		button0.setBackground(Color.BLACK);
		button0.setBounds(41, 276, 50, 34);
		frame.getContentPane().add(button0);
		
		JButton decimalbtn = new JButton(".");
		decimalbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + decimalbtn.getText();
				textField.setText(EnterNumber);
				
			}
		});
		decimalbtn.setForeground(Color.WHITE);
		decimalbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		decimalbtn.setBackground(Color.BLACK);
		decimalbtn.setBounds(101, 276, 50, 34);
		frame.getContentPane().add(decimalbtn);
		
		JButton positivenegativebtn = new JButton("+ -");
		positivenegativebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = ops *(-1);
				textField.setText(String.valueOf(ops));
			}
		});
		positivenegativebtn.setForeground(Color.WHITE);
		positivenegativebtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		positivenegativebtn.setBackground(Color.BLACK);
		positivenegativebtn.setBounds(163, 276, 50, 34);
		frame.getContentPane().add(positivenegativebtn);
		
		JButton equalsbtn = new JButton("=");
		equalsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//performs the calculations and prints the result in Integer format
				String answer;
				secondNum = Integer.parseInt(textField.getText());
				if(operations == "+")
				{
					result = firstNum + secondNum;
					answer = String.format("%d", result);
					textField.setText(answer);
					
				}else if(operations == "-")
				{
					result = firstNum - secondNum;
					answer = String.format("%d", result);
					textField.setText(answer);
				}else if(operations == "*")
				{
					result = firstNum * secondNum;
					answer = String.format("%d", result);
					textField.setText(answer);
				}else if(operations == "/")
				{
					result = firstNum / secondNum;
					answer = String.format("%d", result);
					textField.setText(answer);
				}else if(operations == "%")
				{
					result = firstNum * secondNum/100;
					answer = String.format("%d", result);
					textField.setText(answer);
				}
			}
		});
		equalsbtn.setForeground(Color.WHITE);
		equalsbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		equalsbtn.setBackground(Color.BLACK);
		equalsbtn.setBounds(227, 276, 50, 34);
		frame.getContentPane().add(equalsbtn);
	}
}
