class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1],new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
               q.offer(i); 
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int id = q.poll();
            res.add(id);
            List<Integer> nexts = map.get(id);
            if (nexts != null) {
               for(int next : nexts) {
                   indegree[next]--;
                   if (indegree[next] == 0) {
                      q.offer(next); 
                   }
               } 
            }
        }
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}