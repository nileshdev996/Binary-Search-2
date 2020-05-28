// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
       if(nums == null || nums.length == 0) return new int[]{-1, -1};
       if(nums[0] == target && nums[nums.length -1] == target) return new int[]{0, nums.length - 1};
        
       int leftIndex = binarySearchLeft(nums, target);
       int rightIndex = binarySearchRight(nums, target);
       return new int[]{leftIndex, rightIndex};
        
    }
    
    private int binarySearchLeft(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                }else if (nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                }
            }
                
            if(nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        return -1;
        
    }
    
    private int binarySearchRight(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                }else if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                }
            }
                
            if(nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
