package com.project.dentist.admin;

import java.util.Scanner;
import com.project.dentist.Output;
import com.project.dentist.admin.adminDiagnosis.AdminDiagnosis;

public class AdminMain {
	
	public static void main() { //관리자 메인화면

		AdminDiagnosis diagnosis = new AdminDiagnosis();
		
		boolean loop = true;
		
		while (loop) {
		
			System.out.println("=====바른 치과=====");
			System.out.println("1. 스케줄표 확인");
			System.out.println("2. 환자 진료 정보");
			System.out.println("3. 직원 정보");
			System.out.println("4. 매출액 조회");
			System.out.println("5. 재고 관리");
			System.out.println("6. 온라인 상담");
			System.out.println("0. 로그아웃");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("번호 입력: ✎ ");
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				//
			} else if (input.equals("2")) {
				diagnosis.work();
			} else if (input.equals("3")) {
				//adminEmployee.work();
			} else if (input.equals("4")) {
				//adminSales.work();
			} else if (input.equals("5")) {
				//adminInventory.work();
			} else if (input.equals("6")) {
				//adminOnlineChat.work();
			} else if (input.equals("0")) {
				loop = false;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		
			System.out.println();
		}
		
	}

}
