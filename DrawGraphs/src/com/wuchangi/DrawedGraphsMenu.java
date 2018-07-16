package com.wuchangi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


//绘制图形对象的菜单
public class DrawedGraphsMenu
{
	private JFrame fatherFrame;

	public DrawedGraphsMenu(JFrame frame)
	{
		this.fatherFrame = frame;
	}

	public void show()
	{
		JFrame drawedGraphs = new JFrame("绘制图形如下：");
		drawedGraphs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawedGraphs.setSize(800, 600);

		Container c2 = drawedGraphs.getContentPane();
		c2.add(new GraphsPanel(), BorderLayout.CENTER);

		//准备好为该图形绘制界面添加的返回按钮
		JButton back = new JButton("返回");
		back.setFont(new Font("隶书", Font.BOLD, 30));
		back.setForeground(Color.RED);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				drawedGraphs.dispose();
				fatherFrame.setVisible(true);
			}
		});

		//将该返回按钮添加到容器对象c2中
		c2.add(back, BorderLayout.SOUTH);

		drawedGraphs.setVisible(true);
	}
}
