package HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class LRUCache {
	
	public static class LRU{
		class Node{
			int key,value;
			Node prev,next;
		}
		HashMap<Integer,Node> cache=new HashMap<>();
		int cap;
		Node head,tail;
		
		private void addNode(Node node) {
//			always adding node to first pos
			Node nbr=head.next;
			node.next=nbr;
			node.prev=head;
			head.next=node;
			nbr.prev=node;
		}
		
		private void removeNode(Node node) {
			Node prevnbr=node.prev;
			Node nextnbr=node.next;
			prevnbr.next=nextnbr;
			nextnbr.prev=prevnbr;
			node.next=node.prev=null;
		}
		
		private void moveToFront(Node node) {
			removeNode(node);
			addNode(node);
		}
//		constructor
		LRU(int capacity){
			cap=capacity;
			cache=new HashMap<Integer,Node>();
			head= new Node();
			tail= new Node();	
		}
		
		
		public int get(int key) {
			Node node=cache.get(key);
			if(node==null) {
				return -1;
			}
			int val=node.value;
			moveToFront(node);
			return val;
		}
		public void put(int key,int value) {
			Node node=cache.get(key);
			if(node==null) {
				Node newnode=new Node();
				newnode.key=key;
				newnode.value=value;
				if(cache.size()==cap) {
//					remove and add 
					Node LRU_node=tail.prev;
					cache.remove(LRU_node.key);
					removeNode(LRU_node);
				}
				cache.put(key,newnode);
				addNode(newnode);
			}else {
				node.value=value;
				moveToFront(node); //recently used
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

	    while (true) {
	      str = br.readLine();
	      String inp[] = str.split(" ");
	      if (inp.length == 1) {
	        break;
	      } else if (inp.length == 2) {
	        System.out.println(obj.get(Integer.parseInt(inp[1])));
	      } else if (inp.length == 3) {
	        obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
	      }
	    }
	}
}
