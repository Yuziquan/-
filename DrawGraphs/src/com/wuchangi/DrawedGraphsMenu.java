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


//����ͼ�ζ���Ĳ˵�
public class DrawedGraphsMenu
{
	private JFrame fatherFrame;

	public DrawedGraphsMenu(JFrame frame)
	{
		this.fatherFrame = frame;
	}

	public void show()
	{
		JFrame drawedGraphs = new JFrame("����ͼ�����£�");
		drawedGraphs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawedGraphs.setSize(800, 600);

		Container c2 = drawedGraphs.getContentPane();
		c2.add(new GraphsPanel(), BorderLayout.CENTER);

		//׼����Ϊ��ͼ�λ��ƽ�����ӵķ��ذ�ť
		JButton back = new JButton("����");
		back.setFont(new Font("����", Font.BOLD, 30));
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

		//���÷��ذ�ť��ӵ���������c2��
		c2.add(back, BorderLayout.SOUTH);

		drawedGraphs.setVisible(true);
	}
}
