package com.xmu.leetcode;

import java.util.List;

import java.util.ArrayList;

public class TextJustification {
	public static void main(String[] args) {
		fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16);
	}
	/**
	 * words = ["This", "is", "an", "example", "of", "text", "justification."]
		maxWidth = 16
		Output:
		[
		   "This    is    an",
		   "example  of text",
		   "justification.  "
		]
	 * @param words
	 * @param maxWidth
	 * @return
	 */
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		
		List<List<String>> list = new ArrayList<>();
		
		int curWidth = words[0].length();
		List<String> temp = new ArrayList<>();
		temp.add(words[0]);
		list.add(temp);
		for(int i=1;i<words.length;i++) {
			if(curWidth+1+words[i].length()>maxWidth) {
				temp = new ArrayList<>();
				list.add(temp);
				temp.add(words[i]);
				curWidth = words[i].length();
			}else {
				temp.add(words[i]);
				curWidth = curWidth+1+words[i].length();
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size();i++) {
			List<String> curStrs = list.get(i);
			if(curStrs.size()==1) {
				sb.append(curStrs.get(0));
				while(sb.length()<maxWidth)
					sb.append(" ");
			}else {
				sb.append(curStrs.get(0));
				if(i==list.size()-1) {
					for(int k=1;k<curStrs.size();k++) {
						sb.append(" ");
						sb.append(curStrs.get(k));
					}
					while(sb.length()<maxWidth)
						sb.append(" ");
				}else {
					int charWidth = 0;
					for(int j=0;j<curStrs.size();j++)
						charWidth = charWidth+curStrs.get(j).length();
					int resWidth = maxWidth-charWidth;
					int spacePer = resWidth / (curStrs.size()-1);
					int restSpace = resWidth-spacePer*(curStrs.size()-1);
					for(int k=1;k<curStrs.size();k++) {
						for(int m=1;m<=spacePer;m++)
							sb.append(" ");
						if(k<=restSpace)
							sb.append(" ");
						sb.append(curStrs.get(k));
					}
				}
			}
			res.add(sb.toString());
			sb = new StringBuffer();
		}
		return res;
	}
}
