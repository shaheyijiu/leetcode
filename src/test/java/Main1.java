package test.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Main1 {
	int max = 1;
    public void filter(long list[],HashMap<Long,String> map){
    	Map<Long, String> map2 = new HashMap<Long, String>();
        int length = list.length;
        for (int i = 0; i < length; i++)
        {
            for (int j = i; j < length; j++)
            {
                if (map.get(list[i]).equals(map.get(list[j])))
                {
                    if(list[i] < list[j]){
                    	map.put(list[j], "");
                    } else {
                    	map.put(list[i], "");
                    }
                }
            }
        }
        for (int i = 0; i < length ; i++){
        	if(map.get(list[i]).equals("")){
        		
        	} else {
        		System.out.print(map.get(list[i]));
        	}
        }
    }
}