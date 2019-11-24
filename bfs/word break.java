class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!visited.contains(curr)) {
               for(int end = curr + 1; end <= s.length(); end++) {
                   if (wordSet.contains(s.substring(curr,end))) {
                       if(end == s.length()) {
                           return true;
                       }
                       q.offer(end);
                   }
               } 
            }
            visited.add(curr);
        }
        return false;
    }
}
