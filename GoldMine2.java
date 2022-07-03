package BACKTRACK;
// can go NEWS from a point
// can start form any point
// collelct max gold 
import java.util.*;
public class GoldMine2 {
	
	private static void getMaxGold(int[][] gold) {
		boolean[][] visited=new boolean[gold.length][gold[0].length];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<gold.length;i++) {
			for(int j=0;j<gold[0].length;j++) {
				if(gold[i][j]!=0 && visited[i][j]==false) {
					ArrayList<Integer> bag=new ArrayList<Integer>();
					travel(gold,i,j,bag,visited);
					int sum=0;
					for(int val:bag) {
						sum+=val;
					}
					if(sum>max) {
						max=sum;
					}
				}	
			}
		}
		System.out.println(max);
	}

	private static void travel(int[][] gold, int i, int j, ArrayList<Integer> bag, boolean[][] visited) {
		if(i<0||j<0||i>=gold.length||j>=gold[0].length||gold[i][j]==0||visited[i][j]==true) {
			return;
		}
		visited[i][j]=true;
		bag.add(gold[i][j]);
		travel(gold, i-1, j, bag, visited); // North
		travel(gold, i, j+1, bag, visited); // East
		travel(gold, i, j-1, bag, visited); // West
		travel(gold, i+1, j, bag, visited); // South
	}

	public static void main(String[] args) {
		int [][] gold= {  {10, 0, 100, 200, 0, 8, 0},
						  {20, 0, 0,   0,   0, 6, 0},
						  {30, 0, 0,   9,  12, 3, 4},
						  {40, 0, 2,   5,   8, 3, 11},
						  {0,  0, 0,   0,   0, 9, 0},
						  {5,  6, 7,   0,   7, 4, 2},
						  {8,  9, 10,  0,   1, 10,8}
						};
		getMaxGold(gold);
	}

	
		
}
