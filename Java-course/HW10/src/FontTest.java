
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class FontTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FontFrame()	;

	}

}

class FontFrame extends JFrame{
	int currentSize = 20;
	JLabel display;
	public FontFrame() {
		setTitle("Font Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		display = new JLabel("The quick brown fox jumps over the lazy dog.", JLabel.CENTER);
		//已经在FontFrame的fields说了display，所以没有再说JLabel的display了
		display.setFont(new Font("Serif", Font.PLAIN, currentSize));
		add(display, BorderLayout.CENTER);
		
		JPanel btnP = new JPanel();
		JPanel btnP1 = new JPanel();
		JPanel btnP2 = new JPanel();
		add(btnP, BorderLayout.SOUTH);
		btnP.setLayout(new BorderLayout());
		
		JCheckBox bold = new JCheckBox("Bold");
		JCheckBox italic = new JCheckBox("Italic");
		bold.addActionListener(e -> {
			setFont(bold.isSelected(), italic.isSelected(),currentSize);
//			另一种方法如下
//			if (bold.isSelected())
//				display.setFont(new Font("Serif", Font.BOLD, currentSize));
//			else 
//				display.setFont(new Font("Serif", Font.PLAIN, currentSize));
		});
		italic.addActionListener(e -> {
			setFont(bold.isSelected(), italic.isSelected(),currentSize);
		});
		btnP1.add(bold);
		btnP1.add(italic);
		btnP.add(btnP1, BorderLayout.NORTH);
		
		JRadioButton small = new JRadioButton("Small");
		JRadioButton medium = new JRadioButton("medium");
		JRadioButton large = new JRadioButton("Large");
		btnP2.add(small);
		btnP2.add(medium);
		btnP2.add(large);
		btnP.add(btnP2, BorderLayout.SOUTH);
		ButtonGroup bg = new ButtonGroup();
		bg.add(small);
		bg.add(large);
		bg.add(medium);
		
		small.addActionListener(e ->{
			setFont(bold.isSelected(), italic.isSelected(),10);
			currentSize = 10;
		});
		
		medium.addActionListener(e ->{
			setFont(bold.isSelected(), italic.isSelected(),20);
			currentSize = 20;
		});
		
		large.addActionListener(e ->{
			setFont(bold.isSelected(), italic.isSelected(),30);
			currentSize = 30;
		});
		

		pack();
		validate();
	}
	
	void setFont(boolean isBold, boolean isItalic, int size){
		int mode = Font.PLAIN;
		if(isBold)
			mode +=Font.BOLD;
		if(isItalic)
			mode +=Font.ITALIC;
		display.setFont(new Font("Serif", mode, size));
		//这里用到了display的setfont函数，所以之前要声明display的类型
	}
	
}
