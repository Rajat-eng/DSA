package BACKTRACK;

public class PrintPremutations {
	
	private static void nCr(int currbox, int n, int posAcquired, int r, String ans) {
//		O[2^n] recursive calls
		if(currbox>n) {
			if(posAcquired==r)
			System.out.println(ans);
			return;
		}
		
		nCr(currbox+1,n,posAcquired+1,r,ans + "e" + " ");
		nCr(currbox+1,n,posAcquired,r,ans + "-" + " ");
	}
	

	private static void nPr(int[] boxes, int item, int totalitems) {
//		O[(n-r-1)!]
		if(item>totalitems) {
			for(int i:boxes) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<boxes.length;i++) {
			if(boxes[i]==0) {
				boxes[i]=item;
				nPr(boxes,item+1,totalitems);
				boxes[i]=0;
			}
		}
		
	}


	public static void main(String[] args) {
		int n=4;
		int r=2;
		int[] boxes=new int[n];
		nCr(1,n,0,r,"");
		System.out.println();
		nPr(boxes,1,r);

	}



	

}
