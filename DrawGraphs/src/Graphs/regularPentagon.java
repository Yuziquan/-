package Graphs;

import java.awt.Color;
import java.awt.Graphics;

public class regularPentagon extends Shape
{
	private int x, y, radius;
	private int[] xPoints = new int[5];
	private int[] yPoints = new int[5];

	public regularPentagon(int x, int y, int r)
	{
		this.x = x;
		this.y = y;
		this.radius = r;

		double angle = (2 * Math.PI )/5.0;

		xPoints[0] = x;
		yPoints[0] = y - r;

		xPoints[1] = (int)(x - r * Math.sin(angle));
		yPoints[1] = (int)(y - r * Math.cos(angle));

		xPoints[2] = (int)(x - r * Math.sin(angle/2));
		yPoints[2] = (int)(y + r * Math.cos(angle/2));

		xPoints[3] = (int)(x + r * Math.sin(angle/2));
		yPoints[3] = (int)(y + r * Math.cos(angle/2));

		xPoints[4] = (int)(x + r * Math.sin(angle));
		yPoints[4] = (int)(y - r * Math.cos(angle));

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

		double angle = (2 * Math.PI )/5.0;

		xPoints[0] = x;
		yPoints[0] = y - radius;

		xPoints[1] = (int)(x - radius * Math.sin(angle));
		yPoints[1] = (int)(y - radius * Math.cos(angle));

		xPoints[2] = (int)(x - radius * Math.sin(angle/2));
		yPoints[2] = (int)(y + radius * Math.cos(angle/2));

		xPoints[3] = (int)(x + radius * Math.sin(angle/2));
		yPoints[3] = (int)(y + radius * Math.cos(angle/2));

		xPoints[4] = (int)(x + radius * Math.sin(angle));
		yPoints[4] = (int)(y - radius * Math.cos(angle));
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	
	public String getName()
	{
		return "ÕýÎå±ßÐÎ";
	}

}
