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

//���˵�
public class PrimaryMenu
{
	public static Vector<Shape> graphs = new Vector<Shape>();

	public void show()
	{
		JFrame menu = new JFrame("�˵�");

		menu.setTitle("��ӭʹ�ø�ͼ�ζ���С����");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(800, 600);

		Container c = menu.getContentPane();
		c.setLayout(new GridLayout(5, 1));

		//׼����Ϊ�˵���ӵ�5����ť
		JButton[] menuItems = {new JButton("A.     Create graphs"), new JButton("B.     Modify existed graphs"),
				new JButton("C.     Displays graphs"),new JButton("D.     Save graphs\' data"), new JButton("E.     Exit")};

		for(int i = 0; i<5; i++)
		{
			menuItems[i].setFont(new Font("����", Font.BOLD, 30));
			menuItems[i].setForeground(Color.RED);
			menuItems[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		//Ϊ�ð�ť���ü����¼�
		menuItems[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menu.setVisible(false);
				//��ʾͼ������ѡ��˵�
				CreateGraphsMenu sgm = new CreateGraphsMenu(menu);
				sgm.show();
			}
		});

		//Ϊ�ð�ť���ü����¼�
		menuItems[1].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				StringBuilder messages = new StringBuilder();

				messages.append("���Ѵ�����ͼ�ζ������Ϣ���£�\n\n");

				messages.append(GraphsMessages.getGraphsMessages());

				messages.append("\n����������Ҫ�޸ĵ�ͼ�ζ�������Ӧ�����:\n");

				int selectedGraphNum =  Integer.parseInt(JOptionPane.showInputDialog(null, messages.toString()));
				//�޸�ѡ�е�ͼ�ζ���
				modifySelectedGraph(selectedGraphNum);
				JOptionPane.showMessageDialog(null, "�޸ĸ�ͼ�ζ���ɹ���");
			}
		});

		//Ϊ�ð�ť���ü����¼�
		menuItems[2].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				menu.setVisible(false);
				//��ʾͼ�λ��ƽ���
				DrawedGraphsMenu dgm = new DrawedGraphsMenu(menu);
				dgm.show();
			}
		});

		//Ϊ�ð�ť���ü����¼�
		menuItems[3].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//��ͼ�ζ�����Ϣд���ļ�
				String fileName = JOptionPane.showInputDialog(null, "����������Ҫ������ļ�����");
				GraphsMessages.saveInFile(fileName);
				JOptionPane.showMessageDialog(null, "����ɹ����뵽��Ŀ��Ŀ¼�鿴���ļ���");
			}
		});

		//Ϊ�ð�ť���ü����¼�
		menuItems[4].addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//�˳�����
				System.exit(1);
			}
		});

		//����ť��ӵ���������c��
		for(int i = 0; i<5; i++)
		{
			c.add(menuItems[i]);
		}

		menu.setVisible(true);
	}


	//�޸�ѡ�е�ͼ�ζ���
	public static void modifySelectedGraph(int selectedGraphNum)
	{
		Shape shape = graphs.get(selectedGraphNum - 1);
		String graphName = shape.getName();

		//�޸�����
		if(graphName.equals("����"))
		{
			Words words = (Words)shape;
			String wordMessages[] = 
					JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ��������ݼ����ֵ�����(x,y)"
							+ "��ֻ֧����������������x, y, �����ַ��� ,�ÿո�ָ�����").split(" ");

			String word = wordMessages[0];
			int x = Integer.parseInt(wordMessages[1]);
			int y = Integer.parseInt(wordMessages[2]);

			words.setWords(word);
			words.setX(x);
			words.setY(y);
		}

		//�޸�ֱ��
		else if(graphName.equals("ֱ��"))
		{
			Line line = (Line)shape;
			String lineMessages[] = 
					JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ�ֱ�ߵ������˵������(x1,y1),(x2,y2)"
							+ "��ֻ֧������,��������x1,y1,x2,y2,�ÿո�ָ���:").split(" ");

			int x1 = Integer.parseInt(lineMessages[0]);
			int y1 = Integer.parseInt(lineMessages[1]);
			int x2 = Integer.parseInt(lineMessages[2]);
			int y2 = Integer.parseInt(lineMessages[3]);

			line.setX1(x1);
			line.setX1(x2);
			line.setY1(y1);
			line.setY2(y2);
		}

		//�޸�������
		else if(graphName.equals("������"))
		{
			Square square = (Square)shape;
			String squareMessages[] = 
					JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ������ε����Ͻ�����(x,y)�Լ��߳�"
							+ "��ֻ֧������,��������x,y,�߳�,�ÿո�ָ���:").split(" ");

			int x = Integer.parseInt(squareMessages[0]);
			int y = Integer.parseInt(squareMessages[1]);
			int sideLength = Integer.parseInt(squareMessages[2]);

			square.setX(x);
			square.setY(y);
			square.setWidth(sideLength);
			square.setHeight(sideLength);
		}

		//�޸�Բ��
		else if(graphName.equals("Բ��"))
		{
			Circle circle = (Circle)shape;
			String circleMessage[] = 
					JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ�Բ�ε�Բ������(x,y)�Լ��뾶"
							+ "��ֻ֧������,��������x,y,�뾶,�ÿո�ָ���:").split(" ");

			int x = Integer.parseInt(circleMessage[0]);
			int y = Integer.parseInt(circleMessage[1]);
			int radius = Integer.parseInt(circleMessage[2]);

			circle.setX(x);
			circle.setY(y);
			circle.setRadius(radius);
		}

		//�޸�������
		else if(graphName.equals("������"))
		{
			Triangle triangle = (Triangle)shape;
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

			triangle.setxPoints(xPoints);
			triangle.setyPoints(yPoints);
		}

		//�޸��������
		else if(graphName.equals("�������"))
		{
			regularPentagon rP = (regularPentagon)shape;
			String rPMessages[] = 
					JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ�������ε����ԲԲ�����꣨x,y�������Բ�뾶"
							+ "��ֻ֧������,��������x,y,�뾶,�ÿո�ָ���:").split(" ");

			int x = Integer.parseInt(rPMessages[0]);
			int y = Integer.parseInt(rPMessages[1]);
			int radius = Integer.parseInt(rPMessages[2]);

			rP.setXAndY(x, y);
			rP.setRadius(radius);
		}

		//�޸���������
		else if(graphName.equals("��������"))
		{
			regularHexagon rH = (regularHexagon)shape;
			String rHMessages[] = 
					JOptionPane.showInputDialog(null, "����������Ҫ���Ƶ��������ε����ԲԲ�����꣨x,y�������Բ�뾶"
							+ "��ֻ֧������,��������x,y,�뾶,�ÿո�ָ���:").split(" ");

			int x = Integer.parseInt(rHMessages[0]);
			int y = Integer.parseInt(rHMessages[1]);
			int radius = Integer.parseInt(rHMessages[2]);

			rH.setXAndY(x, y);
			rH.setRadius(radius);
		}
	}
}
