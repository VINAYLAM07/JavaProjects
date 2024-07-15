package restaurentManagement;

import java.util.Map;
import java.util.Random;

public abstract class Menu {
	protected Map<Integer, Integer> commonOrders;
	protected double PreparationTime;

	public Menu(Map<Integer, Integer> commonOrders) {
		this.commonOrders = commonOrders;
	}

	public Map<Integer, Integer> getcommonOrders() {
		return commonOrders;
	}

	public void setcommonOrders(Map<Integer, Integer> commonOrders) {
		this.commonOrders = commonOrders;
	}

	public double getCommonPreparationTime() {
		return PreparationTime;
	}

	public void setCommonPreparationTime(double PreparationTime) {
		this.PreparationTime = PreparationTime;
	}

	public double commonItemsPrice() {
		double commonItemsPrice = 0;
		for (Map.Entry<Integer, Integer> m : commonOrders.entrySet()) {
			if (m.getKey() == 104) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 50;
					cost +=50;
					PreparationTime += 5;
				}
				System.out.println("Coffee("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 105) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 25;cost +=25;
					PreparationTime += 5;
				}
				System.out.println("Tea("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 106) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 500;cost +=500;
					PreparationTime += 5;
				}
				System.out.println("Beer("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 107) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 350;cost +=350;
					PreparationTime += 5;
				}
				System.out.println("Coke("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 108) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 75;cost +=75;
					PreparationTime += 5;
				}
				System.out.println("MilkShake("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 109) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 200;cost +=200;
					PreparationTime += 5;
				}
				System.out.println("French-fries("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 110) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 120;cost +=120;
					PreparationTime += 5;
				}
				System.out.println("Maggi("+m.getValue()+"):-"+cost);
			} else if (m.getKey() == 111) {
				double cost=0;
				for (int i = 0; i < m.getValue(); i++) {
					commonItemsPrice += 110;cost +=110;
					PreparationTime += 5;
				}
				System.out.println("Pasta("+m.getValue()+"):-"+cost);
			}

		}
		return commonItemsPrice;
	}

	public abstract double totalPrice();

	public String generateTokenNumber() {
		char[] c = { 'X', 'Y', 'Z', 'V', 'N', 'B', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		Random r = new Random();
		StringBuffer token = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			int index = r.nextInt(c.length - 1);
			token.append(String.valueOf(c[index]));
		}
		if (token.toString().matches("[XYZVNB0-9]{10}"))
			return token.toString();
	return "invalid";
	}

}
