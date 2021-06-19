

public class Market {
	private String dataOne;
	private String dataTwo;
	
	public Market(String dataOne, String dataTwo) {
		ReadFromFile txt = new ReadFromFile();
		String [] text = txt.readFile(dataOne); // read shoppingList
		
		for(String line:text) {   // give a one word for each iteration
			String [] x = line.split("\t");
			Product product = new Product();
			System.out.println("---"+ x[0] + "---");
			
			float total = 0;  // initial value
			int j = 0;		   // initial value
			while(true) {		// set all item of name and quantity 
				if((2*j+3) == x.length) {  // finish the loop if variable is equal to the list of last index
					break;
				}
				else { // set 
					product.setName(x[2*j+3]);
					int a = Integer.parseInt(x[2*j+4]);
					product.setQuantity(a);
					Customer customer = new Customer();
					customer.setName(x[0]);
					customer.setTypeOfMembership(x[1]);
					customer.setProduct(product);
					
					Shopping shopping = new Shopping(x[2], customer);  // send data of date and features of customer
					shopping.ReadPriceFile(dataTwo);  // calculate total payment for each item 
					total += shopping.getTotal();
					j++;  // next item
				}	
			}
			System.out.println("Total" + "\t" + total);
		}
	}
	public String getDataOne() {
		return dataOne;
	}
	public void setDataOne(String dataOne) {
		this.dataOne = dataOne;
	}
	public String getDataTwo() {
		return dataTwo;
	}
	public void setDataTwo(String dataTwo) {
		this.dataTwo = dataTwo;
	}
}
