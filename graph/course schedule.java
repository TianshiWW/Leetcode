
//BFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites){
            if(!map.containsKey(prerequisite[1])){
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
        
        while (!q.isEmpty()) {
            int courseId = q.poll();
            List<Integer> nextCourses = map.get(courseId);
            if(nextCourses != null) {
                for (int nextCourse : nextCourses) {
                    indegree[nextCourse]--;
                    if(indegree[nextCourse] == 0) {
                        q.offer(nextCourse);
                    }
                }    
            }

        }
        
        for(int i : indegree) {
            if (i > 0) {
                return false;
            } 
        }
        return true;
    }
}


//DFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] prerequisite : prerequisites){
            if(!map.containsKey(prerequisite[1])){
                map.put(prerequisite[1],new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0 && !visited[i]) {
                dfs(i,indegree,map,visited); 
            }
        }

        for(int i : indegree) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(int id, int[] indegree, HashMap<Integer,List<Integer>> map, boolean[] visited) {
        if(indegree[id] != 0) {
            return;
        }
        visited[id] = true;
        List<Integer> nexts= map.get(id);
        if (nexts != null) {
            for(int nextId : nexts) {
                indegree[nextId]--;
                dfs(nextId, indegree,map,visited);    
            }
        }
        return;
    }
}


