package com.yang.test;

import java.util.Scanner;

public class Main
{
	
public static int calculateMax(int[] prices) 
{
	Scanner sc = new Scanner(System.in);
	if(prices == null || prices.length <= 1)
	{
		return 0;
	}
	int sum = 0;
	
	for(int i = 1; i < prices.length ;i++)
	{
		int temp = getMax(prices,0,i) + getMax(prices,i+1,prices.length - 1);
		 if(temp > sum)
		 {
			 sum = temp;
		 }
	}
	return sum;
}
    private static int getMax(int[] prices, int left, int right) 
    {
    	if(left >=prices.length)
    	{
    		return 0;	
    	}
    	int min = prices[left];
    	int res = 0;
    	for(int  i = left + 1;i <= right;i++)
    	{
    		min = Math.min(prices[i], min);
    		res = Math.max(res, prices[i]-min);
    	}
    	return res;
    }
	public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n,m;
			n = sc.nextInt();
			m = sc.nextInt();
			int[] score = new int[n];
			for(int i = 0;i < n;i++)
			{
				score[i] = sc.nextInt();
			}
			String s;
			int a = 0,b=0;
			for(int i=0;i<m && sc.hasNext();i++)
			{
				s = sc.next();
				a=sc.nextInt();
				b = sc.nextInt();
				process(s,a,b,score);
			}
		}
    }
	private static void process(String s, int a, int b, int[] score) {
		int begin;
		if(s.equals("Q"))
		{
			begin = Math.min(a, b);
			int max=score[begin];
			for(int i = begin-1;i<b;i++)
			{
				if(max < score[i])
				{
					max = score[i];
				}
			}
			System.out.println(max);
		}
		if(s.endsWith("U"))
		{
			score[a-1] = b;
		}
		
	}
}