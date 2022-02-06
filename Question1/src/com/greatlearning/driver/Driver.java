package com.greatlearning.driver;

import java.util.*;
import com.greatlearning.services.*;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		// numberOffloors represents number of floors
		int numberOffloors = sc.nextInt();
		int[] floorSizes = new int[numberOffloors];
		for (int i = 1; i <= numberOffloors; i++) {
			System.out.println("enter the floor size given on day: " + i);
			floorSizes[i - 1] = sc.nextInt();
		}
		Skyscraper skyscraper = new Skyscraper(floorSizes, numberOffloors);
		skyscraper.allFloorsAssembled();

		System.out.println("The order of construction is as follows");
		skyscraper.constructionOrder();

		sc.close();
	}

}
