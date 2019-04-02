import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindows extends JFrame{
	public static String Filename;
	public static Scanner in = new Scanner(System.in);
    public static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    static int hang=0;
    static int zifu=0;
    static long time=0;
    
public MainWindows()
{
	this.setLayout(new GridLayout(3,1));
	JPanel j1=new JPanel();
	JPanel j2=new JPanel();
	JPanel j3=new JPanel();
	JLabel l1=new JLabel("�������ļ���");
	j1.add(l1);
	JTextField FileName =new JTextField(15);
	j2.add(FileName);
	JButton en=new JButton("ȷ��");
	j3.add(en);
	this.add(j1);
	this.add(j2);
	this.add(j3);
	en.addActionListener(event ->{
		Filename=FileName.getText();
		if(Filename.length()==0)
		{
			FileName.setText("�ļ�������Ϊ�գ�");
		}
		else
		{	
		    long date1=System.currentTimeMillis();
			 String regex = "[1234567890��������������/=><������.��,����\"!--;:?\'\\]]";
		        try {
		            // ��ȡҪ������ļ�
		        	File f=new File(Filename);
		        	if(!f.exists())
		        	{
		        		JOptionPane.showMessageDialog(null, "�ļ�������", "����", JOptionPane.ERROR_MESSAGE);
		        		FileName.setText("");
		        	}
			        else {
			        	this.setVisible(false);
			            BufferedReader br = new BufferedReader(new FileReader(Filename));
			            
			            String value;
			            while ((value = br.readLine()) != null) {
			            	hang++;
			            	zifu+=value.length();
			                value = value.replaceAll(regex, " ");
			                // ʹ��StringTokenizer���ִ�
			                StringTokenizer tokenizer = new StringTokenizer(value);
			                while (tokenizer.hasMoreTokens()) {
			                    String word = tokenizer.nextToken();
			                    if (!hashMap.containsKey(word)) {
			                        hashMap.put(word, new Integer(1));
			                    } else {
			                        int k = hashMap.get(word).intValue() + 1;
			                        hashMap.put(word, new Integer(k));
			                    }
			                }
			            }
			            br.close();
			            long date2=System.currentTimeMillis();
			            time=date2-date1;
			            OneWindows o=new OneWindows();
						o.setVisible(true);
					    o.setSize(600,300);
					    o.setLocation(300,200);
					    o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			            
			        }
		        }
		        catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } 
		        catch (IOException e) {
		            e.printStackTrace();
		        }
		}
       
       
	});
}
}
