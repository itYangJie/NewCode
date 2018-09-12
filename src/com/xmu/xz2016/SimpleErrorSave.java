package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SimpleErrorSave {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Integer> map = new LinkedHashMap<>();
		while(in.hasNext()) {
			String[] str = in.nextLine().split(" ");
			String path = str[0];
			String lineNum = str[1];
			
			String fileName = "";
			int ind = path.lastIndexOf('\\');
			if(ind==-1)
				fileName = path;
			else
				fileName = path.substring(ind+1);
			String key = fileName+" "+lineNum;
			if(map.containsKey(key))
				map.put(key, map.get(key)+1);
			else
				map.put(key, 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for (int i=0;i<8;i++) {
			String[] str = list.get(i).getKey().split(" ");
			Integer val = list.get(i).getValue();
			String fileName = str[0];
			String lineNum = str[1];
			if(fileName.length()>16)
				fileName = fileName.substring(fileName.length()-16);
			System.out.println(fileName+" "+lineNum+" "+val);
		}
	}

}
