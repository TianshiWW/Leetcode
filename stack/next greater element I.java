class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int num = stack.pop();
                map.put(num, nums2[i]);
            }     
            stack.push(nums2[i]);
        }
        
        int[] res = new int[nums1.length];
        int i = 0;
        for (int num : nums1) {
            int val = map.getOrDefault(num, -1);
            res[i] = val;
            i++;
        }
        return res;
        
    }
}