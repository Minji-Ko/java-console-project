package com.project.dentist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Dataemp {
	
	public static ArrayList<Doctor> dlist = new ArrayList<Doctor>();
	public static ArrayList<Nurse> nlist = new ArrayList<Nurse>();
	
	public static void load() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.의사));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				Doctor d = new Doctor(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				
				dlist.add(d);
				
			}
			
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.간호사));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				Nurse n = new Nurse(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
				
				nlist.add(n);			
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
	}
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.의사));
			
			for (Doctor d : dlist) {
				
				//번호,이름,성별,생년월일,전화번호,입사일,자기소개서
				String line = String.format("%s,%s,%s,%s,%s,%s,%s\n"
						, d.getSeq()
						, d.getName()
						, d.getGender()
						, d.getBirth()
						, d.getTel()
						, d.getEntry()
						, d.getPath());
				
				writer.write(line);
				
			}
			
			writer.close();
			
			writer = new BufferedWriter(new FileWriter(DataPath.간호사));
			
			for (Nurse n : nlist) {
				String line = String.format("%s,%s,%s,%s,%s,%s\n"
						, n.getSeq()
						, n.getName()
						, n.getGender()
						, n.getBirth()
						, n.getTel()
						, n.getEntry());
				
				writer.write(line);
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
	}

}
