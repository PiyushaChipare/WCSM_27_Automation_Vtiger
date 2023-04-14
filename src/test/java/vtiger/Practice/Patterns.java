package vtiger.Practice;

import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		int a=0;
		for(int i=1;i<=5;i++)
		{
			if(i%2!=0)
			{
				for(int j=1;j<=3;j++)
				{
					int m=i+j;
					if(m>=4+a)
					{System.out.print("+ ");}
					else
					System.out.print("  ");
				}
				for(int j=4;j<=5;j++)
				{
					int m=i+j;
					if(m>=7+a)
					{System.out.print("+ ");}
					
				}
				a++;
			}
			else
			{System.out.println();}
		}			
	}
}

