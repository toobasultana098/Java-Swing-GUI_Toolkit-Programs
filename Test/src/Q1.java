import java.util.*;

	


public class Q1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s;
		int n;
		char d;
		System.out.println("Enter String : ");
		s=sc.next();
		System.out.println("Enter Encoding number : ");
		n=sc.nextInt();
		for(int i=0; i<s.length();i++) {
			char x=s.charAt(i);
			d=alpha(x,n);
			System.out.print(d);
		}
	}
	
	
	public static char alpha(char x ,int n) {
		if(x<=70 && x<=122) {
			x=(char) (x+n);
			return x;
		}
		return 0;
}
}
