import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Scanner;


//��ʾ�û���Ҫ��ѯ�����ɸ����ʵĴ�Ƶ
public class WordQuery extends JPanel{
	static String[] word;
	static int[] num;
	static int max=0;
	static String s;
	static Map<String, Integer> Map=MainWindows.hashMap;
	
	public WordQuery(){
		Map<String, Integer> map2 = new HashMap<String, Integer>();
        word = s.split(" ");
        int length = word.length;
        num = new int[length];
        int i;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : Map.entrySet()) { 
        		if(entry.getValue()>max)
        		{
        			max = entry.getValue();
        		}
        		if(word[i].equals(entry.getKey()))
        		{
        			num[i] = entry.getValue();
        			System.out.println(entry.getKey() + ":\t " + entry.getValue()+ num[i]); 
        			map2.put(entry.getKey(), entry.getValue());
        			break;
        		}
             } 
        }
	//	setBounds(400, 200, 450, 450);
		this.setVisible(true);
	}
	public void paint(Graphics g){
		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;//����ͼ��߽�
		int topMargin = 50;//����ͼ�ϱ߽�
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height-topMargin;
		int rulerStep = ruler/20;//����ǰ�ĸ߶�����Ϊ20����λ
		g2.setColor(Color.WHITE);//���ư�ɫ����
		g2.fillRect(0, 0, Width, Height);//���ƾ���ͼ
		g2.setColor(Color.BLACK);
		for(int i=0;i<rulerStep;i++){
			g2.drawString((max-max/20*i)+"", 8, topMargin+rulerStep*i);//����Y���ϵ�����
		}
		g2.setColor(Color.yellow);
		int m=0;
		for(int i = 0;i<word.length;i++){
			int value = num[i]/20;
			int step = (m+1)*40;//����ÿ������ͼ��ˮƽ���Ϊ40
			g2.fillRoundRect(leftMargin+step*2,Height-value, 40, value, 0, 0);//����ÿ����״��
			
			m++;
		}
		
		m=0;
		for(int i = 0;i<word.length;i++){
			int step = (m+1)*40;//����ÿ������ͼ��ˮƽ���Ϊ40
			int value = num[i]/10;
			g2.setColor(Color.BLACK);
			g2.drawString(word[i], leftMargin+step*2, Height-topMargin+40);
			g2.drawString(num[i]+"", leftMargin+step*2, Height-value-5);	//��ʶÿ����״��	
			m++;
		}
	}
}
