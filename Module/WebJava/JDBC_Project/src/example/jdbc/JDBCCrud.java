package example.jdbc;

import java.util.Collection;
import java.util.Scanner;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;
import example.jdbc.pojo.Restaurant;

public class JDBCCrud {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		DaoInterface<Restaurant, Integer> dao = new RestaurantDao();
		boolean exit = true;
		
		while (exit) {
			System.out.println("Select Choice: \n1. Get All. \n2. Get one restaurant. \n3. Add new Restaurant. \n4. Update existing restaurant. \n5. Delete restaurant. \n0. Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				Collection<Restaurant> restaurants = dao.retrieveAll();
				restaurants.stream().forEach(restaurant -> System.out.println(restaurant));
				break;
			}
			case 2:{
				System.out.println("Enter Id of restaurant: ");
				Restaurant res = dao.retrieveOne(sc.nextInt());
				if(res != null) {
					System.out.println(res);	
				}else {
					System.out.println("Not found!!");
				}
				break;
			}
			case 3:{
				System.out.println("Enter restaurant id, name, cuisin type, branch count");
				dao.create(new Restaurant(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
				break;
			}
			case 4:{
				System.out.println("Enter Id of restaurant to update: ");
				Restaurant res = dao.retrieveOne(sc.nextInt());
				if(res != null) {
					System.out.println("Enter restaurant name, cuisin type, branch count to update");
					res.setName(sc.next());
					res.setCuisin(sc.next());
					res.setBranchCount(sc.nextInt());
					dao.updateOne(res);
				}else {
					System.out.println("Not found!!");
				}
				break;
			}
			case 5:{
				System.out.println("Enter Id of restaurant: ");
				int id = sc.nextInt();
				Restaurant res = dao.retrieveOne(id);
				if(res != null) {
						dao.deleteOne(id);
				}else {
					System.out.println("Not found!!");
				}
				break;
			}
			case 0:{
				System.out.println("Thank you...");
				exit = false;
				break;
			}
			default:{
				System.out.println("Wrong choice try again.......");
			}
			}
		}
		sc.close();
	}

}
