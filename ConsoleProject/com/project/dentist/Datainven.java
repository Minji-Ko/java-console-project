package com.project.dentist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Datainven {
	
	public static ArrayList<Item> ilist = new ArrayList<Item>();
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.의료용품));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				Item i = new Item(temp[0], temp[1], temp[2]
						, Integer.parseInt(temp[3])
						, Integer.parseInt(temp[4]));
				
				ilist.add(i);
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.의료용품));
			
			for (Item i : ilist) {
				
				String line = String.format("%s,%s,%s,%d,%s\n" 
											, i.getSeq()
											, i.getIname()
											, i.getPrice()
											, i.getAmount()
											, i.getAuto());
				
				writer.write(line);
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
	}

}
