package com.project.dentist.admin.adminSchedule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Spliterator;
import com.project.dentist.DataPath;

public class AdminSchedule {
		
	public void work() {
		      
		try {
			BufferedReader reader = new BufferedReader(new FileReader(com.project.dentist.DataPath.의사));
			
			String line = null;
			String schedule = "의사 스케줄표";
			
			int i = 0;
			
			System.out.println("╭──────────────스케줄표 확인──────────────╮");
			while((line = reader.readLine()) != null) {
				if(i % 2 == 0 ) {
					System.out.println();
				}
				String[] temp = line.split(",");
				System.out.printf("  %s.%s%s  ", temp[0], temp[1], schedule);//의사번호, 의사명 출력
				i++;
				
			}
			System.out.println();
			System.out.println();
			System.out.println("╰─────────────────────────────────────╯");
			System.out.println();
			
			reader.close();
			
			reader = new BufferedReader(new FileReader(com.project.dentist.DataPath.의사));
			
			System.out.print("번호를 입력하세요✎");
			
			line = null;
			
			Scanner scan = new Scanner(System.in);	
			String input = scan.nextLine();
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if(input.equals(temp[0])) {//위 리스트에 출력된 의사번호 가져오기
					ScheduleCheck(temp[0]);
				}
			}
			
			reader.close();
			
			
			
				
			
			
			
		} catch (Exception e) {
			System.out.println("AdminSchedule.work");
			e.printStackTrace();
		}
	}
	
	public void ScheduleCheck(String input) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(com.project.dentist.DataPath.진료예약));
			ArrayList<String> date = new ArrayList<String>();
			ArrayList<String> time = new ArrayList<String>();
			
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				if(input.equals(temp[2])) {
					date.add(temp[3]);	//의사 번호가 같을 시 날짜를 ArrayList에 추가
					time.add(temp[4]);  //의사 번호가 같을 시 시간을 ArrayList에 추가
					System.out.println(date);
				}
			}
			
		} catch (Exception e) {
			System.out.println("AdminSchedule.ScheduleCheck");
			e.printStackTrace();
		}
	}

}




