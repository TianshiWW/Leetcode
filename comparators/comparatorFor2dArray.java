import java.util.*;
public class sol {
	public static void main(String[] args) {
		int[][] res = {{1,5,3},{1,2,3},{1,4,5},{2,1,3}};
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] x, int[] y) {
				if (x[0] == y[0]) {
					return x[1] - y[1];
				}
				return x[0] - y[0];
			}
		};
		
		Arrays.sort(res,comp);
		for(int[] a : res) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.print("\n");
		}
	}
}