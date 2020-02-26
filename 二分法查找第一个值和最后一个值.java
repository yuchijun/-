class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int first = findFirst(nums, target);
        if(first == -1){
            return 0;
        }
        int last = findLast(nums,target);
        return last - first + 1;

    }

    public int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + ((high-low)>>1);
            if(nums[mid]>target){
                high = mid - 1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                if(mid == 0 || nums[mid - 1] != target ) return mid;
                else high = mid -1;
                
            }
        }
        return -1;
    }

    public int findLast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + ((high-low)>>1);
            if(nums[mid]>target){
                high = mid - 1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                if(mid == nums.length-1 || nums[mid + 1] != target ) return mid;
                else low = mid + 1;
                
            }
        }
        return low;
    }
}