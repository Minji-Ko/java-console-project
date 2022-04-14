package com.project.dentist.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import com.project.dentist.DataPath;
import com.project.dentist.admin.adminEmployee.Data;

public class PatientReview {

	private Scanner scan;
	private static Data d = new Data();
	private static ReviewData r = new ReviewData();
	
	public PatientReview() {
		this.scan = new Scanner(System.in);
	}
	
	
	public static void DrReview() {
		
		try {
			
			if (Data.dlist.size() == 0) {
				Data.load();
			}
			
			int total;
			int n;
			double[] avg = new double[Data.dlist.size()];
			
			for (int i=0 ; i<Data.dlist.size() ; i++) {
				ReviewData.rlist.clear();
				total = 0;
				n = 0;
				ReviewData.load(i);
				
				for (int j=0 ; j<ReviewData.rlist.size() ; j++) {
					total += ReviewData.rlist.get(j).getStar().length();
					n++;
				}
				avg[i] = total / (double)n;
			}
				
			System.out.println("[의사번호] [이름] [별점 평점]");
			for (int i=0 ; i<Data.dlist.size() ; i++) {
				System.out.printf("%7d. %s\t%7.1f\n", i+1, Data.dlist.get(i).getName(), avg[i]);
			}
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("PatientReview.DrReview");
			e.printStackTrace();
		}

		
	}


	public static void printReview(String drNum) {
		
		int num = Integer.parseInt(drNum);
		Data.dlist.clear();
		Data.load();
		
		ReviewData.rlist.clear();
		ReviewData.load(num);
		System.out.println("================= 바른치과 " + Data.dlist.get(num).getName() + " 의사의 후기 ================= ");
		
		System.out.println("[글번호]   [작성자]    [별점]  [후기]");
		
		for (int i=0 ; i<ReviewData.rlist.size() ; i++) {
			
			String id = ReviewData.rlist.get(i).getId();
			id = id.substring(0, id.length()-4) + "****";
			
			String star = ReviewData.rlist.get(i).getStar().replace("*", "★");
			String blank = "";
			
				for (int j=0 ; j<5-star.length() ; j++) {
					blank += "☆";
				}
		
			System.out.printf("%5d. %10s  %s  %-30s\n", i+1, id, star + blank, ReviewData.rlist.get(i).getComment());
		}
		
		System.out.println("=========================================================");
		System.out.println();
	}
}
