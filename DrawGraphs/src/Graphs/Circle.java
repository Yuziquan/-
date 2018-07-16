package Graphs;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape
{
	private int x, y, radius;

	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
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

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawOval(x - radius, y-radius, 2 *radius, 2*radius);
	}

	public String getName()
	{
		return "т╡пн";
	}


}
