import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorFrame();
	}

}

class CalculatorFrame extends JFrame {

	public CalculatorFrame() {
		setTitle("Chauncy's Calculator");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 文字框
		JTextField display = new JTextField();
		display.setHorizontalAlignment(JTextField.RIGHT);// 使文字框内文字右对齐
		display.setEditable(false);// 使文字框不能输入
		this.add(display, BorderLayout.NORTH);
		//this.可写可不写
		// Frame默认的layout就是borderlayout，所以不用setLayout(new BorderLayout());

		
		// 造一个button数组，数组部分可以循环造
		JButton num[] = new JButton[16];
		for (int i = 0; i <= 9; ++i) {
			num[i] = new JButton("" + i);
		}
		num[10] = new JButton("+");
		num[11] = new JButton("-");
		num[12] = new JButton("*");
		num[13] = new JButton("/");
		num[14] = new JButton(".");
		num[15] = new JButton("=");

		// 把button都放入numPad，然后numpad作为整体，放在center
		JPanel numPad = new JPanel();
		numPad.setLayout(new GridLayout(4, 4));
		numPad.add(num[7]);
		numPad.add(num[8]);
		numPad.add(num[9]);
		numPad.add(num[13]);
		numPad.add(num[4]);
		numPad.add(num[5]);
		numPad.add(num[6]);
		numPad.add(num[12]);
		numPad.add(num[1]);
		numPad.add(num[2]);
		numPad.add(num[3]);
		numPad.add(num[11]);
		numPad.add(num[0]);
		numPad.add(num[14]);
		numPad.add(num[15]);
		numPad.add(num[10]);
		this.add(numPad, BorderLayout.CENTER);

		// 实现 按按键显示在text bar
		
//		for (int i = 0; i <= num.length; ++i) {// 是< length而不是<=
//			num[i].addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					String s = e.getActionCommand();
//					display.setText(display.getText() + s);// 此步实现按多少显示多少，而不是按一个上一个消失
//				}
//			});
//		}

		//Lambda Expression
		for (int i = 0; i <= num.length; ++i)
			num[i].addActionListener(e -> {
				String s = e.getActionCommand();
				display.setText(display.getText() + s);
			});
		
		validate();

		pack();// **********自动大小，不用自己设置了
	}
	
	
//
//	class ArithmaticListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			super(display);
//			
//			start = true;
//			String command = e.getActionCommand();
//			double x = Double.parseDouble(display.getText());
//			if (lastCommand.equals("+"))
//				result += x;
//			else if (lastCommand.equals("-"))
//				result -= x;
//			else if (lastCommand.equals("*"))
//				result *= x;
//			else if (lastCommand.equals("/"))
//				result /= x;
//			else if (lastCommand.equals("="))
//				result = x;
//			display.setText("" + result);
//			lastCommand = command;
//
//		}
//
//	}

}