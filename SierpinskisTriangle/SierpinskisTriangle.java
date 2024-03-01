/*
 * A program that uses recursion to draw Sierpinski's Triangle.
 * Written By: Josue
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
public class SierpinskisTriangle extends Canvas
{
	public static final int HEIGHT = 500;
	public static final int WIDTH = 500;
	public static final int PADDING = 50;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(WIDTH, HEIGHT);

		SierpinskisTriangle st = new SierpinskisTriangle();

		frame.add(st);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g)
	{
		// This method is automatically called when the Canvas is first
		// displayed or needs to be redrawn.
		// You override it to specify what should be drawn on the canvas.

		// Initial Triangle:

		// Left Vertices (x1, y1) = (PADDING, HEIGHT - PADDING)
		// Right Vertices (x2, y2) = (WIDTH - PADDING, HEIGHT - PADDING)
		// Top Vertices (x3, y3) = (WIDTH / 2, PADDING)

		drawTriangle(PADDING, HEIGHT - PADDING,
				WIDTH - PADDING, HEIGHT - PADDING,
				WIDTH / 2, PADDING, g);
	}

	private void drawTriangle(int x1, int y1, int x2,
			int y2, int x3, int y3, Graphics g)
	{
		// calculate the height of the triangle
		int maxY = Math.max(y1, Math.max(y2, y3));
		int minY = Math.min(y1, Math.min(y2, y3));
		int triangleHeight = maxY - minY;

		// draw if Triangle height is <= 4 pixels
		if (triangleHeight <= 4)
		{
			int[] xPoints = {x1, x2, x3};
			int[] yPoints = {y1, y2, y3};

			g.setColor(Color.BLACK); // pick any color
			g.fillPolygon(xPoints, yPoints, 3);
		}

		else
		{
			// divide the triangle into three smaller triangles

			// left to right vertices
			int midx1 = (x1 + x2) / 2;
			int midy1 = (y1 + y2) / 2;
			// right to top vertices
			int midx2 = (x2 + x3) / 2;
			int midy2 = (y2 + y3) / 2;
			// top to left vertices
			int midx3 = (x1 + x3) / 2;
			int midy3 = (y1 + y3) / 2;

			// bottom left
			drawTriangle(x1, y1, midx1, midy1, midx3, midy3,
					g);
			// bottom right
			drawTriangle(midx1, midy1, x2, y2, midx2, midy2,
					g);
			// top
			drawTriangle(midx3, midy3, midx2, midy2, x3, y3,
					g);
		}
	}

}
