import java.util.Scanner;
public class maxroworcol {
	public static int findlargest(int input[][],int n,int m) {
		//calculate row sum 1st
		int rowsum=0;
		int max=Integer.MIN_VALUE;
		int num=0;
		int i,j;
		for(i=0;i<n;i++) {
			rowsum=0;
    		for(j=0;j<m;j++) {
    		rowsum+=input[i][j];
    		}
    		if(rowsum>max) {
    		   max=rowsum;
    		   num=i;
    		  }		
    	}
		// calculate column sum
		int colsum=0;
		for(j=0;j<m;j++) {
			colsum=0;
			for(i=0;i<n;i++) {
				colsum+=input[i][j];
			}
			if(colsum>max) {
				colsum=max;
				num=j;
			}
		}
		return max;
	}
    public static void printarray(int input[][],int n,int m) {
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    		System.out.print(input[i][j]+ " ");
    		}
    		System.out.println(" ");
    	}
    	
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();  //row
		int m=sc.nextInt();  //column
		int input[][]=new int[n][m];
    	int i=0,j=0;
    	for(i=0;i<n;i++) {
    		for(j=0;j<m;j++) {
    		input[i][j]=sc.nextInt();
    		}
    	}
    	printarray(input,n,m);
    	System.out.println(findlargest(input,n,m));
	}
}
