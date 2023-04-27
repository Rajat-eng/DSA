package Queue;

import java.util.*;

public class Quse {
	
	public static Queue<Integer> takeinput() {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc=new Scanner(System.in);
		int element=sc.nextInt();
		while(element!=-1) {
			queue.add(element);
			element=sc.nextInt();
		}
		return queue;	
	}
	
	public static void print(Queue<Integer> input) {
		
		while(!input.isEmpty()) {
			System.out.print(input.poll() + " ");
		}
	}

	public static void main(String[] args) {
		
		QueueLL<Integer> q=new QueueLL<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.front());
		q.dequeue();
		System.out.println(q.front());

	}

}
