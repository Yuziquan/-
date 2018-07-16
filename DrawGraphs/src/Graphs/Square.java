package Graphs;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape
{
	private int x, y, width, height;

	public Square(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, width, height);
		
	}
	
	public String getName()
	{
		return "Õý·½ÐÎ";
	}
}