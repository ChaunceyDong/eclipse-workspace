import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;

public class MenuTest {

	public static void main(String[] args) {
		new MenuFrame();
	}
}
class MenuFrame extends JFrame{
	int currentSize = 20;
	int currentMode = Font.PLAIN;
	
	public MenuFrame() {
		setTitle("Menu Test");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel display = new JLabel("The quick brown fox jumps over the lazy dog.", JLabel.CENTER);
		add(display,BorderLayout.CENTER);
		display.setFont(new Font("Serif", currentMode, currentSize));
		
		JMenuBar mnuBar = new JMenuBar();
		setJMenuBar(mnuBar);
		
		
		//1 input
		JMenu inputm = new JMenu("input");
		mnuBar.add(inputm);
		JMenuItem newItem = new JMenuItem("new");
		inputm.add(newItem);
		
		newItem.addActionListener(e ->{
			String inputText = JOptionPane.showInputDialog("Type here");
			if(inputText!=null) display.setText(inputText);
		});
		
		
		//2:edit-color(red green blue)/font
		JMenu editMenu = new JMenu("edit");
		mnuBar.add(editMenu);
		
		//2.1:color
		JMenu colorItem = new JMenu("color");
		
		JMenuItem redItem = new JMenuItem("red");
		JMenuItem greenItem = new JMenuItem("green");
		JMenuItem blueItem = new JMenuItem("blue");
		
		colorItem.add(redItem);
		colorItem.add(greenItem);
		colorItem.add(blueItem);
		editMenu.add(colorItem);
		
		redItem.addActionListener(e ->{
			display.setForeground(Color.red);
		});
		greenItem.addActionListener(e ->{
			display.setForeground(Color.green);
		});
		blueItem.addActionListener(e ->{
			display.setForeground(Color.blue);
		});
		
		//2.2 font
		JMenu fontMenu = new JMenu("font");
		editMenu.add(fontMenu);
		
		//2.21 2.22
		JCheckBoxMenuItem boldItem = new JCheckBoxMenuItem("bold");
		JCheckBoxMenuItem italicItem = new JCheckBoxMenuItem("italic");
		fontMenu.add(italicItem);
		fontMenu.add(boldItem);
		
		ActionListener font = e -> {
			int mode = 0;
			if (boldItem.isSelected())
				mode += Font.BOLD;
			if (italicItem.isSelected())
				mode += Font.ITALIC;
			display.setFont(new Font("Serif", mode, currentSize));
			currentMode = mode;
		};
		
		boldItem.addActionListener(font);
		italicItem.addActionListener(font);
		
		//2.23-2.25  大小
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButtonMenuItem smallItem = new JRadioButtonMenuItem("small");
		JRadioButtonMenuItem mediumItem = new JRadioButtonMenuItem("medium");
		JRadioButtonMenuItem largeItem = new JRadioButtonMenuItem("large");
		bg.add(smallItem);
		bg.add(mediumItem);
		bg.add(largeItem);
		
		fontMenu.add(smallItem);
		fontMenu.add(mediumItem);
		fontMenu.add(largeItem);
		
		smallItem.addActionListener(e ->{
			display.setFont(new Font("Serif", currentMode, 10));
			currentSize = 10;			
		});
		mediumItem.addActionListener(e ->{
			display.setFont(new Font("Serif", currentMode, 20));
			currentSize = 20;			
		});
		largeItem.addActionListener(e ->{
			display.setFont(new Font("Serif", currentMode, 30));
			currentSize = 30;			
		});
		
		//tool bar
		JToolBar tb = new JToolBar();
		add(tb,BorderLayout.NORTH);
		
		JButton btnRed = new JButton(new ImageIcon("red-ball.gif"));
		tb.add(btnRed);
		btnRed.addActionListener(e ->{
			display.setForeground(Color.red);
		});
		JButton btnGreen = new JButton(new ImageIcon("green-ball.gif"));
		tb.add(btnGreen);
		btnGreen.addActionListener(e ->{
			display.setForeground(Color.green);
		});
		JButton btnBlue = new JButton(new ImageIcon("blue-ball.gif"));
		tb.add(btnBlue);
		btnBlue.addActionListener(e ->{
			display.setForeground(Color.blue);
		});
		
		pack();
		validate();
	} 
}
