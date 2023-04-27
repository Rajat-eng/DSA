package BACKTRACK;
import java.util.*;
public class BreakNumber {
	
	private static void breakNumberHelper(int start, int rem, LinkedList < Integer > arr, ArrayList < ArrayList < Integer >> ans) {

        if (rem == 0) {
            ArrayList < Integer > temp = new ArrayList < > ();
            for (int num: arr) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int i = start; i <= rem; i++) {
            arr.add(i);
            breakNumberHelper(i, rem - i, arr, ans);
            arr.removeLast();
        }
    }

    public static ArrayList < ArrayList < Integer >> breakNumber(int n) {

        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        LinkedList < Integer > arr = new LinkedList < > ();
        breakNumberHelper(1, n, arr, ans);
        return ans;

    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		ArrayList < ArrayList < Integer >> ans = breakNumber(num);
        for(int i=0;i<ans.size();i++){
            ArrayList<Integer> arr=ans.get(i);
            for(int k:arr){
                System.out.print(k +" ");
            }
            System.out.println();
        }
        sc.close();
	}

}
