package DP;
//  given houses paint them whith colors such that no two adjacent  houses have same color
public class painthouses {
	
	public static int paint(int[][]arr) {
		int r=arr.length; // houses
		int c=arr[0].length; //colors
		int [][]dp=new int[r][c];
		
		int least=Integer.MAX_VALUE;
		int sleast=Integer.MAX_VALUE;
		
		for(int j=0;j<c;j++) {
			dp[0][j]=arr[0][j];
			if(dp[0][j]<=least) {
				sleast=least;
				least=dp[0][j];
			}else if(dp[0][j]<=sleast) {
				sleast=dp[0][j];
			}
		}
		System.out.println("least" + least + " " + "sleast" + sleast);
		for(int i=1;i<r;i++) {
			int nleast=Integer.MAX_VALUE;
			int nsleast=Integer.MAX_VALUE;
			for(int j=0;j<c;j++) {
				
				if(least==dp[i-1][j]) {
					dp[i][j]=arr[i][j]+sleast;
				}else {
					dp[i][j]=arr[i][j]+least;
				}
		
				if(dp[i][j]<=nleast) {
					nsleast=nleast;
					nleast=dp[i][j];
				}else if(dp[i][j]<=nsleast) {
					nsleast=dp[i][j];
				}
			}
			least=nleast;
			sleast=nsleast;
			System.out.println("least" + least + " " + "sleast" + sleast);
		}
		
		return least;
	}

	public static void main(String[] args) {
		int [][]arr= {{1,5,7,2,1,4},{5,8,4,3,6,1},{3,2,9,7,2,3},{1,2,4,9,1,7}};
		System.out.println(paint(arr));
	}

}
