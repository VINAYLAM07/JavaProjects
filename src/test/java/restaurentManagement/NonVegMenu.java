package restaurentManagement;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class NonVegMenu extends Menu {

	private Map<Integer, Integer> nonVegOrders;
	private double totalprice;

	public NonVegMenu(List<Map> orders) {
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
					nonVegItemsPrice += 134;cost+=134;
					PreparationTime += 5;
				}
			System.out.println("ChickenBurger("+m.getValue()+"):-"+cost);
			}else if (m.getKey() == 102) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					nonVegItemsPrice += 250;cost+=250;
					PreparationTime += 5;
				}
			System.out.println("Chicken-Biryani("+m.getValue()+"):-"+cost);
			}else if (m.getKey() == 103) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					nonVegItemsPrice += 456;cost+=456;
					PreparationTime +=5;
				}
			System.out.println("Mutton("+m.getValue()+"):-"+cost);
			}
			
		}
		return commonItemsPrice + nonVegItemsPrice;
	}

}
