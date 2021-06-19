

public class Customer {
	private String name;
	private String TypeOfMembership;
	private Product product;
	
	public Customer() {
		
	}
	
	public Customer(String name, String TypeOfMembership, Product product) {
		this.setName(name);
		this.TypeOfMembership = TypeOfMembership;
		this.product = product;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfMembership() {
		return TypeOfMembership;
	}
	public void setTypeOfMembership(String typeOfMembership) {
		TypeOfMembership = typeOfMembership;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public float display(float price) {  // calculate total payment for one item
		product.setPrice(price);
		return product.calculate(product.getPrice(), product.getQuantity());		
	}
}
