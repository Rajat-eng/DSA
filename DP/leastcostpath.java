package DP;

public class leastcostpath {
	
	public static int minpath(int[][] input) {
		int m=input.length;
		int n=input[0].length;
		int [][] storage=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				storage[i][j]=-1;
			}
		}
		return minpathM(input,0,0,storage);
	}
	
	
	public static int minpathM(int[][] input,int i,int j,int[][] storage) {
		int m=input.length;
		int n=input[0].length;
		
		if(i==m-1 &&j==n-1) {
			return input[i][j];
		}	
		if(i>=m ||j>=n)
		  return Integer.MAX_VALUE;
		
		if(storage[i][j]!=-1)
			return storage[i][j];
		
		int op1=minpathM(input,i+1,j,storage);
        int op2=minpathM(input,i+1,j+1,storage);
        int op3=minpathM(input,i,j+1,storage);
		
        storage[i][j]=input[i][j] + Math.min(op1, Math.min(op2,op3));
        return storage[i][j];
	}
	
	public static int minpathDP(int[][] input) {
		int m=input.length;
		int n=input[0].length;
		int [][] storage=new int[m][n];
		
		storage[m-1][n-1]=input[m-1][n-1];
		for(int i=m-2;i>=0;i--) {
//			last column
			storage[i][n-1]=storage[i+1][n-1]+input[i][n-1];
		}
		for(int j=n-2;j>=0;j--) {
//			last row
			storage[m-1][j]=storage[m-1][j+1]+input[m-1][j];
		}
		
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				storage[i][j]=input[i][j]+Math.min(storage[i+1][j],Math.min(storage[i+1][j+1], storage[i][j+1]));
			}
		}
		return storage[0][0];
	}

	public static void main(String[] args) {
		int [][] arr= { {1,2,3},{4,5,6},{7,8,9} };
		System.out.println(minpath(arr));
		System.out.println(minpathDP(arr));
	}

}
