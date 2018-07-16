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

//专门管理图形对象信息的类
public class GraphsMessages
{	
	//获取图形对象信息
	public static String getGraphsMessages()
	{
		StringBuilder existedGraphsMessage = new StringBuilder();
		String message = null;

		for(int i = 0; i < PrimaryMenu.graphs.size(); i++)
		{
			//依次逐个取出Vector类型的graphs中保存的图形对象
			Shape shape = PrimaryMenu.graphs.get(i);
			String graphName = shape.getName();

			if(graphName.equals("文字"))
			{
				Words words = (Words)shape;
				message = "["+(i+1)+"]   "+"内容为\"" + words.getWords() + "\",坐标为(" + words.getX() + "," + words.getY() + ")的文字\n";  
			}

			else if(graphName.equals("直线"))
			{
				Line line = (Line)shape;
				message = "["+(i+1)+"]   "+"两个端点坐标分别为(" + line.getX1() + "," + line.getY1() + "),(" + line.getX2() + "," + line.getY2() + ")的直线\n";
			}

			else if(graphName.equals("正方形"))
			{
				Square square = (Square)shape;
				message = "["+(i+1)+"]   "+"左上角顶点坐标为(" + square.getX() + "," + square.getY() + "), 边长为" + square.getWidth() + "的正方形\n";
			}

			else if(graphName.equals("圆形"))
			{
				Circle circle = (Circle)shape;
				message = "["+(i+1)+"]   "+"圆心坐标为(" + circle.getX() + "," + circle.getY() + "),半径为" + circle.getRadius() + "的圆形\n";
			}

			else if(graphName.equals("三角形"))
			{
				Triangle triangle = (Triangle)shape;
				message = "["+(i+1)+"]   "+"三个顶点坐标分别为(" + triangle.getxPoints()[0] + "," + triangle.getyPoints()[0] + "),(" + triangle.getxPoints()[1]+
						"," + triangle.getyPoints()[1] + "),(" + triangle.getxPoints()[2] + "," + triangle.getyPoints()[2] + ")的三角形\n";
			}

			else if(graphName.equals("正五边形"))
			{
				regularPentagon rP = (regularPentagon)shape;
				message = "["+(i+1)+"]   "+"外接圆圆心坐标为(" + rP.getX() + "," + rP.getY() + "),外接圆半径为" + rP.getRadius() + "的正五边形\n";
			}

			else if(graphName.equals("正六边形"))
			{
				regularHexagon rH = (regularHexagon)shape;
				message = "["+(i+1)+"]   "+"外接圆圆心坐标为(" + rH.getX() + "," + rH.getX() + "),外接圆半径为" + rH.getRadius() + "的正六边形\n";
			}

			existedGraphsMessage.append(message);	
		}
		
		return existedGraphsMessage.toString();
	}

	//将图形对象信息写入文件
	public static void saveInFile(String fileName)
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(fileName);
		
			fout.write(("你已创建的图形对象的信息如下：\n\n" + getGraphsMessages()).getBytes());
			fout.flush();
			fout.close();
		}
		catch(IOException e)
		{
			System.err.println("发生异常！");
			e.printStackTrace();
		}

	}
}
