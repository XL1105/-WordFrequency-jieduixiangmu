import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


//��ʾ�û���Ҫ��ѯ�����ɸ����ʵĴ�Ƶ
public class WordQuery {

	static Scanner in =new Scanner(System.in);
	public static void wordQuery(Map<String, Integer> Map)
	{
		//��ʾ�û���Ҫ��ѯ�����ɸ����ʵĴ�Ƶ
        System.out.println("��������Ҫ��ѯ�ĵ���,����֮���ÿո����");
        String s = in.nextLine();
        String[] word= s.split(" ");
        int length = word.length;
        int[] num = new int[length];
        int i, sum=0;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : Map.entrySet()) { 
        		if(word[i].equals(entry.getKey()))
        		{
        			sum += entry.getValue();
        			num[i] = entry.getValue();
        			System.out.println(entry.getKey() + ":\t " + entry.getValue()+ num[i]); 
        			break;
        		}
                
            } 
        }
        System.out.println("��������ص���״ͼ���£�һ��*�������ʮ�Σ���");
        int j;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : Map.entrySet()) { 
        		if(word[i].equals(entry.getKey()))
        		{
        			double t = (double)(entry.getValue())/sum*100;
        			BigDecimal a =new BigDecimal(t).setScale(2, BigDecimal.ROUND_HALF_UP);		//�Ը����������������봦��
        			Integer result = a.intValue();
        			String re = "";
        			for(j=0; j<result; j++) {
        				re += "*";
        			}
        			System.out.println(word[i] + ":\t"  + "|" + re);
        			break;
        		}
                
            } 
        }
        
		
	}
}
