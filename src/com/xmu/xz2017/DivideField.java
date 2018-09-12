package com.xmu.xz2017;

import java.util.Scanner;

public class DivideField {
	//����matrix���������϶���(i,j)�����¶���(x-1,y-1)ȷ������صļ�ֵ��
	public static int cal(int x,int y,int i,int j,int[][] sum)
	{
	    return sum[x][y]-sum[x][j]-sum[i][y]+sum[i][j];
	}
	//�ж�x�Ƿ�С�ڵ���С���������Сһ���ֵ
	public static boolean judge(int x,int n,int m,int[][] sum)
	{
	    for (int i=1;i<=m-3 ;i++ )
	    {
	        for (int j=i+1;j<=m-2 ;j++ )
	        {
	            for (int k=j+1;k<=m-1 ;k++ )
	            {
	                int last=0,cnt=0;
	                for (int r=1;r<=n ;r++ )
	                {
	                    int s1=cal(r,i,last,0,sum);
	                    int s2=cal(r,j,last,i,sum);
	                    int s3=cal(r,k,last,j,sum);
	                    int s4=cal(r,m,last,k,sum);
	                    //��ǰ����һ����������
	                    if (s1>=x&&s2>=x&&s3>=x&&s4>=x)
	                    {
	                        last=r;
	                        cnt++;
	                    }
	                }
	                //����xС�ڵ���16������е���Сֵ������true
	                if (cnt>=4)
	                {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}
	public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
	    while (sc.hasNext())
	    {
	        int n=sc.nextInt();
	        int m=sc.nextInt();
	        int[][] matrix=new int[n][m];
	        for (int i=0;i<n ;i++ )
	        {
	            String str=sc.next();
	            for (int j=0;j<m ;j++ )
	            {
	                matrix[i][j]=str.charAt(j)-'0';
	            }
	        }
	        //sum[i][j]��ʾ
	        //���϶���matrix[0][0]�����¶���matrix[i-1][j-1]
	        //ȷ���ĵľ���Ԫ�صĺ�
	        //����sum[1][1]�ͱ�ʾmatrix[0][0];
	        int[][] sum=new int[n+1][m+1];
	        for (int i=1;i<=n ;i++ )
	        {
	            for (int j=1;j<=m ;j++ )
	            {
	                sum[i][j]=sum[i-1][j]+
	                        sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
	            }
	        }
	        int left=0,right=sum[n][m],res=0;
	        while (left<=right)
	        {
	            int mid=(left+right)/2;
	            /*������Ŀ����ʾ���е����
	            ����ʾ��
	                4 4
	                3332
	                3233
	                3332
	                2323
	                ���
	                2
	            sum����Ϊ
	            0 0  0  0  0
	            0 3  6  9  11
	            0 6  11 17 22
	            0 9  17 26 33
	            0 11 22 33 43
	            mid����Ϊ21->10->4->1->2
	                            */
	            if (judge(mid,n,m,sum))
	            {
	                left=mid+1;
	                res=mid;
	            }
	            else
	            {
	                right=mid-1;
	            }
	        }
	        System.out.println(res);
	    }
	    sc.close();
	}
}
