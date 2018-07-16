package com.wuchangi;

import java.io.FileOutputStream;
import java.io.IOException;
import Graphs.Circle;
import Graphs.Line;
import Graphs.Shape;
import Graphs.Square;
import Graphs.Triangle;
import Graphs.Words;
import Graphs.regularHexagon;
import Graphs.regularPentagon;

//ר�Ź���ͼ�ζ�����Ϣ����
public class GraphsMessages
{	
	//��ȡͼ�ζ�����Ϣ
	public static String getGraphsMessages()
	{
		StringBuilder existedGraphsMessage = new StringBuilder();
		String message = null;

		for(int i = 0; i < PrimaryMenu.graphs.size(); i++)
		{
			//�������ȡ��Vector���͵�graphs�б����ͼ�ζ���
			Shape shape = PrimaryMenu.graphs.get(i);
			String graphName = shape.getName();

			if(graphName.equals("����"))
			{
				Words words = (Words)shape;
				message = "["+(i+1)+"]   "+"����Ϊ\"" + words.getWords() + "\",����Ϊ(" + words.getX() + "," + words.getY() + ")������\n";  
			}

			else if(graphName.equals("ֱ��"))
			{
				Line line = (Line)shape;
				message = "["+(i+1)+"]   "+"�����˵�����ֱ�Ϊ(" + line.getX1() + "," + line.getY1() + "),(" + line.getX2() + "," + line.getY2() + ")��ֱ��\n";
			}

			else if(graphName.equals("������"))
			{
				Square square = (Square)shape;
				message = "["+(i+1)+"]   "+"���ϽǶ�������Ϊ(" + square.getX() + "," + square.getY() + "), �߳�Ϊ" + square.getWidth() + "��������\n";
			}

			else if(graphName.equals("Բ��"))
			{
				Circle circle = (Circle)shape;
				message = "["+(i+1)+"]   "+"Բ������Ϊ(" + circle.getX() + "," + circle.getY() + "),�뾶Ϊ" + circle.getRadius() + "��Բ��\n";
			}

			else if(graphName.equals("������"))
			{
				Triangle triangle = (Triangle)shape;
				message = "["+(i+1)+"]   "+"������������ֱ�Ϊ(" + triangle.getxPoints()[0] + "," + triangle.getyPoints()[0] + "),(" + triangle.getxPoints()[1]+
						"," + triangle.getyPoints()[1] + "),(" + triangle.getxPoints()[2] + "," + triangle.getyPoints()[2] + ")��������\n";
			}

			else if(graphName.equals("�������"))
			{
				regularPentagon rP = (regularPentagon)shape;
				message = "["+(i+1)+"]   "+"���ԲԲ������Ϊ(" + rP.getX() + "," + rP.getY() + "),���Բ�뾶Ϊ" + rP.getRadius() + "���������\n";
			}

			else if(graphName.equals("��������"))
			{
				regularHexagon rH = (regularHexagon)shape;
				message = "["+(i+1)+"]   "+"���ԲԲ������Ϊ(" + rH.getX() + "," + rH.getX() + "),���Բ�뾶Ϊ" + rH.getRadius() + "����������\n";
			}

			existedGraphsMessage.append(message);	
		}
		
		return existedGraphsMessage.toString();
	}

	//��ͼ�ζ�����Ϣд���ļ�
	public static void saveInFile(String fileName)
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(fileName);
		
			fout.write(("���Ѵ�����ͼ�ζ������Ϣ���£�\n\n" + getGraphsMessages()).getBytes());
			fout.flush();
			fout.close();
		}
		catch(IOException e)
		{
			System.err.println("�����쳣��");
			e.printStackTrace();
		}

	}
}
