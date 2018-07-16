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


//ͼ�ζ��󴴽��˵�
public class CreateGraphsMenu
{
	private JFrame fatherFrame;

	public CreateGraphsMenu(JFrame frame)
	{
		this.fatherFrame = frame;
	}

	public void show()
	{
		JFrame selectGraphsItems = new JFrame("ѡ����Ҫ������ͼ��");
		selectGraphsItems.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		selectGraphsItems.setSize(800, 600);

		Container c1 = selectGraphsItems.getContentPane();
		c1.setLayout(new GridLayout(2, 4));

		//׼����Ϊ��ѡ��˵���ӵ��߸�ͼ������ѡ��ť
		JButton[] graphsItems = {new JButton("����"), new JButton("ֱ��"), new JButton("������"),
				new JButton("Բ��"), new JButton("������"), new JButton("�������"), new JButton("��������")};

		for(int i = 0; i<7; i++)
		{
			graphsItems[i].setFont(new Font("����", Font.BOLD, 30));
			graphsItems[i].setForeground(Color.GREEN);
			graphsItems[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		//Ϊ����ѡ��ť���ü����¼�
		graphsItems[0].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String wordMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ��������ݼ����ֵ�����(x,y)"
								+ "��ֻ֧����������������x, y, �����ַ��� ,�ÿո�ָ�����").split(" ");

				String word = wordMessages[0];
				int x = Integer.parseInt(wordMessages[1]);
				int y = Integer.parseInt(wordMessages[2]);

				PrimaryMenu.graphs.add(new Words(word, x, y));

				JOptionPane.showMessageDialog(null, "������ֶ��󴴽��ɹ���");
			}
		});

		//Ϊֱ��ѡ��ť���ü����¼�
		graphsItems[1].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String lineMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ�ֱ�ߵ������˵������(x1,y1),(x2,y2)"
								+ "��ֻ֧������,��������x1,y1,x2,y2,�ÿո�ָ���:").split(" ");

				int x1 = Integer.parseInt(lineMessages[0]);
				int y1 = Integer.parseInt(lineMessages[1]);
				int x2 = Integer.parseInt(lineMessages[2]);
				int y2 = Integer.parseInt(lineMessages[3]);

				PrimaryMenu.graphs.add(new Line(x1, y1, x2, y2));

				JOptionPane.showMessageDialog(null, "���ֱ�߶��󴴽��ɹ���");
			}
		});

		//Ϊ������ѡ��ť���ü����¼�
		graphsItems[2].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String squareMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ������ε����Ͻ�����(x,y)�Լ��߳�"
								+ "��ֻ֧������,��������x,y,�߳�,�ÿո�ָ���:").split(" ");

				int x = Integer.parseInt(squareMessages[0]);
				int y = Integer.parseInt(squareMessages[1]);
				int sideLength = Integer.parseInt(squareMessages[2]);

				PrimaryMenu.graphs.add(new Square(x, y, sideLength, sideLength));

				JOptionPane.showMessageDialog(null, "��������ζ��󴴽��ɹ���");
			}
		});

		//ΪԲ��ѡ��ť���ü����¼�
		graphsItems[3].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String circleMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ�Բ�ε�Բ������(x,y)�Լ��뾶"
								+ "��ֻ֧������,��������x,y,�뾶,�ÿո�ָ���:").split(" ");

				int x = Integer.parseInt(circleMessages[0]);
				int y = Integer.parseInt(circleMessages[1]);
				int radius = Integer.parseInt(circleMessages[2]);

				PrimaryMenu.graphs.add(new Circle(x, y, radius));

				JOptionPane.showMessageDialog(null, "���Բ�ζ��󴴽��ɹ���");
			}
		});


		//Ϊ������ѡ��ť���ü����¼�
		graphsItems[4].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String triangleMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ������ε��������������(x1,y1),(x2,y2),(x3,y3)"
								+ "��ֻ֧������,��������x1,y1,x2,y2,x3,y3,�ÿո�ָ���:").split(" ");

				int[] xPoints = new int[3];
				int[] yPoints = new int[3];

				for(int j = 0,i = 0; i < 6; i = i+2)
				{
					xPoints[j] = Integer.parseInt(triangleMessages[i]);
					yPoints[j] = Integer.parseInt(triangleMessages[i+1]);
					j++;
				}

				PrimaryMenu.graphs.add(new Triangle(xPoints, yPoints));

				JOptionPane.showMessageDialog(null, "��������ζ��󴴽��ɹ���");
			}
		});

		//Ϊ�������ѡ��ť���ü����¼�
		graphsItems[5].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String rPMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ�������ε����ԲԲ�����꣨x,y�������Բ�뾶"
								+ "��ֻ֧������,��������x,y,�뾶,�ÿո�ָ���:").split(" ");

				int x = Integer.parseInt(rPMessages[0]);
				int y = Integer.parseInt(rPMessages[1]);
				int radius = Integer.parseInt(rPMessages[2]);

				PrimaryMenu.graphs.add(new regularPentagon(x, y, radius));

				JOptionPane.showMessageDialog(null, "���������ζ��󴴽��ɹ���");
			}
		});

		//Ϊ��������ѡ��ť���ü����¼�
		graphsItems[6].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String rHMessages[] = 
						JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ��������ε����ԲԲ�����꣨x,y�������Բ�뾶"
								+ "��ֻ֧������,��������x,y,�뾶,�ÿո�ָ���:").split(" ");

				int x = Integer.parseInt(rHMessages[0]);
				int y = Integer.parseInt(rHMessages[1]);
				int radius = Integer.parseInt(rHMessages[2]);

				PrimaryMenu.graphs.add(new regularHexagon(x, y, radius));

				JOptionPane.showMessageDialog(null, "����������ζ��󴴽��ɹ���");
			}
		});


		//���߸�ͼ������ѡ��ť��ӵ���������c1��
		for(int i = 0; i < 7; i++)
		{
			c1.add(graphsItems[i]);
		}

		//׼����Ϊ��ѡ��˵���ӵķ��ذ�ť
		JButton back = new JButton("����");
		back.setFont(new Font("����", Font.BOLD, 30));
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

		//���÷��ذ�ť��ӵ���������c1��
		c1.add(back, BorderLayout.SOUTH);

		selectGraphsItems.setVisible(true);
	}
}
