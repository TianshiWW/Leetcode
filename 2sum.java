2 twoSum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


/**
Solution1 : HashMap
add HashMap<Integer,Integer> map : 
key -> remains
value ->  index of the remains
if(!map.containsKey(nums[i])){
    map.put(remains,i);
}
if(containsKey){
    return res;
}
*/


class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
           return res; 
        }

        for (int i = 0; i < nums.length; i++) {
            int remains = target - nums[i];
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else {
              map.put(remains,i);  
            }
        }
        return res;
    }
}

/**
Only returns the number, use hashSet
*/
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int num : nums) {
            int remains = target - num;
            if (set.contains(num)){
                res[0] = target - num;
                res[1] = num;
            } else {
                set.add(remains);
            }
        }
        return res;
    }
}
