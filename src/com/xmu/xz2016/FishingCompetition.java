package com.xmu.xz2016;

import java.util.Scanner;

public class FishingCompetition {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			String[] s1 = in.nextLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            int x = Integer.parseInt(s1[2]);
            int y = Integer.parseInt(s1[3]);
            int t = Integer.parseInt(s1[4]);
			double cc_no_fish_each_minute=0.00;
			double ss_no_fish_each_minute=0.00;
			for(int i=1;i<=n;i++) {
				String[] s = in.nextLine().split(" ");
				for(int j=1;j<=m;j++) {
					double temp = 1-Double.parseDouble(s[j-1]);
					if(i==x && j==y)
						cc_no_fish_each_minute = temp;
					ss_no_fish_each_minute += temp;
				}
			}
			ss_no_fish_each_minute = ss_no_fish_each_minute/(n*m);
			double cc = 1-Math.pow(cc_no_fish_each_minute,t);
			double ss = 1-Math.pow(ss_no_fish_each_minute,t);
			if(cc>ss) {
				System.out.println("cc");
				System.out.printf("%.2f\n", cc);
			}else if(cc<ss) {
				System.out.println("ss");
				System.out.printf("%.2f\n", ss);
			}else {
				System.out.println("equal");
				System.out.printf("%.2f\n", cc);
				return;
			}
		}
	}

}
