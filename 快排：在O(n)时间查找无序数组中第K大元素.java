class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        //转换一下，target就是第k大元素的坐标
        int target = len-k;
        while(true){
            int index = partition(nums,left,right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index+1;//下一次遍历(index+1,right)的值
            }else{
                right = index-1;//left不变，遍历(left,index-1)的值
            }
        }
    }
    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int j = left; //j是游标,i也是游标;
        for(int i=left+1; i<=right; ++i){
            if(nums[i]<pivot){
                j++;
                swap(nums,j,i); //交换游标i,j所指的值的位置;
            }
        }//循环结束后，j的位置就应该是pivot的位置;
        swap(nums,j,left);//交换j和Pivot的值，使得nums[j]=pivot;
        return j;//此时，(left,j-1)<nums[j]，nums[j]=pivot,nums[j]<(j+1,right);

    }

    //交换两个元素
    public void swap(int[] nums,int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}