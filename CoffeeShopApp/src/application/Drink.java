package application;

public class Drink {
	private int size = -1;
	private int type = -1;

	final public static int SMALL = 0;
	final public static int MEDIUM = 1;
	final public static int LARGE = 2;

	final public static int COFFEE = 0;
	final public static int TEA = 1;
	final public static int SODA = 2;
	final public static int BLENDED = 3;

	public Drink(){

	}

	public Drink(int size, int type){
		if( (size >= 0 && size <= 2) && ( type >= 0 && type <=3) ){
			this.size = size;
			this.type = type;
		}
	}

	public void setSize(int size){
		if(size == 0){
			this.size = SMALL;
		}
		else if(size == 1){
			this.size = MEDIUM;
		}
		else if(size == 2){
			this.size = LARGE;
		}
	}

	public int getSizeInt(){
		return this.size;
	}

	public String getSize(){
		String sizeOfDrink = "";
		if(size == SMALL){
			sizeOfDrink = "Small";
		}
		else if(size == MEDIUM){
			sizeOfDrink ="Medium";
		}
		else if(size == LARGE){
			sizeOfDrink = "Large";
		}
		else{
			sizeOfDrink = "";
		}
		return sizeOfDrink;
	}

	public void setType(int type){
		if(type == 0){
			this.type = COFFEE;
		}
		else if(type == 1){
			this.type = TEA;
		}
		else if(type == 2){
			this.type = SODA;
		}
		else if(type == 3){
			this.type = BLENDED;
		}
	}

	public int getTypeInt(){
		return this.type;
	}

	public String getType(){
		String getType = "";
		if(type == COFFEE){
			getType = "coffee";
		}
		else if (type == TEA){
			getType = "tea";
		}
		else if (type == SODA){
			getType = "soda";
		}
		else if(type == BLENDED){
			getType = "blended";
		}
		else{
			getType = "";
		}
		return getType;
	}


	public double calcCost(){
		double cost = 0.90;

		//Options for a small drink
		if(size == SMALL && type == COFFEE){
			cost = 0.90;
		}
		else if(size == SMALL && type == TEA){
			cost = 1.25;
		}
		else if(size == SMALL && type == SODA){
			cost = 1.25;
		}
		else if(size == SMALL && type == BLENDED){
			cost = 2.50;
		}
		//Options for a medium drink
		else if(size == MEDIUM && type == COFFEE){
			cost = 1.60;
		}
		else if(size == MEDIUM && type == TEA){
			cost = 2.00;
		}
		else if(size == MEDIUM && type == SODA){
			cost = 2.00;
		}
		else if(size == MEDIUM && type == BLENDED){
			cost = 3.00;
		}
		//Options for a large drink
		else if(size == LARGE && type == COFFEE){
			cost = 2.00;
		}
		else if(size == LARGE && type == TEA){
			cost = 2.50;
		}
		else if(size == LARGE && type == SODA){
			cost = 2.50;
		}
		else if(size == LARGE && type == BLENDED){
			cost = 3.50;
		}
		else{
			cost = 0.90;
		}
		return cost;
	}

	public String toString(){
		String output = String.format("%s %s, $%1.2f     ", getSize(), getType(), calcCost());
		return output;

	}


}