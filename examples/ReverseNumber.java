package Numbers;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println("enter number: ");
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		int n=t;
		int rev=0;
		while(t>0)
		{
			int k=t%10;
		t=t/10;
		rev=rev*10+k;
		
		}
System.out.println("reverse no. is :"+rev);


if(n==rev)
{
System.out.println("P");	
}
else
{
System.out.println("N");	
}

	}
	
	
	
	
}
