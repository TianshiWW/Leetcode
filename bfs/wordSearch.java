class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict= new HashSet<>(wordList);   
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(beginWord);
        set.add(beginWord);
        
        int length = 0;
        while(!q.isEmpty()){
            length++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String wordNow = q.remove();
                if (wordNow.equals(endWord)){
                    return length;
                }
                ArrayList<String> nextWords = this.getNextWord(wordNow,dict);
                for(String nextWord:nextWords){
                    if(!set.contains(nextWord)){
                        set.add(nextWord);
                        q.add(nextWord);
                    }             
                }
            }
        }
        return 0;
     }
    
    private String replace(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private ArrayList<String> getNextWord(String wordNow,Set<String> wordList){
        ArrayList<String> nextWordList = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++){
            int length = wordNow.length();
            for(int i = 0;i<length;i++){
                String changedWord = this.replace(wordNow,i,c);
                if(wordList.contains(changedWord)){
                    nextWordList.add(changedWord);
                }
            }
        }
        return nextWordList;
    }
}