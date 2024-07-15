package restaurentManagement;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class VegMenu extends Menu{

	private Map<Integer, Integer> nonVegOrders;
	private double totalprice;

	public VegMenu(List<Map> orders) {
		super(orders.get(1));
		nonVegOrders = orders.get(0);
	}

	public double totalPrice() {
		double commonItemsPrice = commonItemsPrice();
		double nonVegItemsPrice = 0;
		for (Map.Entry<Integer, Integer> m : nonVegOrders.entrySet()) {
			if (m.getKey() == 101) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					nonVegItemsPrice += 96;cost+=96;
					PreparationTime += 5;
				}
				System.out.println("Masala Channa("+m.getValue()+"):-"+cost);
			}else if (m.getKey() == 102) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					nonVegItemsPrice += 147;cost+=147;
					PreparationTime += 5;
				}
				System.out.println("Cheese Burger("+m.getValue()+"):-"+cost);
			}else if (m.getKey() == 103) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					nonVegItemsPrice += 256;cost+=256;
					PreparationTime +=5;
				}
				System.out.println("Panner Biryani("+m.getValue()+"):-"+cost);
			}
		}
		return commonItemsPrice + nonVegItemsPrice;
	}

	

}
