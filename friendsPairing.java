package BACKTRACK;

public class friendsPairing {
	
	private static void pair(int n) {
		boolean [] used=new boolean[1+n];
		solve(1,n,used,"");
	}

	private static void solve(int i, int n, boolean[] used, String asf) {
		if(i>n) {
			System.out.println(asf);
			return;
		}
		if(used[i]==true) {
			solve(i+1,n,used,asf);
		}else {
			used[i]=true;
			solve(i+1,n,used,asf + "(" + i + ")"); //akela
			for(int j=i+1;j<=n;j++) {
				if(used[j]==false) {
					used[j]=true;
					solve(i+1,n,used,asf + "(" +i +","+ j + ")"); // 12-..   13-..
					used[j]=false;
				}	
			}
			used[i]=false;
		}
	}

	public static void main(String[] args) {
		int n=4;
		pair(n);
	}
	
}
