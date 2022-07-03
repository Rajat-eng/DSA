package Stacks;
import java.util.Stack;
public class Asteroidcollison {
	
	public static int[] asteroids(int []arr) {
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			int val= arr[i];
			if(val>0) {
				st.push(val);
			}else {
				while(st.size()!=0 && st.peek()>0 && st.peek()<-val) {  //incoming is bigger in size then pop 
					st.pop();
				}if(st.size()!=0 && st.peek()==-val ) {   // incoming is equal then pop only 
					st.pop();
				}else if(st.size()!=0 && st.peek()>-val) {  // incoming is smaller than stack, do nothing 
					continue;
				}else {
					st.push(val);
				}
			}
		}
		int [] asteroid=new int[st.size()];
		for(int i=asteroid.length-1;i>=0;i--) {
			asteroid[i]=st.pop();
		}
		return asteroid;
	}

	public static void main(String[] args) {
		// -ve is left
		// +ve is right
		int arr[]={-1,-2,1,3,1,2,-3,3};
//		int arr1[] ={4,-3,-2};
		int[] ans= asteroids(arr);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
