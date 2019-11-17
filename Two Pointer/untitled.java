
42. Trapping Rain Water

Solution:
TwoPointers

边界判断

left,right
leftHeight, rightHeight

while(left < right) {
    leftHeight > rightHeight 移动右指针 比较大小： 如果新的高度小于现在的高度， res里加上高度差，否则新的高度更高的话，将leftHeight用新的替换掉
    相反的，如果rightheight 大于等于left， 继续比较新的left和之前的left高度，同上
}
最后返回结果



class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;    
        }
        int res= 0;
        int left = 0;
        int right = height.length - 1;
        if (left >= right) {
           return res; 
        }
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < right) {
            if(leftHeight < rightHeight) {
                left++;
                if (height[left] < leftHeight) {
                   res += leftHeight - height[left]; 
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (height[right] < rightHeight) {
                   res += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return res;
    }
}