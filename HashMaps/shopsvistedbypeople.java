package HashMap;

import java.util.*;

//In the fair there are N shops from 1 to N. So a total of M people visit the fair. 
//They will visit shops in a continuous manner only. So a person will visit shops from  
//		X,  X+1,  X+2,  X+3 ………….. Y (X+K)
//You are given with first and last shop visited by each person
//Now your task is to tell total count of number of customers visiting each shop

class pair{
	int first;
	int second;
	pair(int first,int second){
		this.first=first;
		this.second=second;
	}
}

public class shopsvistedbypeople {
	
	public static int [] solve(int [][] arr,int n,int m){
		int[] ans=new int[n];
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		int i=0;
		while(i<m) {
			pair man=new pair(arr[i][0],arr[i][1]);
			for(int j=man.first;j<=man.second;j++) {
				if(map.containsKey(j)) {
					map.put(j,map.get(j)+1);
				}else {
					map.put(j,1);
				}
			  }
			i++;
			}
		for(i=1;i<=n;i++) {
			if(map.get(i)==null)
				ans[i-1]=0;
			else
				ans[i-1]=map.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int [][] arr= new int[m][2];
		for(int i=0;i<m;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		int []ans= solve(arr,n, m);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i] + " ");
		}
		sc.close();
	}

}
