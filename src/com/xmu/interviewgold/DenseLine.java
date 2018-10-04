package com.xmu.interviewgold;

import java.util.HashMap;

public class DenseLine {

	public double[] getLine(Point[] p, int n) {
		HashMap<Line, Integer> lineNum = new HashMap<Line, Integer>();
		int max = 0;
		double slope = Double.POSITIVE_INFINITY, intercept = 0;
		// ��������ȡ�������б�ʺͽؾ�,���ù�ϣͼ�洢�������͸����ļ�ֵ��
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double k = (double) (p[j].y - p[i].y) / (p[j].x - p[i].x);
				double b = (double) (p[i].y - k * p[i].x);
				Line line = new Line(k, b);
				if (lineNum.containsKey(line)) {
					int num = lineNum.get(line) + 1;
					lineNum.put(line, num);
					// ���ϵ������ֵ
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

// �������ı��˼��
class Line {
	double k; // б��
	double b; // �ؾ�
	double epsilon = 0.0001; // ���

	public Line(double k, double b) {
		this.k = k;
		this.b = b;
	}

	// �Ƚ�����double�Ƿ����
	public boolean isEqualValue(double a, double b) {
		return (Math.abs(a - b) < epsilon);
	}

	// ��дequals�������˷�������дʱ��ͨ���б�Ҫ��д hashCode ������
	// ��ά�� hashCode �����ĳ���Э������Э��������ȶ�����������ȵĹ�ϣ�롣
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			if (isEqualValue(k, ((Line) obj).k) && isEqualValue(b, ((Line) obj).b))
				return true;
			return false;
		}
		return super.equals(obj);
	}

	// HashMap��Ӧ��Ӧ����HashSet�����ݽṹ�ǹ�ϣ���ȱ�hashCode()���ٱ�equals
	public int hashCode() {
		String str = String.valueOf(k) + String.valueOf(b);
		return str.hashCode();
	}
}
