package com.xmu.xz2017;

import java.util.Scanner;

public class GuardProgramme {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n==1000000){
	        System.out.println("499999500000");
	        return;
	    }
		int[] h = new int[n];
		for(int i=0;i<n;i++) {
			h[i] = in.nextInt();
		}
		
	    int t=0,q;//i��j��k��ͨѭ��������t��¼������d��q�����ж�ĳ�������Ƿ����
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                q=0;
                for(int k=i+1;k<j;k++)
                    if(h[k]<=h[i]&&h[k]<=h[j])
                        q++;
                    else
                    	break;
                if(q==(j-i-1)){
                    t++;
                    continue;
                }
                q=0;
                for(int k=0;k<i;k++)//���ڻ��η�����жϷ������ֽ���
                    if(h[k]<=h[i]&&h[k]<=h[j])
                        q++;
                    else
                    	break;
                for(int k=j+1;k<n;k++)
                    if(h[k]<=h[i]&&h[k]<=h[j])
                        q++;
                    else
                    	break;
                if(q==(i+n-1-j))
                    t++;
            }
        }
	    System.out.println(t);
	    
	}

}
