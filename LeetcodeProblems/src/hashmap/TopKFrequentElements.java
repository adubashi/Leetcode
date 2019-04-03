package hashmap;

import java.util.*;

public class TopKFrequentElements {
	
	//Use a hashmap to get the counts, then get the next k
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq =
	            new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
	    pq.addAll(map.entrySet());
	    
	    List<Integer> ret = new ArrayList<>();
	    for(int i = 0; i < k; i++){
	        ret.add(pq.poll().getKey());
	    }    
	    return ret;
    }
	
	public List<Integer> topKFrequentSort(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		
		List<Map.Entry<Integer, Integer> > list = new ArrayList<Map.Entry<Integer, Integer> >(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
		Collections.reverse(list);
        
	    List<Integer> ret = new ArrayList<>();
		for(int i = 0; i < k && i < list.size(); i++) {
			ret.add(list.get(i).getKey());
		}
		return ret;
    }

}
