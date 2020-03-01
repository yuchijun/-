class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[]{};
        }
        int len = arr.length;
        //对arr数组的前k个数建堆
        if(len == k){
            return arr;
        }
        int[] heap = new int[k];
        for(int i=0; i<k; ++i){
            heap[i] = arr[i];
        }
        buildHeap(heap);

        //把比堆顶元素小的往上放，调再整大顶堆
        for(int i=k; i<len; ++i){
            if(heap[0]>arr[i]){
                heap[0] = arr[i];
                heapify(heap, 0);
            }
        }
        return heap;

    }

    //建堆
    public void buildHeap(int[] nums){
        int lastNode = nums.length - 1;
        int startHeapify = (lastNode - 1) / 2; //找到第一个非叶子节点的节点
        heapify(nums,startHeapify);
    }

    //生成大顶堆
    public void heapify(int[] nums, int i){
        int len = nums.length;
        if(i>len){
            return;
        }
        int max = i;
        int c1 = (i<<1) + 1; //i的左子节点
        int c2 = (i<<1) + 2; //i的右子节点
        if(c1 < len && nums[c1] >nums[max]){
            max = c1;
        }
        if(c2 < len && nums[c2] >nums[max]){
            max = c2;
        }
        if(max != i){
            swap(nums,max,i);
            heapify(nums, max);
        }
    }
    
    //交换
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}