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
			// 每个出题者set
			Set<Long> lzs = new HashSet<>(n);
			// 每个出题者的回答者set（去重，不包含自己）
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
			// 如果个数为0，直接进行下个用例
			if (list.size() == 0)
				continue;
			for (int i = 0; i < list.size(); i++) {
				if (i > 0)
					System.out.print(" ");
				// 数字间空格分开，最后一个后面不要空格
				System.out.print(list.get(i));
			}
			System.out.println();// 换行
		}
	}

	public static Set<Long> fun(Set<Long> lzs, Map<Long, Set<Long>> qs) {
		Set<Long> cheater = new HashSet<>();
		// 判断第一种情况作弊：互相回答问题
		for (Long lz : lzs) {
			// 对于每一个发问者lz ,找到回答他问题的回答者answers
			Set<Long> answers = qs.get(lz);
			if (answers != null) {
				for (Long answer : answers) {
					Set<Long> answerAsLz = qs.get(answer);
					if (answerAsLz != null && answerAsLz.contains(lz)) {
						// 回答者的提问中是否有lz回答的问题
						cheater.add(lz);
						cheater.add(answer);
					}
				}
			}
		}
		// 第二种情况
		boolean flag = false;// 是否有新的作弊者加入
		// 当有新作弊者加入后要重新检查第二种作弊情况
		do {
			flag = false;
			// 对于每一个发问者lz
			for (Long lz : lzs) {
				// lz已经是作弊者，则跳过
				if (cheater.contains(lz))
					continue;
				// 找到回答他问题的回答者answer
				Set<Long> answers = qs.get(lz);
				int times = 0;
				for (Long cheat : cheater) {
					if (answers.contains(cheat))
						times++;
					// 如果有两个作弊者回答了lz问题，则lz作弊
					if (times >= 2)
						break;
				}
				if (times >= 2) {
					cheater.add(lz);
					flag = true;// 有新作弊者加入
				}
			}
		} while (flag);
		return cheater;
	}
}
