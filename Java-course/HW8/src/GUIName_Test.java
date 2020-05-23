import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIName_Test {

	public static void main(String[] args) {
		new GUIStuInfo();
	}
}

class GUIStuInfo extends JFrame {
	public GUIStuInfo() {
		this.setTitle("My Info");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - getSize().width) / 2, (screenSize.height - getSize().height) / 2);
		this.setVisible(true);
		this.setResizable(false);

		add(new Canvas());
		validate();
	}
}

class Canvas extends JPanel {
	public Canvas() {
		setBackground(Color.LIGHT_GRAY);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(Color.blue);
		g.drawString("董传林" + "\t201523004" + "\n经济1501", 100, 100);

	}

}