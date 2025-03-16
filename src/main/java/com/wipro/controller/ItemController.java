package com.wipro.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wipro.entity.Item;
import com.wipro.service.IItemService;

@Controller
public class ItemController {
	@Autowired
	private IItemService service;
	
	private int currentPage = -1;   
	
	public List<Item> getItems(int pageNumber) {
		return service.getItems(pageNumber);
	}
	
	
	
	public void myController() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("========== Main Menu ==========");
			System.out.println("1.Get Previous 10 Records");
			System.out.println("2.Get Next 10 Records");
			System.out.println("3.Exit");

			System.out.print("Enter your Option [1,2,3] : ");
			int option = sc.nextInt();
			sc.nextLine();

			try {
				switch (option) {
				case 1:
					if (currentPage > 0) {
						currentPage--;
						getItems(currentPage).forEach(System.out::println); 
					} else {
						System.out.println("You're already on the first page!");
					}

					break;

				case 2:
					currentPage++;
					if (getItems(currentPage).stream().count() > 0) {
						getItems(currentPage).forEach(System.out::println);
					}else {
						System.out.println("No More Records present in the Database!!!");
						currentPage--;
					}
					break;

				case 3:
					System.out.println();
					System.out.print("********** Thank You for using Our Application **********");
					System.out.println();
					System.exit(0);

				default:
					System.out.println("Wrong Choice!!   Please Enter a valid number!!!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}		
	}
}
