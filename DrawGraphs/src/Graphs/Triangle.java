package Graphs;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape
{
	private int[] xPoints = new int[3];
	private int[] yPoints = new int[3];

	public Triangle(int[] xPoints, int[] yPoints)
	{
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}

	public int[] getxPoints()
	{
		return xPoints;
	}

	public int[] getyPoints()
	{
		return yPoints;
	}

	public void setxPoints(int[] xPoints)
	{
		this.xPoints = xPoints;
	}

	public void setyPoints(int[] yPoints)
	{
		this.yPoints = yPoints;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.PINK);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	
	public String getName()
	{
		return "Èý½ÇÐÎ";
	}
}