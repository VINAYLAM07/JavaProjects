package restaurentManagement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {
	String[] orderItems;
	Map<Integer, Integer> VegNonVeg = new HashMap<Integer,Integer>();
	Map<Integer, Integer> commonItems = new HashMap<Integer,Integer>();
	public Utility(String order) {
		orderItems = order.split(":");

	}
	public List<Map> orderDetails() {
		
		for(int i=0;i<orderItems.length-1;i++) {
			
			if(Integer.parseInt(orderItems[i])>=104)
				commonItems.put(Integer.parseInt(orderItems[i]), Integer.parseInt(orderItems[i+1]));	
			
			else if(Integer.parseInt(orderItems[i])<=104)
				VegNonVeg.put(Integer.parseInt(orderItems[i]), Integer.parseInt(orderItems[i+1]));
			else
				System.out.println("Item code is not defined" + orderItems[i]);
			i++;	
		}
		return Arrays.asList(VegNonVeg,commonItems);
	}
		
}
