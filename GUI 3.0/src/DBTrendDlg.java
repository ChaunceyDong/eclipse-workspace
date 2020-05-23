import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DBTrendDlg extends JDialog {

	public DBTrendDlg(double[] data) {
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Plot_Trend");
		add(new Canvas(data), BorderLayout.CENTER);
	}
}

class Canvas extends JPanel {
	double[] data;

	Canvas(double[] data) {
		this.data = data;
		System.out.println(Arrays.toString(data));
	}

	public void paintComponent(Graphics g) {
		System.out.println("--");
		super.paintComponent(g);
		g.translate(0, this.getHeight());

		int xUnit = getWidth() / (data.length - 1);
		data = scale(data);
		System.out.println(Arrays.toString(scale(data)));

		for (int i = 0; i < data.length - 1; ++i) {
			g.drawLine(xUnit * i, -(int) data[i], xUnit * (i + 1), -(int) data[i + 1]);
		}
	}

	private double[] scale(double[] data) {
		double max = data[0];

		for (double i : data) {
			if (i > max)
				max = i;
		}
		for (int i = 0; i < data.length; ++i) {
			data[i] = data[i] / max * 0.9 * getHeight();
		}
		return data;
	}

}
