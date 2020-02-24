package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainController {

	/*
	 *
	 *
	 * I wasn't sure if for every time you open the application
	 * you wanted the id to be continuous from the last order on the csv list
	 * or if you wanted to start it all over again from 1
	 *
	 * Therefore I have two methods
	 *
	 * The one already visible is the first kind where if the csv file
	 * had six orders, then the next order created would have id = 7
	 *
	 * The commented out method and field is used if you wanted it
	 * the second way if the csv file had six orders then the
	 * next order created when you open the app has id = 1
	 *
	 *
	 * */

	private Order order = new Order();

	@FXML
	private Button smallCoffee;
	@FXML
	private Button mediumCoffee;
	@FXML
	private Button largeCoffee;
	@FXML
	private Button smallTea;
	@FXML
	private Button mediumTea;
	@FXML
	private Button largeTea;
	@FXML
	private Button smallSoda;
	@FXML
	private Button mediumSoda;
	@FXML
	private Button largeSoda;
	@FXML
	private Button smallBlended;
	@FXML
	private Button mediumBlended;
	@FXML
	private Button largeBlended;

	@FXML
	private Button completeOrder;

	@FXML
	private ListView<String> currentOrderList;
	@FXML
	private ListView<String> newAdded;

	@FXML
	private Label TotalCost;

	public void completeOrderClick(ActionEvent event){

		String fileName = "Orders.csv";
		File sourceFile = new File(fileName);

		if(!sourceFile.exists()){
			try {
				order.setId(1);
				PrintWriter writer = new PrintWriter(fileName);
				writer.println(order.listOrder());
				writer.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else{
			try {
				int countIDnumber = 1;
				PrintWriter writer = new PrintWriter("temporary.csv");
				Scanner input = new Scanner(sourceFile);
				while(input.hasNext()){
					String copyString = input.nextLine();
					writer.println(copyString);
					countIDnumber++;
				}
				order.setId(countIDnumber);
				writer.println(order.listOrder());

				File newFile = new File("temporary.csv");
				sourceFile.delete();
				newFile.renameTo(new File(fileName));

				input.close();
				writer.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		TotalCost.setText("$0.00");
		currentOrderList.getItems().clear();
		newAdded.getItems().add(order.idAndTotal());
		order = new Order();
	}

	/*
	//Method for having the first order id=1 every time the app is opened

	private int count = 1;
	public void completeOrderClick(ActionEvent event){

		String fileName = "Orders.csv";
		File sourceFile = new File(fileName);

		if(!sourceFile.exists()){
			try {
				order.setId(count);
				PrintWriter writer = new PrintWriter(fileName);
				writer.println(order.listOrder());
				writer.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				PrintWriter writer = new PrintWriter("temporary.csv");
				Scanner input = new Scanner(sourceFile);
				while(input.hasNext()){
					String copyString = input.nextLine();
					writer.println(copyString);
				}
				order.setId(count);
				writer.println(order.listOrder());

				File newFile = new File("temporary.csv");
				sourceFile.delete();
				newFile.renameTo(new File(fileName));

				input.close();
				writer.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		TotalCost.setText("$0.00");
		currentOrderList.getItems().clear();
		newAdded.getItems().add(order.idAndTotal());
		order = new Order();
		count++;
	}


*/

	//Methods for adding Coffee Drinks
	public void smallCoffeeClick(ActionEvent event){
		Drink smallCoffee = new Drink(Drink.SMALL, Drink.COFFEE);
		order.addDrink(smallCoffee);
		currentOrderList.getItems().add(smallCoffee.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void mediumCoffeeClick(ActionEvent event){
		Drink mediumCoffee = new Drink(Drink.MEDIUM, Drink.COFFEE);
		order.addDrink(mediumCoffee);
		currentOrderList.getItems().add(mediumCoffee.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void largeCoffeeClick(ActionEvent event){
		Drink largeCoffee = new Drink(Drink.LARGE, Drink.COFFEE);
		order.addDrink(largeCoffee);
		currentOrderList.getItems().add(largeCoffee.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	//Methods for adding Tea Drinks
	public void smallTeaClick(ActionEvent event){
		Drink smallTea = new Drink(Drink.SMALL, Drink.TEA);
		order.addDrink(smallTea);
		currentOrderList.getItems().add(smallTea.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void mediumTeaClick(ActionEvent event){
		Drink mediumTea = new Drink(Drink.MEDIUM, Drink.TEA);
		order.addDrink(mediumTea);
		currentOrderList.getItems().add(mediumTea.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void largeTeaClick(ActionEvent event){
		Drink largeTea = new Drink(Drink.LARGE, Drink.TEA);
		order.addDrink(largeTea);
		currentOrderList.getItems().add(largeTea.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	//Methods for adding Soda Drinks
	public void smallSodaClick(ActionEvent event){
		Drink smallSoda = new Drink(Drink.SMALL, Drink.SODA);
		order.addDrink(smallSoda);
		currentOrderList.getItems().add(smallSoda.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void mediumSodaClick(ActionEvent event){
		Drink mediumSoda = new Drink(Drink.MEDIUM, Drink.SODA);
		order.addDrink(mediumSoda);
		currentOrderList.getItems().add(mediumSoda.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void largeSodaClick(ActionEvent event){
		Drink largeSoda = new Drink(Drink.LARGE, Drink.SODA);
		order.addDrink(largeSoda);
		currentOrderList.getItems().add(largeSoda.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	//Methods for adding Blended Drinks
	public void smallBlendedClick(ActionEvent event){
		Drink smallBlended = new Drink(Drink.SMALL, Drink.BLENDED);
		order.addDrink(smallBlended);
		currentOrderList.getItems().add(smallBlended.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void mediumBlendedClick(ActionEvent event){
		Drink mediumBlended = new Drink(Drink.MEDIUM, Drink.BLENDED);
		order.addDrink(mediumBlended);
		currentOrderList.getItems().add(mediumBlended.toString());
		TotalCost.setText(order.returnStringTotal());
	}

	public void largeBlendedClick(ActionEvent event){
		Drink largeBlended = new Drink(Drink.LARGE, Drink.BLENDED);
		order.addDrink(largeBlended);
		currentOrderList.getItems().add(largeBlended.toString());
		TotalCost.setText(order.returnStringTotal());
	}




}
