import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class frequency {
	
	public static Scanner in = new Scanner(System.in);
    public static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    
    public static void main(String[] args) { // ��HashMap���<����:��Ƶ>����һ��ӳ���ϵ
    	
        
        // ��������ʽ�������ַ����е����б�����
        String regex = "[1234567890��������������������.��,����\"!--;:?\'\\]]";
        try {
            // ��ȡҪ������ļ�
        	System.out.println("�������ȡ�ļ����ļ�����");
        	String s = in.nextLine();
            BufferedReader br = new BufferedReader(new FileReader(s));
            String value;
            while ((value = br.readLine()) != null) {
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
            //��ʾ�û���Ҫ��ѯ�����ɸ����ʵĴ�Ƶ
            WordQuery.wordQuery(hashMap);
            //��ֵ����,������û�Ҫ��Ĵ�Ƶ����ǰK������
            SortMapByValues.sortMapByValues(hashMap);
            //���ݼ�����ĸ˳�������źú�ŵ�result.txt�ļ���
            SortMapByKeys.sortMapByKeys(hashMap);
           //ɾ�����ʡ��ڴʺͽ�ʣ��ź����ŵ�result1.txt�ļ���
            TongJiGaoPinCi.tongjigaopinci(hashMap);
        
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
