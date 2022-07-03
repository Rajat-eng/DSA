package Stacks;
import java.util.Stack;
public class Celebrity {
	
	public static int celeb(int[][] arr) {
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			s.push(i);
		}
		while(s.size()>=2) {
			int i=s.pop();
			int j=s.pop();
			if(arr[i][j]==1) {
//			if i knows j--> i cannot be celeb
			s.push(j);
			}else {
//			if i does not know j then j cannot be celeb	
			s.push(i);
			}
		}
		int potnentialceleb=s.pop();
		for(int i=0;i<arr.length;i++) {
//			row has all false and col has all true
			if(i!=potnentialceleb) {
				if(arr[i][potnentialceleb]==0 || arr[potnentialceleb][i]==1) {
					System.out.println("none");
					return -1;
				}
			}
		}
		return potnentialceleb;
	}
	
	public static void main(String[] args) {
		int [][]MATRIX = { {0, 0, 1, 0},
		           {0, 0, 1, 0},
		           {0, 0, 0, 0},
		           {0, 0, 1, 0} };
		int ans=celeb(MATRIX);
		System.out.println(ans);

	}
}

