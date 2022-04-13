package com.project.dentist.admin.adminEmployee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println("========[의사]=========");
		System.out.println("[번호]\t[이름]\t[성별]\t[생년월일] \t[전화번호] \t[입사일]");
		
		ArrayList<Dentist> dlist = new ArrayList<Dentist>();
		
			try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.의사));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				Dentist d = new Dentist(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				
				dlist.add(d);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
		System.out.println(dlist);
		
		for (Dentist d : Data.dlist) {
			System.out.printf("%4s\n"
					, d.getName());
		}
		
	}

}
