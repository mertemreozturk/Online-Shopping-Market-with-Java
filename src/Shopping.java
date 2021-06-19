

public class Shopping {
	private int date;
	private int year;
	private float total;
	private Customer customer;
	
	public Shopping(String date, Customer customer) {
		this.date = Integer.parseInt(date.substring(3, 5));
		this.customer = customer;
		this.year = Integer.parseInt(date.substring(6));
	}
	public void ReadPriceFile(String file) {
		 
		ReadFromFile txt = new ReadFromFile();
		String [] text = txt.readFile(file);
		for(String line:text) {
			String[] x = line.split("\t");
			int startDate = Integer.parseInt(x[2].substring(3, 5));  // convert string to integer
			int endDate = Integer.parseInt(x[3].substring(3, 5));
			int startYear = Integer.parseInt(x[2].substring(6));
			int endYear = Integer.parseInt(x[3].substring(6));
			// x[1] = type of membership x[0] = name of item
			if(x[1].equals(customer.getTypeOfMembership()) && x[0].equals(customer.getProduct().getName()))
			{
				
				if(startDate <= date && date <= endDate && startYear <= year && year <= endYear ) // print the result for each one iteration
				{
					// x[0] = productName, x[4] = price
					float y = Float.parseFloat(x[4]);
					System.out.print(x[0]+"\t"+x[4]+"\t"+customer.getProduct().getQuantity()+"\t");
					System.out.printf("%.1f \n",customer.display(y));
					this.setTotal(customer.display(y));  
				}
			}		
		}
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
		
}
