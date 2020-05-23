import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorFrame();
	}

}

class CalculatorFrame extends JFrame{
	
	public CalculatorFrame() {
		setTitle("Chauncey's Calculator");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTextField display = new JTextField();
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		add(display,BorderLayout.NORTH);
		
		JButton num[] = new JButton[10];
		for(int i = 0; i<=9 ; ++i)
			num[i] = new JButton(i+"");
		
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton mul = new JButton("*");
		JButton div = new JButton("/");
		JButton point = new JButton(".");
		JButton equ = new JButton("=");
		
		JPanel numPad = new JPanel();
		numPad.setLayout(new GridLayout(4, 4));
		numPad.add(num[7]);
		numPad.add(num[8]);
		numPad.add(num[9]);
		numPad.add(minus);
		numPad.add(num[4]);
		numPad.add(num[5]);
		numPad.add(num[6]);
		numPad.add(div);
		numPad.add(num[1]);
		numPad.add(num[2]);
		numPad.add(num[3]);
		numPad.add(mul);
		numPad.add(num[0]);
		numPad.add(point);
		numPad.add(equ);
		numPad.add(plus);		
		add(numPad,BorderLayout.CENTER);
		pack();
		validate();
		
		for (int i=0; i<num.length; ++i) {
			num[i].addActionListener(e ->);
		}
		
	}
	
}