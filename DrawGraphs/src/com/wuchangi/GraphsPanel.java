package com.wuchangi;

import java.awt.Graphics;
import javax.swing.JPanel;
import Graphs.*;

//绘制图形对象的画板
public class GraphsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g)
	{
		for(int i = 0; i < PrimaryMenu.graphs.size(); i++)
		{	
			//依次逐个取出Vector类型的graphs中保存的图形对象
			Shape shape = PrimaryMenu.graphs.get(i);
			shape.paint(g);
		}
	}
}
