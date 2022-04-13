package com.project.dentist.admin.adminDiagnosis;

import java.util.Scanner;
import com.project.dentist.Output;

public class AdminDiagnosis {
	
	public void work() {
		
		Search search = new Search();
		Write write = new Write();
		
		boolean loop = true;
		
		while (loop) {
			
			Output.subMenuStart("환자 진료 정보");
			String[] menu = {"진료 정보 검색", "진료 정보 작성", "상위메뉴"}; 
			Output.subMenuContent(menu);
			Output.subMenuEnd();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("번호 입력: ✎");
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				search.work();
			} else if (input.equals("2")) {
				write.work();
			} else if (input.equals("0")) {
				loop = false;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
			
			scan.close();
			
			System.out.println();
		}
	
	}
}

//1. Scanner로 번호 입력받기
//2. 내진료정보 루프 만들기
//3. 루프 내부 업무 메소드 만들기
