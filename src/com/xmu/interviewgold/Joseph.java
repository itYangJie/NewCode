package com.xmu.interviewgold;

import java.util.LinkedList;

public class Joseph {
	public int getResult(int n) {

		if (n < 1) {
			return -1;
		}

		LinkedList<Integer> idList = new LinkedList<>();
		for (int i = 1; i <= n; i += 2) {// 第一轮偶数全都出局，所以初始化列表只需要奇数就行
			idList.add(i);
		}

		int j = 3;// 第二轮开始就是报三个数了
		while (j <= n) {
			idList.addFirst(idList.removeLast());// 尾部移动到头部

			int len = idList.size();
			int k = 1;
			for (int i = 1; i <= len; i++) {// 删除时注意列表是在不停缩短的
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
