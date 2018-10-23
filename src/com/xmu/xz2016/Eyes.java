package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Eyes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			int n = Integer.parseInt(input.nextLine());
			// ÿ��������set
			Set<Long> lzs = new HashSet<>(n);
			// ÿ�������ߵĻش���set��ȥ�أ��������Լ���
			Map<Long, Set<Long>> qs = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String line = input.nextLine();
				String[] all = line.split(" ");
				Long lz = Long.valueOf(all[0]);
				lzs.add(lz);
				Set<Long> set = qs.get(lz);
				if (set == null) {
					set = new HashSet<>();
					qs.put(lz, set);
				}
				for (int j = 1; j < all.length; j++) {
					Long as = Long.valueOf(all[j]);
					if (as != lz)
						set.add(as);
				}
			}
			Set<Long> cheater = fun(lzs, qs);
			List<Long> list = new ArrayList<>(cheater);
			Collections.sort(list);
			System.out.println(list.size());
			// �������Ϊ0��ֱ�ӽ����¸�����
			if (list.size() == 0)
				continue;
			for (int i = 0; i < list.size(); i++) {
				if (i > 0)
					System.out.print(" ");
				// ���ּ�ո�ֿ������һ�����治Ҫ�ո�
				System.out.print(list.get(i));
			}
			System.out.println();// ����
		}
	}

	public static Set<Long> fun(Set<Long> lzs, Map<Long, Set<Long>> qs) {
		Set<Long> cheater = new HashSet<>();
		// �жϵ�һ��������ף�����ش�����
		for (Long lz : lzs) {
			// ����ÿһ��������lz ,�ҵ��ش�������Ļش���answers
			Set<Long> answers = qs.get(lz);
			if (answers != null) {
				for (Long answer : answers) {
					Set<Long> answerAsLz = qs.get(answer);
					if (answerAsLz != null && answerAsLz.contains(lz)) {
						// �ش��ߵ��������Ƿ���lz�ش������
						cheater.add(lz);
						cheater.add(answer);
					}
				}
			}
		}
		// �ڶ������
		boolean flag = false;// �Ƿ����µ������߼���
		// �����������߼����Ҫ���¼��ڶ����������
		do {
			flag = false;
			// ����ÿһ��������lz
			for (Long lz : lzs) {
				// lz�Ѿ��������ߣ�������
				if (cheater.contains(lz))
					continue;
				// �ҵ��ش�������Ļش���answer
				Set<Long> answers = qs.get(lz);
				int times = 0;
				for (Long cheat : cheater) {
					if (answers.contains(cheat))
						times++;
					// ��������������߻ش���lz���⣬��lz����
					if (times >= 2)
						break;
				}
				if (times >= 2) {
					cheater.add(lz);
					flag = true;// ���������߼���
				}
			}
		} while (flag);
		return cheater;
	}
}
