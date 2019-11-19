class R {
	private String name,
		webAddress,
		cuisine;
	
	public R (String name, String webAddress, String cuisine) {
		this.name = name;
		this.webAddress = webAddress;
		this.cuisine = cuisine;
	}

	public String getName(){
		return ("Name: " + this.name);
	}
}

class Restaurant {
	public static void main(String[] args) {
		R dominos = new R("Dominos", "www.dominos.co.uk", "Pizza");
		R yosushi = new R("Yo Sushi!", "www.yosushi.co.uk", "Sushi");
		R fiveguys = new R("Five Guys", "www.fiveguys.co.uk", "Burger");

		System.out.println(dominos.getName());
	}
}
