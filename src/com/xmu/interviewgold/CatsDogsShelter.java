package com.xmu.interviewgold;

import java.util.ArrayList;

public class CatsDogsShelter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> asylum(int[][] ope) {
		// write code here
		ArrayList<Integer> r = new ArrayList<Integer>();// ���������������
		ArrayList<Integer> animal = new ArrayList<Integer>();// ��Ž����������Ķ���
		int temp = 0;
		for (int i = 0; i < ope.length; i++) {
			switch (ope[i][0]) {
			// �ж������������
			case 1:
				animal.add(ope[i][1]);
				break;
			// ������������
			case 2:
				// ��һ��������ʽ
				if (!animal.isEmpty() && ope[i][1] == 0) {
					r.add(animal.get(0));
					animal.remove(0);
				}
				// ������
				else if (ope[i][1] == 1) {
					for (temp = 0; temp < animal.size(); temp++) {
						if (animal.get(temp) > 0) {
							r.add(animal.get(temp));
							animal.remove(temp);
							break;
						}
					}
				}
				// ����è
				else if (ope[i][1] == -1) {
					for (temp = 0; temp < animal.size(); temp++) {
						if (animal.get(temp) < 0) {
							r.add(animal.get(temp));
							animal.remove(temp);
							break;
						}
					}
				}
				break;
			}
		}
		return r;
	}
}
