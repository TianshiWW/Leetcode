
Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

/**
* 解法：
首先建立map
其次遍历每个words，两两比较
逻辑  
for每两个单词，for最短的那个单词长度：
    a:
    if(ca == cb) continue;
    else {
        if(map[ca-'a'] > map[cb-'a']) return false
        else{
            go to a; 这里是假如前面string的character已经小于后面的，不需要继续比较 
        }
    }
    如果一直都相等，那增加一个判断，如果a的长度大于b的长度，return false
    
*/
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            map[ch - 'a'] = i;
        }
        breakpoint:
        for (int i = 0; i < words.length - 1; i++) {
            String wordA = words[i];
            String wordB = words[i + 1];
            int len = Math.min(wordA.length(),wordB.length());
            
            for (int j = 0; j < len; j++) {
                char ca = wordA.charAt(i);
                char cb = wordB.charAt(i);
                if (ca == cb) {
                    continue;
                } else { // if not same
                    if(map[ca - 'a'] > map[cb-'a']) {
                        return false;
                    } else {
                        // 'h' < 'l'
                        // go to next word
                        continue breakpoint;
                    }
                    
                }
            }
            // if two words are all the same in shortest elements, we have to check that the length of the wordA is smaller than wordB
            if (wordA.length() > wordB.length()) {
                return false;
            }
            
        }
        // after checking all the words,
        return true;
        
    }
}