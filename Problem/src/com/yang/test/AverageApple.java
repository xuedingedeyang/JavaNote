	package com.yang.test;
	
	import java.util.Scanner;
	
	public class AverageApple {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int a;
			a = sc.nextInt();
			int b[] = new int[a];
			int sum = 0,count=0;
			for(int i = 0 ; i < b.length ; i++)
			{
				b[i] = sc.nextInt();
				sum+=b[i];
			}
			if(sum%b.length!=0)
			{
				System.out.println(-1);
			}
			else
			{
				while(isFinished(b))
				{
					int max = b[0],min = b[0],max_index=0,min_index=0;
					for(int i=0;i<b.length;i++)
					{
						if(b[i] < min)
							b[i] = min;
						else if(b[i]>max)
							b[i]=max;
					}
					b[max_index]-=2;
					b[min_index]+=2;
					count++;
				}
				System.out.println(count);
			}
		}
	
		private static boolean isFinished(int[] b) {
			for(int i = 0 ; i < b.length -1 ; i++)
			{
				if(b[i] != b[i+1])
				{
					return false;
				}
					
			}
			return true;
		}
	}
