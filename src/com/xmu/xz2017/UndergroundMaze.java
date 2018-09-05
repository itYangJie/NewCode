package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndergroundMaze {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // n*m�Թ�,С���ܳ�ʼ��(0,0)λ��,�����Թ��ĳ�����(0,m-1)
            // С�������Թ���ˮƽ�ƶ�һ����λ������Ҫ����1������ֵ,��
            // ����һ����λ������Ҫ����3����λ������ֵ,�����ƶ�����������ֵ
            int n = in.nextInt();
            int m = in.nextInt();
            // ʣ������ֵ
            int power = in.nextInt();
            int[][] maze = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++)
                    maze[i][j] = in.nextInt();
            }
            System.out.println(pathOut(n , m, maze, power));
        }
	}
		 
    static String path = "";
    public static String pathOut(int n, int m, int[][] maze, int power){
        if(n <= 0)
            return "Can not escape!";
 
        boolean[][] visited = new boolean[n][m];
        findPath(n, m, maze, 0, 0, "", visited, power);
 
        return path;
    }
 
    public static void findPath(int n, int m, int[][] maze, int nowx, int nowy, String res, boolean[][] visited, int power){
        if(nowx == 0 && nowy == m - 1 && maze[0][m - 1] == 1){
            if(power >= 0)
                path = res + "[0," + (m - 1) + "]";
            else
                path = "Can not escape!";
 
            return;
        }
 
        if(nowx < n && nowy < m && nowx >= 0 && nowy >= 0 && maze[nowx][nowy] == 1 && !visited[nowx][nowy]){
 
            visited[nowx][nowy] = true;
            res += "[" + nowx + "," + nowy + "],";
            // ˮƽ����
            findPath(n, m, maze, nowx, nowy + 1, res, visited, power - 1);
            // ����
            findPath(n, m, maze, nowx + 1, nowy, res, visited, power);
            // ˮƽ����
            findPath(n, m, maze, nowx, nowy - 1, res, visited, power - 1);
            // ����
            findPath(n, m, maze, nowx - 1, nowy, res, visited, power - 3);
        }
 
    }

}
