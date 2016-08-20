package Company1Search.TheSkylineProblem218;

public class Skyline {
	
	public Strip[] arr;
	int capacity;
	int n;
	
	public int count() {
		return n;
	}
	
	// Constructor
    public Skyline(int cap)
    {
        capacity = cap;
        arr = new Strip[cap];
        n = 0;
    }
    
    public void append(Strip st){
    	// Check for redundant strip, a strip is
        // redundant if it has same height or left as previous
        if (n>0 && arr[n-1].height == st.height)
            return;
        if (n>0 && arr[n-1].left == st.left)
        {
            arr[n-1].height = Math.max(arr[n-1].height, st.height);
            return;
        }
 
        arr[n] = st;
        n++;
    }
    
    public Skyline merge(Skyline other){
    	Skyline res = new Skyline(this.n + other.n);
        // To store current heights of two skylines
        int h1 = 0, h2 = 0;
        // Indexes of strips in two skylines
        int i = 0, j = 0;
        
        while(i < this.n && j < other.n){
        	if(this.arr[i].left < other.arr[i].left){
        		int x1 = this.arr[i].left;
        		h1 = this.arr[i].height;
                 // Choose height as max of two heights
                int maxh = Math.max(h1, h2);
                Strip strip = new Strip(x1,maxh);
                res.append(strip);
                i++;
        	} else {
        		int x2 = other.arr[i].left;
        		h2 = other.arr[i].height;
        		
        		int maxh = Math.max(h1,h2);
        		Strip strip = new Strip(x2, maxh);
        		res.append(strip);
        		j++;
        	}
        }
        
     // If there are strips left in this skyline or other
        // skyline
        while (i < this.n)
        {
            res.append(this.arr[i]);
            i++;
        }
        while (j < other.n)
        {
            res.append(other.arr[j]);
            j++;
        }
        return res;
    }

}
