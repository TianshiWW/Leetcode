public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here

        boolean flag = false;
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,0);
            }
            int n = map.get(num) + 1;
            map.put(num, n);
            if (num == number) {
                flag = true;
                break;
            }
        }

        if (flag == false) {
            return -1;
        }

        for (int num : nums) {
            if(map.get(num) == 1) {
                return num;
            }
            if (num == number) {
               break; 
            }
        }
        return -1;
        
    }
}