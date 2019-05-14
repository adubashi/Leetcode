package amazon;

import java.util.*;

class KthLargest {
    
    private PriorityQueue<Integer> pq;
    private int size;

    public KthLargest(int k, int[] nums) {
        //Creates a min heap of size k 
        this.pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer d, Integer d1){
                return d - d1;
            }
        });
        this.size = k;
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }
    /*
     * 1. If the the size of pq is less than the size, then add it.
     * 2. If the top of the min heap is less than val, then pull the top element off and put the new one on.
     * 3. Return the new top.
     */
    public int add(int val) {
        if(this.pq.size() < size){
            pq.offer(val);
        } else if(this.pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return this.pq.peek();
    }
}
