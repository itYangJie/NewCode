package com.xmu.interviewgold;

import java.util.HashMap;

public class DenseLine {

	public double[] getLine(Point[] p, int n) {
		HashMap<Line, Integer> lineNum = new HashMap<Line, Integer>();
		int max = 0;
		double slope = Double.POSITIVE_INFINITY, intercept = 0;
		// 把所有线取出来求出斜率和截距,并用哈希图存储下线条和个数的键值对
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double k = (double) (p[j].y - p[i].y) / (p[j].x - p[i].x);
				double b = (double) (p[i].y - k * p[i].x);
				Line line = new Line(k, b);
				if (lineNum.containsKey(line)) {
					int num = lineNum.get(line) + 1;
					lineNum.put(line, num);
					// 不断调整最大值
					if (num > max) {
						max = num;
						slope = k;
						intercept = b;
					}
				} else
					lineNum.put(line, 1);
			}
		}
		return new double[] { slope, intercept };
	}
}

// 面向对象的编程思想
class Line {
	double k; // 斜率
	double b; // 截距
	double epsilon = 0.0001; // 误差

	public Line(double k, double b) {
		this.k = k;
		this.b = b;
	}

	// 比较两个double是否相等
	public boolean isEqualValue(double a, double b) {
		return (Math.abs(a - b) < epsilon);
	}

	// 重写equals方法当此方法被重写时，通常有必要重写 hashCode 方法，
	// 以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			if (isEqualValue(k, ((Line) obj).k) && isEqualValue(b, ((Line) obj).b))
				return true;
			return false;
		}
		return super.equals(obj);
	}

	// HashMap对应的应该是HashSet，数据结构是哈希表，先比hashCode()，再比equals
	public int hashCode() {
		String str = String.valueOf(k) + String.valueOf(b);
		return str.hashCode();
	}
}
