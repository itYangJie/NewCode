package com.xmu.swordoffer;

import java.util.ArrayList;

public class OnceTimeInArray {

	public static void main(String[] args) {
		System.out.println(getLowestOneInd(10));
	}

	// num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	// ��num1[0],num2[0]����Ϊ���ؽ��
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		
		int len = array.length;
		int num = array[0];
		for(int i=1;i<len;i++)
			num ^= array[i];
		
		int ind = getLowestOneInd(num);
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i=0;i<len;i++) {
			if( ((array[i]>>ind) & 1) ==0)
				list1.add(array[i]);
			else
				list2.add(array[i]);
		}
		
		num1[0] = list1.get(0);
		for(int i=1;i<list1.size();i++)
			num1[0] ^= list1.get(i);
		
		num2[0] = list2.get(0);
		for(int i=1;i<list2.size();i++)
			num2[0] ^= list2.get(i);
	}

	private static int getLowestOneInd(int num) {
		int ind = 0;
		while(((num>>ind) & 1)!=1)
			ind++;
		return ind;
	}
}
