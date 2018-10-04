package com.xmu.interviewgold;

import java.util.LinkedList;

public class Joseph {
	public int getResult(int n) {

		if (n < 1) {
			return -1;
		}

		LinkedList<Integer> idList = new LinkedList<>();
		for (int i = 1; i <= n; i += 2) {// ��һ��ż��ȫ�����֣����Գ�ʼ���б�ֻ��Ҫ��������
			idList.add(i);
		}

		int j = 3;// �ڶ��ֿ�ʼ���Ǳ���������
		while (j <= n) {
			idList.addFirst(idList.removeLast());// β���ƶ���ͷ��

			int len = idList.size();
			int k = 1;
			for (int i = 1; i <= len; i++) {// ɾ��ʱע���б����ڲ�ͣ���̵�
				if (i % j != 1) {
					idList.remove(i - k);
					k++;
				}
			}

			if (idList.size() <= j) {
				return idList.getLast();
			}

			j++;
		}

		return 1;
	}
}
