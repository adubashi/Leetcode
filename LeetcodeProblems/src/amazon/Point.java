package amazon;

import java.util.*;

public class Point implements Comparator<Point>, Comparable<Point>{
	Point(){
		
	}
	
	Point(int x, int y){
		this.x =  x;
		this.y =  y;
	}
	
	int x; 
	int y; 
	
	@Override
	public String toString() {
		return "x " + this.x + " y " + this.y;
		
	}
	
	@Override
	public int compare(Point d, Point d1) {
	      double pointDdistanceFromOrigin = Math.sqrt(Math.pow(d.y - 0,2) - Math.pow(d.x - 0, 2));  
	      double pointD1istanceFromOrigin = Math.sqrt(Math.pow(d1.y - 0,2) - Math.pow(d1.x - 0, 2));  
	      
	      
	      if(pointDdistanceFromOrigin > pointD1istanceFromOrigin) {
	    	  	return 1;
	      } else if(pointDdistanceFromOrigin == pointD1istanceFromOrigin) {
	    	    return 0;
	      } else {
	    	  	return -1;
	      }
	   }

	@Override
	public int compareTo(Point o) {
		  double pointDdistanceFromOrigin = Math.sqrt(Math.pow(o.y - 0,2) - Math.pow(o.x - 0, 2));  
	      double pointD1istanceFromOrigin = Math.sqrt(Math.pow(this.y - 0,2) - Math.pow(this.x - 0, 2));  
	      
	      
	      if(pointDdistanceFromOrigin > pointD1istanceFromOrigin) {
	    	  	return 1;
	      } else if(pointDdistanceFromOrigin == pointD1istanceFromOrigin) {
	    	    return 0;
	      } else {
	    	  	return -1;
	      }
	}

}
