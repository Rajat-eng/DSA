package BACKTRACK;
import java.util.Scanner;
public class LexographicalOrder {
	
	private static void solve(int n) {
		for(int i=1;i<=9;i++) {
			order(i,n);
			System.out.println();
		}
		
	}

	private static void order(int i, int n) {
		
		if(i>n) {
			return;
		}
		System.out.print(i + " ");
		for(int j=0;j<10;j++) {
			order(10*i+j,n);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		solve(n);
		sc.close();
	}

}
