import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OneWindows extends JFrame{
	public OneWindows()
	{
		this.setLayout(new BorderLayout());
		JPanel noth=new JPanel();
		noth.setLayout(new GridLayout(1,4));
		JButton b1=new JButton("������Ϣ");
		JButton b2=new JButton("��ֵ����");
		JButton b3=new JButton("��ѯ����");
		JButton b4=new JButton("�����˳�");
		noth.add(b1);
		noth.add(b2);
		noth.add(b3);
		noth.add(b4);
		noth.setVisible(true);
		this.add(noth,BorderLayout.NORTH);
		
		
		
		ChuLi c=new ChuLi();
		this.add(c,BorderLayout.CENTER);
		c.setVisible(true);
		GaoPin g=new GaoPin();
		px p=new px();
		
		
		b1.addActionListener(event ->{
			this.add(c,BorderLayout.CENTER);
			c.setVisible(true);
			g.setVisible(false);
			p.setVisible(false);
		});
		b2.addActionListener(event ->{
			this.add(p,BorderLayout.CENTER);
			p.setVisible(true);
			g.setVisible(false);
			c.setVisible(false);
		});
		b3.addActionListener(event ->{
			this.add(g,BorderLayout.CENTER);
			g.setVisible(true);
			c.setVisible(false);
			p.setVisible(false);
		});
		b4.addActionListener(event ->{
			g.setVisible(false);
			c.setVisible(false);
			p.setVisible(false);
			TongJiGaoPinCi.tongjigaopinci();
			SortMapByKeys.sortMapByKeys();
			JOptionPane.showMessageDialog(null, "�Ѿ���ȫ�����ʰ��ֵ�˳�򱣴�reuslt.txt��\n�����˽�ʡ����ʡ��ڴ�����������ʰ��մ�Ƶ�ߵʹ�ŵ�result.txt��\n", "����", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		});
	}
	      
}
