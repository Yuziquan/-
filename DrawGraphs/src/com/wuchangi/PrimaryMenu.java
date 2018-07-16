package com.wuchangi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Graphs.Circle;
import Graphs.Line;
import Graphs.Shape;
import Graphs.Square;
import Graphs.Triangle;
import Graphs.Words;
import Graphs.regularHexagon;
import Graphs.regularPentagon;

//主菜单
public class PrimaryMenu
{
	public static Vector<Shape> graphs = new Vector<Shape>();

	public void show()
	{
		JFrame menu = new JFrame("菜单");

		menu.setTitle("欢迎使用该图形对象小程序！");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(800, 600);

		Container c = menu.getContentPane();
		c.setLayout(new GridLayout(5, 1));

		//准备好为菜单添加的5个按钮
		JButton[] menuItems = {new JButton("A.     Create graphs"), new JButton("B.     Modify existed graphs"),
				new JButton("C.     Displays graphs"),new JButton("D.     Save graphs\' data"), new JButton("E.     Exit")};

		for(int i = 0; i<5; i++)
		{
			menuItems[i].setFont(new Font("楷书", Font.BOLD, 30));
			menuItems[i].setForeground(Color.RED);
			menuItems[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		//为该按钮设置监听事件
		menuItems[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menu.setVisible(false);
				//显示图形类型选择菜单
				CreateGraphsMenu sgm = new CreateGraphsMenu(menu);
				sgm.show();
			}
		});

		//为该按钮设置监听事件
		menuItems[1].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				StringBuilder messages = new StringBuilder();

				messages.append("你已创建的图形对象的信息如下：\n\n");

				messages.append(GraphsMessages.getGraphsMessages());

				messages.append("\n请输入您想要修改的图形对象所对应的序号:\n");

				int selectedGraphNum =  Integer.parseInt(JOptionPane.showInputDialog(null, messages.toString()));
				//修改选中的图形对象
				modifySelectedGraph(selectedGraphNum);
				JOptionPane.showMessageDialog(null, "修改该图形对象成功！");
			}
		});

		//为该按钮设置监听事件
		menuItems[2].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				menu.setVisible(false);
				//显示图形绘制界面
				DrawedGraphsMenu dgm = new DrawedGraphsMenu(menu);
				dgm.show();
			}
		});

		//为该按钮设置监听事件
		menuItems[3].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//将图形对象信息写入文件
				String fileName = JOptionPane.showInputDialog(null, "请输入你所要保存的文件名：");
				GraphsMessages.saveInFile(fileName);
				JOptionPane.showMessageDialog(null, "保存成功！请到项目根目录查看该文件！");
			}
		});

		//为该按钮设置监听事件
		menuItems[4].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//退出程序
				System.exit(1);
			}
		});

		//将按钮添加到容器对象c中
		for(int i = 0; i<5; i++)
		{
			c.add(menuItems[i]);
		}

		menu.setVisible(true);
	}


	//修改选中的图形对象
	public static void modifySelectedGraph(int selectedGraphNum)
	{
		Shape shape = graphs.get(selectedGraphNum - 1);
		String graphName = shape.getName();

		//修改文字
		if(graphName.equals("文字"))
		{
			Words words = (Words)shape;
			String wordMessages[] = 
					JOptionPane.showInputDialog(null, "请输入您所要绘制的文字内容及文字的坐标(x,y)"
							+ "（只支持整数，依次输入x, y, 文字字符串 ,用空格分隔）：").split(" ");

			String word = wordMessages[0];
			int x = Integer.parseInt(wordMessages[1]);
			int y = Integer.parseInt(wordMessages[2]);

			words.setWords(word);
			words.setX(x);
			words.setY(y);
		}

		//修改直线
		else if(graphName.equals("直线"))
		{
			Line line = (Line)shape;
			String lineMessages[] = 
					JOptionPane.showInputDialog(null, "请输入您所要绘制的直线的两个端点的坐标(x1,y1),(x2,y2)"
							+ "（只支持整数,依次输入x1,y1,x2,y2,用空格分隔）:").split(" ");

			int x1 = Integer.parseInt(lineMessages[0]);
			int y1 = Integer.parseInt(lineMessages[1]);
			int x2 = Integer.parseInt(lineMessages[2]);
			int y2 = Integer.parseInt(lineMessages[3]);

			line.setX1(x1);
			line.setX1(x2);
			line.setY1(y1);
			line.setY2(y2);
		}

		//修改正方形
		else if(graphName.equals("正方形"))
		{
			Square square = (Square)shape;
			String squareMessages[] = 
					JOptionPane.showInputDialog(null, "请输入您所要绘制的正方形的左上角坐标(x,y)以及边长"
							+ "（只支持整数,依次输入x,y,边长,用空格分隔）:").split(" ");

			int x = Integer.parseInt(squareMessages[0]);
			int y = Integer.parseInt(squareMessages[1]);
			int sideLength = Integer.parseInt(squareMessages[2]);

			square.setX(x);
			square.setY(y);
			square.setWidth(sideLength);
			square.setHeight(sideLength);
		}

		//修改圆形
		else if(graphName.equals("圆形"))
		{
			Circle circle = (Circle)shape;
			String circleMessage[] = 
					JOptionPane.showInputDialog(null, "请输入您所要绘制的圆形的圆心坐标(x,y)以及半径"
							+ "（只支持整数,依次输入x,y,半径,用空格分隔）:").split(" ");

			int x = Integer.parseInt(circleMessage[0]);
			int y = Integer.parseInt(circleMessage[1]);
			int radius = Integer.parseInt(circleMessage[2]);

			circle.setX(x);
			circle.setY(y);
			circle.setRadius(radius);
		}

		//修改三角形
		else if(graphName.equals("三角形"))
		{
			Triangle triangle = (Triangle)shape;
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

			triangle.setxPoints(xPoints);
			triangle.setyPoints(yPoints);
		}

		//修改正五边形
		else if(graphName.equals("正五边形"))
		{
			regularPentagon rP = (regularPentagon)shape;
			String rPMessages[] = 
					JOptionPane.showInputDialog(null, "请输入您所要绘制的正五边形的外接圆圆心坐标（x,y）及外接圆半径"
							+ "（只支持整数,依次输入x,y,半径,用空格分隔）:").split(" ");

			int x = Integer.parseInt(rPMessages[0]);
			int y = Integer.parseInt(rPMessages[1]);
			int radius = Integer.parseInt(rPMessages[2]);

			rP.setXAndY(x, y);
			rP.setRadius(radius);
		}

		//修改正六边形
		else if(graphName.equals("正六边形"))
		{
			regularHexagon rH = (regularHexagon)shape;
			String rHMessages[] = 
					JOptionPane.showInputDialog(null, "请输入您所要绘制的正六边形的外接圆圆心坐标（x,y）及外接圆半径"
							+ "（只支持整数,依次输入x,y,半径,用空格分隔）:").split(" ");

			int x = Integer.parseInt(rHMessages[0]);
			int y = Integer.parseInt(rHMessages[1]);
			int radius = Integer.parseInt(rHMessages[2]);

			rH.setXAndY(x, y);
			rH.setRadius(radius);
		}
	}
}
