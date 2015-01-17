package p4_student;
/* IMPORTANT:  THIS CLASS HAS BEEN WRITTEN FOR YOU.  DO NOT MODIFY IT!
 * 
 * This driver displays a dialog box for the user to make choices about how 
 * they would like to display the QuadraticEquation.  It then creates the graph
 * displaying the QuadraticEquation using your implementation of the class
 * QuadraticEquation.
 */


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Main testing program for QuadraticEquation including simple UI for
 * entering coefficients and plotting the resulting QuadraticEquation
 * and derivative.
 * 
 * @author Ben Bederson, Evan Golub
 * @date March 2010, March 2013
 */

public class VisualPlotter {
	public static void main(String[] args) {
		GraphingFrame gFrame = new GraphingFrame();
		gFrame.createAndShowGUI();
	}
}

class GraphingFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField a = new JTextField();
	private JTextField b = new JTextField();
	private JTextField c = new JTextField();
	private CurveGrapher grapher = null;
	
	void createAndShowGUI() {
		setTitle("Visual Plotter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(600, 50));
		
		textPanel.add(new JLabel("Enter quadratic coefficients here.  a:"));
		a.setPreferredSize(new Dimension(100, 20));
		textPanel.add(a);
		textPanel.add(new JLabel("b:"));
		b.setPreferredSize(new Dimension(100, 20));
		textPanel.add(b);
		textPanel.add(new JLabel("c:"));
		c.setPreferredSize(new Dimension(100, 20));
		textPanel.add(c);
		textPanel.add(new JLabel(
				"Specified quadratic equation (a*x^2 + b*x + c) in red, " +
				"derivative in blue."));
		
		KeyListener textListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				double aNum = 0, bNum = 0, cNum = 0;
				try {
					aNum = Double.parseDouble(a.getText());
				} catch (Exception ex) {}				
				try {
					bNum = Double.parseDouble(b.getText());	
				} catch (Exception ex) {}				
				try {
					cNum = Double.parseDouble(c.getText());
				} catch (Exception ex) {}				
				grapher.updateQuadraticEquation(aNum, bNum, cNum);
			}
			public void keyTyped(KeyEvent e) {}
		};
		a.addKeyListener(textListener);
		b.addKeyListener(textListener);
		c.addKeyListener(textListener);
		
		grapher = new CurveGrapher();
		
		cp.add(textPanel, BorderLayout.NORTH);
		cp.add(grapher, BorderLayout.CENTER);

		this.setPreferredSize(new Dimension(600, 400));
		pack();
		setVisible(true);
	}
}

class CurveGrapher extends JPanel {
	private static final long serialVersionUID = 1L;
	private QuadraticEquation quad;
	
	public CurveGrapher() {
		quad = new QuadraticEquation();
	}
	
	public void updateQuadraticEquation(double a, double b, double c) {
		quad = new QuadraticEquation(
				new MyDouble(a), new MyDouble(b), new MyDouble(c));
		this.repaint();
	}

	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, w, h);
		
		// Plot axes
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(1));
		g2.drawLine(0, h/2, w, h/2);
		g2.drawLine(w/2, 0, w/2, h);
		
		// Draw QuadraticEquations
		g2.setColor(Color.red);
		plotQuadraticEquation(g2, quad);
		g2.setColor(Color.blue);
		plotQuadraticEquation(g2, quad.derivative());
	}

	// Draw specified QuadraticEquation in current color
	private void plotQuadraticEquation(Graphics2D g2, QuadraticEquation p) {
		int w = getWidth();
		int h = getHeight();
		GeneralPath path = new GeneralPath();
		boolean firstPoint = true;
		float minX = -100;
		float maxX = 100;
		for (float x = minX; x <= maxX; x++) {
			float y = (float)MyDoubleVal(p.evaluate(new MyDouble(x)));
			float xScale = w / (maxX - minX);
			float plotX = (x - minX) * xScale;
			float plotY = h/2 - y;
			if (firstPoint) {
				path.moveTo(plotX, plotY);
				firstPoint = false;
			} else {
				path.lineTo(plotX, plotY);
			}
		}
		g2.setStroke(new BasicStroke(2));
		g2.draw(path);		
	}
	
	private double MyDoubleVal(MyDouble d) {
		return Double.parseDouble(d.toString());
	}
}