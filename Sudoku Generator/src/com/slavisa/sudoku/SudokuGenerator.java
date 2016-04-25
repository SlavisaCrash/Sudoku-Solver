package com.slavisa.sudoku;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class SudokuGenerator {

	//array in which are placed the numbers from 1 to 9
	private int[] numbers = new int[9];
	
	//variable in which is placed a random number 
	private Random r = new Random();
	
	//map for storing cell position and the value of that cell
	//key => value (0,0 => 5, 5,8 => 8 etc)
	private Map<String, Integer> mapaSudoku = new HashMap<>();
	
	//The method generates a random number from the range from 1 to 9
	private void randomNumbers(){
		
		int count = 0;
	
		while(count < 9){
			int num = r.nextInt(9) + 1;
			numbers[count] = num;
			count++;
			
			//If there is a duplicate eliminate it
			for(int i = 0; i < count - 1; i++){
				if(numbers[i] == num)
					count--;
			}
		}		
	}
	private void shiftTriplet(){
		
		int tmp = 0;
		
		tmp = numbers[0]; 
		numbers[0] = numbers[3]; numbers[3] = numbers[6]; numbers[6] = tmp;
		
		tmp = numbers[1];
		numbers[1] = numbers[4]; numbers[4] = numbers[7]; numbers[7] = tmp;
		
		tmp = numbers[2];
		numbers[2] = numbers[5]; numbers[5] = numbers[8]; numbers[8] = tmp;
		
	}
	private void moveCells(){
		
		int tmp = 0;
		
		tmp = numbers[0];
		numbers[0] = numbers[1]; numbers[1] = numbers[2]; numbers[2] = tmp;
		
		tmp = numbers[3];
		numbers[3] = numbers[4]; numbers[4] = numbers[5]; numbers[5] = tmp;
		
		tmp = numbers[6];
		numbers[6] = numbers[7]; numbers[7] = numbers[8]; numbers[8] = tmp;
		
	}
	 public Map<String, Integer> generateSudoku(){
		 
		 	randomNumbers();
			
			for(int i = 0; i < 9; i++){
				
				if(i > 0){
					shiftTriplet();
				}
				if(i == 3 || i == 6){
					moveCells();
				}
				for(int j = 0; j < 9; j++){
					mapaSudoku.put((String.valueOf(i)+","+String.valueOf(j)), numbers[j]);
				}
			}
			//I use treeMap to me properly sorted keys
			Map<String, Integer> treeMapSudoku = new TreeMap<>(mapaSudoku);
		
			return treeMapSudoku;	 
	 }
}
