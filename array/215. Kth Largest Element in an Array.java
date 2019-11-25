// min heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length <= 0 || nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (pq.peek() >= num) {
                    continue;
                } else {
                    pq.poll();
                    pq.add(num);
                }
            }
            
        }
        return pq.poll();
    }
}

// sort
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}