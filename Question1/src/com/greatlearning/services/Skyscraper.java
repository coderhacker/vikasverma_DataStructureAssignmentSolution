package com.greatlearning.services;

import java.util.*;

public class Skyscraper {

	private int[] fSizes;	// fSizes contains different floor sizes
	private int numberOffloors;  // numberOffloors represents number of floors
	private Integer[][] result;	//result array will contain the final table

	private List<Integer> visited;	// if a floor can not be assembled on a particular day it will be stored in visited list
	private List<Integer> assembled; // assembled will contain list of assembled floors

	public Skyscraper(int[] fSizes, int numberOffloors)
	{
		this.numberOffloors = numberOffloors;
		this.fSizes = fSizes;
		this.result = new Integer[numberOffloors][numberOffloors];
		this.visited = new LinkedList<>();
		this.assembled = new LinkedList<>();
	}

	// following logic is based on the statement:
	// A floor cannot be assembled in the building until all floors larger in size are placed.
	public void allFloorsAssembled() {
		int n;
		for (int i = 0, k = 0; i < numberOffloors; i++) {
			n = fSizes[i];
			k = 0;
			if (assembled.contains(n + 1) || n == numberOffloors)
			{
				assembled.add(n);
				result[i][k] = n; // here i+1 represents day number
				k++;
				while (visited.contains(n - 1)) {
					n = n - 1;
					assembled.add(n);
					result[i][k] = n; // here i+1 represents day number
					k++;
				}
			}
			else {
				visited.add(n);
				result[i] = null;
			}
		}
	}

	public void constructionOrder() {
		for (int i = 1, j = 0; i <= numberOffloors; i++, j++) {
			System.out.println("Day: " + i); // here i is representing day number
			if (result[j] != null) {
				for (int k = 0; k < result[j].length && result[j][k] != null; k++) {
					if (k >= 1)
						System.out.print(" ");
					System.out.print(result[j][k]);
				}
			}
			System.out.println();
		}
	}

}
