package BACKTRACK;
import java.util.ArrayList;
public class PrintKSubsets {
	

	private static void print(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans) {
//		O[k^n]
		if(i>n) {
			if(nos==k) {
				for(ArrayList<Integer> set:ans) {
					System.out.print(set);
				}
				System.out.println();
			}
			return;
		}
		for(int j=0;j<ans.size();j++) {
			if(ans.get(j).size()>0) {
				ans.get(j).add(i);
				print(i+1,n,k,nos,ans);
				ans.get(j).remove(ans.get(j).size()-1);
			}else {
				ans.get(j).add(i);
				print(i+1,n,k,nos+1,ans);
				ans.get(j).remove(ans.get(j).size()-1);
				break;
			}
		}
	}
	
	

	public static void main(String[] args) {
		int n=4;
		int k=3;
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<k;i++){
			ans.add(new ArrayList<Integer>());
		}
		print(1,n,k,0,ans);
	}


}
