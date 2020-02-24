package application;

import java.util.ArrayList;
import java.util.Date;

public class Order extends ArrayList<Drink>{
	private int id;
	private Date time;
	private int size = 0;

	public Order() {
		time = new Date();
	}

	public double calculateOrderTotal() {
		double cost = 0;
		for (int i = 0; i < size; i++) {
			cost += get(i).calcCost();
		}

		return cost;
	}

	public String returnStringTotal(){
		String string = String.format("$%.2f", calculateOrderTotal());
		return string;
	}

	public String toString() {
		System.out.println();
		System.out.println("Receipt:");
		for (int i = 0; i < size; i++) {
			System.out.println(get(i));
		}
		System.out.println("-------------------------------------");
		System.out.printf("Total cost: $%.2f\n", calculateOrderTotal());
		System.out.println(time);
		return null;
	}

	public String listOrder(){
		String listString = "";
		listString += id + ", ";
		for(int i = 0; i < size; i++){
			listString += get(i).getSizeInt();
			listString += "; ";
			listString += get(i).getTypeInt();
			listString += ", ";
		}
		String returnString = listString.substring(0, listString.length() - 1);
		return returnString;
	}

	public String idAndTotal(){
		return String.format("%d, %s", id, returnStringTotal());
	}

	public void addDrink(Drink drink){
		add(drink);
		size++;
	}

	public int getSize(){
		return size;
	}

	public int getArraySize(){
		return size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

}