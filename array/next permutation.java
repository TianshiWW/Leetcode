// Search from right, the first element nums[i] < nums[i+1] is where we split the array. Why do we do so? Because for a decreasing array, we cannot make it larger. For example, can you find a permutation > [5 4 2]?
// [1 3 5 4 2]
// .....^<<<<<
// Now, we need to find the smallest permutation that is larger than [3 5 4 2]. To do so, we search from right, find the first element nums[j] > nums[i].
// [1 3 5 4 2]
// .....^......^<<
// Swap nums[j] and nums[i].
// [1 4 5 3 2]
// .....^......^
// But [4 5 3 2] is still not the smallest permutation > [3 5 4 2]. We need to ensure the subarray after 4 is non-decreasing to ensure smallest lexicographical order. We do so by reverse the array after nums[i].
// [1 4 2 3 5]
// .....^


class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i>= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    
}