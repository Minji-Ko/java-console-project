package com.project.dentist.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import com.project.dentist.DataPath;
import com.project.dentist.Output;
import com.project.dentist.admin.adminEmployee.Data;

public class Intro {

	private Scanner scan;
	
	public Intro() {
		this.scan = new Scanner(System.in);
	}
	

	
	
	public static void drList() {
		
		if (Data.dlist.size() == 0) {
			Data.load();
		}
		
		Output.subMenuStart("의료진 정보");
		String[] menu = new String[Data.dlist.size()+1];
		for (int i=0 ; i<Data.dlist.size() ; i++) {
			menu[i] = Data.dlist.get(i).getName();
		}		
		menu[Data.dlist.size()] = "상위메뉴";
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	
	
	public void printDr(String drNum) {
		
		
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.자기소개서 + drNum + ".txt"));
			
			String line = "";
			while ((line = reader.readLine()) != null) {
				
				System.out.println(line);
			}
			System.out.println();
			reader.close();
			
			PatientOutput.pause();
			
		} catch (Exception e) {
			System.out.println("Intro.printDr");
			e.printStackTrace();
		}

		
	}
	
	
}
