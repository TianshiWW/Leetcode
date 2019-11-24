class Solution {
    public int scheduleCourse(int[][] courses) {
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] x, int[] y) {
		        if(x[1] == y[1]) {
		          return x[0] - y[0];
	    	    }
				return x[1] - y[1];
			}
		};
        Arrays.sort(courses,comp);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.offer(course[0]);
            if (time > course[1]) {
               time -= pq.poll(); 
            }
        } 
        return pq.size();
        
    }
}
