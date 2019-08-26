/**
 * Simple Turtle library
 * Version 1.0 - 2016.08.24
 * @author Davide Fossati <davide@fossati.us>
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Turtle {

	public Turtle() {
		if (world == null) {
			initWorld(800, 600);
		}
		if (allTurtles == null) {
			allTurtles = new ArrayList<Turtle>();
		}
		allTurtles.add(this);
		x = world.width / 2;
		y = world.height / 2;
		dir = 0;
		turtleColor = Color.WHITE;
		delay = 100;
		turtleVisible = true;
		penDown = true;
	}

	private void initWorld(int width, int height) {
		JFrame worldFrame = new JFrame();
		worldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		world = new PaintArea(width, height);
		worldFrame.add(world);
		worldFrame.pack();
		worldFrame.setVisible(true);
	}

	/*
	 * Moves the turtle forward.
	 * @param steps the distance traveled by the turtle (1 step = 1 pixel)
	 */
	public void forward(double steps) {
		double x0 = x;
		double y0 = y;
		x += steps * Math.cos(dir);
		y -= steps * Math.sin(dir);
		if (penDown) {
			world.drawLine(x0, y0, x, y, turtleColor);
		}
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		world.repaint();
	}
	
	/*
	 * Moves the turtle backward.
	 * @param steps the distance traveled by the turtle (1 step = 1 pixel)
	 */
	public void backward(double steps) {
		forward(-steps);
	}

	/*
	 * Rotates the turtle counter-clockwise.
	 * @param degrees the rotation angle (in degrees)
	 */
	public void left(double degrees) {
		dir += degrees * Math.PI / 180;
		double pi2 = 2 * Math.PI;
		while (dir >= pi2) {
			dir -= pi2;
		}
		while (dir < 0) {
			dir += pi2;
		}
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		world.repaint();
	}

	/*
	 * Rotates the turtle clockwise.
	 * @param degrees the rotation angle (in degrees)
	 */
	public void right(double degrees) {
		left(-degrees);
	}
	
	/*
	 * Raises the turtle's pen. When the pen is up, the turtle does not draw lines on the screen.
	 */
	public void penup() {
		penDown = false;
	}
	
	/*
	 * Lowers the turtle's pen. When the pen is down, the turtle draws lines on the screen.
	 */
	public void pendown() {
		penDown = true;
	}
	
	/*
	 * Sets the turtle's delay between moves. The lower the delay, the faster the turtle. Default: 100 ms
	 * @param delay the amount of delay (in milliseconds)
	 */
	public void delay(int delay) {
		this.delay = delay;
	}
	
	/*
	 * Hides the turtle so it is not visible on the screen.
	 */
	public void hideturtle() {
		turtleVisible = false;
		world.repaint();
	}
	
	/*
	 * Shows the turtle so it is visible on the screen.
	 */
	public void showturtle() {
		turtleVisible = true;
		world.repaint();
	}
	
	/*
	 * Sets the color of the turtle.
	 * @param color a string representation of the color. Examples: "red", "green", "blue", "yellow", etc.
	 */
	public void color(String color) {
		try {
			turtleColor = (Color)Class.forName("java.awt.Color").getField(color).get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		world.repaint();
	}

	private static PaintArea world;
	
	private static ArrayList<Turtle> allTurtles;

	private double x; // x position of the turtle

	private double y; // y position of the turtle

	private double dir; // direction of the turtle in radians
	
	private Color turtleColor; // color of the turtle

	private long delay; // delay of the turtle
	
	private boolean turtleVisible; // true if the turtle is visible
	
	private boolean penDown; // true if the pen is down
	
	class PaintArea extends JPanel {

		private static final long serialVersionUID = 1L;

		public PaintArea(int width, int height) {
			this.width = width;
			this.height = height;
			drawingBuf = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			this.setPreferredSize(new Dimension(width, height));
		}

		public void drawLine(double x1, double y1, double x2, double y2, Color c) {
			Graphics2D g = drawingBuf.createGraphics();
			g.setColor(c);
			g.drawLine((int)Math.round(x1), (int)Math.round(y1), (int)Math.round(x2), (int)Math.round(y2));
		}

		public void paint(Graphics g) {
			g.drawImage(drawingBuf, 0, 0, Color.BLACK, null);
			for (Turtle t : allTurtles) {
				if (t.turtleVisible) {
					// draw the turtle
					g.setColor(t.turtleColor);
					double tw = 7;
					double th = 10;
					double sind = Math.sin(t.dir);
					double cosd = Math.cos(t.dir);
					int tx1 = (int)(t.x + th * cosd);
					int ty1 = (int)(t.y - th * sind);
					int tx2 = (int)(t.x - th * cosd - tw * sind);
					int ty2 = (int)(t.y + th * sind - tw * cosd);
					int tx3 = (int)(t.x - th * cosd + tw * sind);
					int ty3 = (int)(t.y + th * sind + tw * cosd);
					g.drawLine(tx1, ty1, tx2, ty2);
					g.drawLine(tx1, ty1, tx3, ty3);
					g.drawLine(tx2, ty2, tx3, ty3);
				}
			}
		}

		private BufferedImage drawingBuf;

		int width;

		int height;
	}
}
