package com.wuchangi;

import java.awt.Graphics;
import javax.swing.JPanel;
import Graphs.*;

//����ͼ�ζ���Ļ���
public class GraphsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g)
	{
		for(int i = 0; i < PrimaryMenu.graphs.size(); i++)
		{	
			//�������ȡ��Vector���͵�graphs�б����ͼ�ζ���
			Shape shape = PrimaryMenu.graphs.get(i);
			shape.paint(g);
		}
	}
}
