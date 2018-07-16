package Graphs;

import java.awt.Color;
import java.awt.Graphics;

public class regularHexagon extends Shape
{
	private int x, y, radius;
	private int[] xPoints = new int[6];
	private int[] yPoints = new int[6];

	public regularHexagon(int x, int y, int r)
	{
		this.x = x;
		this.y = y;
		this.radius = r;

		double angle = (2 * Math.PI)/6.0;

		xPoints[0] = (int)(x - r * Math.cos(angle));
		yPoints[0] = (int)(y - r * Math.sin(angle));

		xPoints[1] = (int)(x + r * Math.cos(angle));
		yPoints[1] = (int)(y - r * Math.sin(angle));


		xPoints[2] = x + r;
		yPoints[2] = y;

		xPoints[3] = (int)(x + r * Math.cos(angle));
		yPoints[3] = (int)(y + r * Math.sin(angle));

		xPoints[4] = (int)(x - r * Math.cos(angle));
		yPoints[4] = (int)(y + r * Math.sin(angle));

		xPoints[5] = x - r;
		yPoints[5] = y;

	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getRadius()
	{
		return radius;
	}

	public int[] getxPoints()
	{
		return xPoints;
	}

	public int[] getyPoints()
	{
		return yPoints;
	}

	public void setXAndY(int x, int y)
	{
		this.x = x;
		this.y = y;

		double angle = (2 * Math.PI)/6.0;

		xPoints[0] = (int)(x - radius* Math.cos(angle));
		yPoints[0] = (int)(y - radius * Math.sin(angle));

		xPoints[1] = (int)(x + radius * Math.cos(angle));
		yPoints[1] = (int)(y - radius * Math.sin(angle));


		xPoints[2] = x + radius;
		yPoints[2] = y;

		xPoints[3] = (int)(x + radius * Math.cos(angle));
		yPoints[3] = (int)(y + radius * Math.sin(angle));

		xPoints[4] = (int)(x - radius * Math.cos(angle));
		yPoints[4] = (int)(y + radius * Math.sin(angle));

		xPoints[5] = x - radius;
		yPoints[5] = y;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	
	public String getName()
	{
		return "ÕýÁù±ßÐÎ";
	}
}
