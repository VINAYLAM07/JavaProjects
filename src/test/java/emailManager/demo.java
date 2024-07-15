package emailManager;
import java.math.BigDecimal;
class foodOrder{
    String itemName;
    BigDecimal itemPrice;
    int quantity;
    String deliveryAddress; 
    String specialInstructions;
    boolean isExpressDelivery;
    boolean applyDiscount;
    
    public foodOrder(String itemName, BigDecimal itemPrice, int quantity,String deliveryAddress, String specialInstructions,boolean isExpressDelivery, boolean applyDiscount){
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.quantity=quantity;
        this.deliveryAddress=deliveryAddress;
        this.specialInstructions=specialInstructions;
        this.isExpressDelivery=isExpressDelivery;
        this.applyDiscount=applyDiscount;
        
    }

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public boolean isExpressDelivery() {
		return isExpressDelivery;
	}

	public void setExpressDelivery(boolean isExpressDelivery) {
		this.isExpressDelivery = isExpressDelivery;
	}

	public boolean isApplyDiscount() {
		return applyDiscount;
	}

	public void setApplyDiscount(boolean applyDiscount) {
		this.applyDiscount = applyDiscount;
	}
    
    
    
    
}
