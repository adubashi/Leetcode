package amazon;

import java.util.*;
public class KClosestPointsToOrigin {
	
	public static void main(String args[]) {
		int[][] points = {{1,3},{-2,2}};
		
		int[][] returnedPointList = kClosestNoPoint(points, 1);
	}
	
	
	
	/*
	 * Solutions:
	 * 
	 * (1) Priority Queue
	 * (2) Sorting 
	 */
	public static int[][] kClosest(int[][] points, int K) {
        List<Point> list = new ArrayList<Point>();
        
        for(int row[] : points) {
            		Point point = new Point(row[0], row[1]);
                list.add(point);
		}
		Collections.sort(list, new Point());	
		
		List<Point> returnList = new ArrayList<Point>();
		//Return Array 
		int[][] retArray = new int[K][2];
		for(int i = 0; i < K; i++) {
			returnList.add(list.get(i));
			retArray[i][0] = list.get(i).x;
			retArray[i][1] = list.get(i).y;		
		}
		
		return retArray; 
    }
	
	
	/*
	 * Solutions:
	 * 
	 * (1) Priority Queue
	 * (2) Sorting 
	 */
	public static int[][] kClosestNoPoint(int[][] points, int K) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int row[] : points) {
            		List<Integer> point = new ArrayList<Integer>();
            		point.add(row[0]);
            		point.add(row[1]);
                list.add(point);
		}
        
        
        Comparator<List<Integer>> pointComparator = new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
	double pointDdistanceFromOrigin = o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1);
 	double pointD1istanceFromOrigin = o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1); 
			      if(pointDdistanceFromOrigin < pointD1istanceFromOrigin) {
			    	  	return -1;
			      } else{
			    	    return 1;
			      } 
			}
        };
        
		Collections.sort(list, pointComparator);	
		//Return Array 
		int[][] retArray = new int[K][2];
		for(int i = 0; i < K; i++) {
			retArray[i][0] = list.get(i).get(0);
			retArray[i][1] = list.get(i).get(1);		
		}		
		return retArray; 
    }
	
	public static int[][] kClosestPriorityQueue(int[][] points, int K) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int row[] : points) {
            		List<Integer> point = new ArrayList<Integer>();
            		point.add(row[0]);
            		point.add(row[1]);
                list.add(point);
		}
        
        
        Comparator<List<Integer>> pointComparator = new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
	double pointDdistanceFromOrigin = o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1);
 	double pointD1istanceFromOrigin = o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1); 
			      if(pointDdistanceFromOrigin < pointD1istanceFromOrigin) {
			    	  	return -1;
			      } else{
			    	    return 1;
			      } 
			}
        };
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(list.size(), pointComparator);		
        for(List<Integer> point : list) {
        		pq.add(point);
        }
        
        
        int i = 0;
        int[][] retArray = new int[K][2];
        while(i < K) {
        		List<Integer> p = pq.poll();
        		retArray[i][0] = p.get(0);
        		retArray[i][1] = p.get(1);
        		i++;
        }
        
        return retArray;
	}
	
	public static int[][] kClosestPriorityQueue2(int[][] points, int K) {
        
        Comparator<int[]> pointComparator = new Comparator<int[]>(){
			@Override
			public int compare(int[] p1, int[] p2) {
	double pointDdistanceFromOrigin = p1[0] * p1[0] + p1[1] * p1[1];
 	double pointD1istanceFromOrigin = p2[0] * p2[0] + p2[1] * p2[1]; 
			      if(pointDdistanceFromOrigin < pointD1istanceFromOrigin) {
			    	  	return -1;
			      } else{
			    	    return 1;
			      } 
			}
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(points.length, pointComparator);		
        for(int row[] : points) {
        		pq.add(row);
        }
        
        
        int i = 0;
        int[][] retArray = new int[K][2];
        while(i < K) {
        		int[] p = pq.poll();
        		retArray[i] = p;
        		i++;
        }
        
        return retArray;
	}
	
	
	
	

}
