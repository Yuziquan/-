package com.wuchangi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Graphs.Circle;
import Graphs.Line;
import Graphs.Square;
import Graphs.Triangle;
import Graphs.Words;
import Graphs.regularHexagon;
import Graphs.regularPentagon;


//图形对象创建菜单
public class CreateGraphsMenu
{
	private JFrame fatherFrame;

	public CreateGraphsMenu(JFrame frame)
	{
		this.fatherFrame = frame;
	}

	public void show()
	{
		JFrame selectGraphsItems = new JFrame("选择所要创建的图形");
		selectGraphsItems.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		selectGraphsItems.setSize(800, 600);

		Container c1 = selectGraphsItems.getContentPane();
		c1.setLayout(new GridLayout(2, 4));

		//准备好为该选择菜单添加的七个图形类型选择按钮
		JButton[] graphsItems = {new JButton("文字"), new JButton("直线"), new JButton("正方形"),
				new JButton("圆形"), new JButton("三角形"), new JButton("正五边形"), new JButton("正六边形")};

		for(int i = 0; i<7; i++)
		{
			graphsItems[i].setFont(new Font("隶书", Font.BOLD, 30));
			graphsItems[i].setForeground(Color.GREEN);
			graphsItems[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		//为文字选择按钮设置监听事件
		graphsItems[0].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String wordMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的文字内容及文字的坐标(x,y)"
								+ "（只支持整数，依次输入x, y, 文字字符串 ,用空格分隔）：").split(" ");

				String word = wordMessages[0];
				int x = Integer.parseInt(wordMessages[1]);
				int y = Integer.parseInt(wordMessages[2]);

				PrimaryMenu.graphs.add(new Words(word, x, y));

				JOptionPane.showMessageDialog(null, "你的文字对象创建成功！");
			}
		});

		//为直线选择按钮设置监听事件
		graphsItems[1].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String lineMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的直线的两个端点的坐标(x1,y1),(x2,y2)"
								+ "（只支持整数,依次输入x1,y1,x2,y2,用空格分隔）:").split(" ");

				int x1 = Integer.parseInt(lineMessages[0]);
				int y1 = Integer.parseInt(lineMessages[1]);
				int x2 = Integer.parseInt(lineMessages[2]);
				int y2 = Integer.parseInt(lineMessages[3]);

				PrimaryMenu.graphs.add(new Line(x1, y1, x2, y2));

				JOptionPane.showMessageDialog(null, "你的直线对象创建成功！");
			}
		});

		//为正方形选择按钮设置监听事件
		graphsItems[2].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String squareMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的正方形的左上角坐标(x,y)以及边长"
								+ "（只支持整数,依次输入x,y,边长,用空格分隔）:").split(" ");

				int x = Integer.parseInt(squareMessages[0]);
				int y = Integer.parseInt(squareMessages[1]);
				int sideLength = Integer.parseInt(squareMessages[2]);

				PrimaryMenu.graphs.add(new Square(x, y, sideLength, sideLength));

				JOptionPane.showMessageDialog(null, "你的正方形对象创建成功！");
			}
		});

		//为圆形选择按钮设置监听事件
		graphsItems[3].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String circleMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的圆形的圆心坐标(x,y)以及半径"
								+ "（只支持整数,依次输入x,y,半径,用空格分隔）:").split(" ");

				int x = Integer.parseInt(circleMessages[0]);
				int y = Integer.parseInt(circleMessages[1]);
				int radius = Integer.parseInt(circleMessages[2]);

				PrimaryMenu.graphs.add(new Circle(x, y, radius));

				JOptionPane.showMessageDialog(null, "你的圆形对象创建成功！");
			}
		});


		//为三角形选择按钮设置监听事件
		graphsItems[4].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String triangleMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的三角形的三个顶点的坐标(x1,y1),(x2,y2),(x3,y3)"
								+ "（只支持整数,依次输入x1,y1,x2,y2,x3,y3,用空格分隔）:").split(" ");

				int[] xPoints = new int[3];
				int[] yPoints = new int[3];

				for(int j = 0,i = 0; i < 6; i = i+2)
				{
					xPoints[j] = Integer.parseInt(triangleMessages[i]);
					yPoints[j] = Integer.parseInt(triangleMessages[i+1]);
					j++;
				}

				PrimaryMenu.graphs.add(new Triangle(xPoints, yPoints));

				JOptionPane.showMessageDialog(null, "你的三角形对象创建成功！");
			}
		});

		//为正五边形选择按钮设置监听事件
		graphsItems[5].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String rPMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的正五边形的外接圆圆心坐标（x,y）及外接圆半径"
								+ "（只支持整数,依次输入x,y,半径,用空格分隔）:").split(" ");

				int x = Integer.parseInt(rPMessages[0]);
				int y = Integer.parseInt(rPMessages[1]);
				int radius = Integer.parseInt(rPMessages[2]);

				PrimaryMenu.graphs.add(new regularPentagon(x, y, radius));

				JOptionPane.showMessageDialog(null, "你的正五边形对象创建成功！");
			}
		});

		//为正六边形选择按钮设置监听事件
		graphsItems[6].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String rHMessages[] = 
						JOptionPane.showInputDialog(null, "请输入您所要绘制的正六边形的外接圆圆心坐标（x,y）及外接圆半径"
								+ "（只支持整数,依次输入x,y,半径,用空格分隔）:").split(" ");

				int x = Integer.parseInt(rHMessages[0]);
				int y = Integer.parseInt(rHMessages[1]);
				int radius = Integer.parseInt(rHMessages[2]);

				PrimaryMenu.graphs.add(new regularHexagon(x, y, radius));

				JOptionPane.showMessageDialog(null, "你的正六边形对象创建成功！");
			}
		});


		//将七个图形类型选择按钮添加到容器对象c1中
		for(int i = 0; i < 7; i++)
		{
			c1.add(graphsItems[i]);
		}

		//准备好为该选择菜单添加的返回按钮
		JButton back = new JButton("返回");
		back.setFont(new Font("隶书", Font.BOLD, 30));
		back.setForeground(Color.RED);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		back.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				selectGraphsItems.dispose();
				fatherFrame.setVisible(true);
			}
		});

		//将该返回按钮添加到容器对象c1中
		c1.add(back, BorderLayout.SOUTH);

		selectGraphsItems.setVisible(true);
	}
}
