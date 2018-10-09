package Numbers;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		int i,n;
		System.out.println("enter any no.");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(i=2;i<n;i++)
		{
			if(n%i==0)
			break;	
		}
		if(i==n)
			System.out.println("it is a prime no.");
		else
			System.out.println("it is not a  prime no.");
	}
}
