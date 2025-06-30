package pratice;

import org.apache.*;

public class GenericMethodPratice {

	public static void main(String[] args) {//caller function
	
	int sum = add(10,30);
	System.out.println(sum);
	System.out.println(add(30,sum));
	
	System.out.println(add(100,40));
	System.out.println(add(60, sum));
	System.out.println(add(50,80));
	System.out.println(add(40,sum));
	int sum2 = add(sum,70);
	System.out.println(sum2);
	

	}
	// logic controlled exicution
	public static int add(int a, int b) { //called function - generic

//	int c= a+b;
//		int c=a-b;
//		int c =a*b;
//		int c= a/b;
		int c= a%b;
	return c;

	}

}
