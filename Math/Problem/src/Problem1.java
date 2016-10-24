

import org.joda.*;
import org.joda.time.format.*;
import org.joda.time.*;
import java.util.*;
public class Problem1 {
	
	public static void main(String args[]){
		
		DateTime early = new DateTime(-1000000, 1, 1, 0, 0);
		
		System.out.println(early);
		System.out.println(early.plusDays(1));
		
		
		DateTime time = new DateTime(801, 1, 1, 0, 0);
		DateTime endtime = new DateTime(1201,1,1,0,0);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("EEEE");
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("Sunday", 0);
		map.put("Monday", 0);
		map.put("Tuesday", 0);
		map.put("Wednesday", 0);
		map.put("Thursday", 0);
		map.put("Friday", 0);
		map.put("Saturday", 0);
		int i = 0;
		for(time = time ; time.isBefore(endtime); time = time.plusDays(1)){
			System.out.println(time);
			String strEnglish = fmt.print(time);
			System.out.println(strEnglish);
			System.out.println(time.getDayOfMonth());
				if(time.getDayOfMonth() == 13){
					System.out.println("13th day" );
					int val = map.get(strEnglish);
					map.put(strEnglish, val + 1);
					i++;
				}
		}
		System.out.println("For Leap Years");
		System.out.println("Days: " + i);
		System.out.println(map);
		
	}

}
