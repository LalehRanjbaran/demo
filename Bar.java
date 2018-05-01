package finalProject;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
	private String label;
	private double value;
	public static final int HEIGHT = 15;

	/**
	 * @param aLabel
	 * @param size
	 */
	public Bar(String aLabel, double size) {
		label = aLabel;
		value = size;
	}

	public void draw(Graphics g, int y, double scale) {
		final int GAP = 0;
		g.fillRect(0, y, (int) (value * scale), HEIGHT);
		g.setColor(Color.WHITE);
		g.drawString(label, GAP, y + HEIGHT - GAP);
		g.setColor(Color.BLACK);
	}
}
