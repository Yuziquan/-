package Graphs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Words extends Shape
{
	private int x, y;
	private String words;

	public Words(String words, int x, int y)
	{
		this.words = words;
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String getWords()
	{
		return words;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setWords(String words)
	{
		this.words = words;
	}

	@Override
	public void paint(Graphics g)
	{
		g.setFont(new Font("¿¬Êé", Font.BOLD, 50));
		g.setColor(Color.GREEN);
		g.drawString(words, x, y);
	}
	
	public String getName()
	{
		return "ÎÄ×Ö";
	}
}
