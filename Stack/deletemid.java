package Stacks;
import java.util.*;

public class deletemid {
	
	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		int n=N+1;
        int mid=0;
        if(n%2==0){
             mid=(n/2)-1;
        }else{            
        	mid=n/2;
        }
        int count=0;
        Stack<Integer> s=new Stack<Integer>();
        while(count!=mid){
            int x=inputStack.pop();
            s.push(x);
            count++;
        }
        inputStack.pop();// mid element
            while(!s.isEmpty()){
                int y=s.pop();
                inputStack.push(y);
            }
        Queue<Integer> q=new LinkedList<Integer>();
        while(!inputStack.isEmpty()) {
        	q.add(inputStack.pop());
        }
        while(!q.isEmpty()) {
        	inputStack.push(q.remove());
        }
	}

	public static void main(String[] args) {
		Stack<Integer> st=new Stack<Integer>();
		for(int i=1;i<=5;i++) {
			st.add(i);
		}
//		83 74 67 49 94 8 11 1  
//		st.add(83);
//		st.add(74);
//		st.add(67);
//		st.add(49);
//		st.add(94);
//		st.add(8);
//		st.add(11);
//		st.add(1);
		deleteMiddle(st, st.size());
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

}
