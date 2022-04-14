package com.project.dentist.patient;

import java.util.Scanner;
import com.project.dentist.Output;
import com.project.dentist.admin.adminEmployee.Data;
import com.project.dentist.admin.adminEmployee.Dentist;

public class PatientOutput {

	
	public static void introduce() {
		
		Output.subMenuStart("병원 소개");
		String[] menu = { "기본 정보", "의료진 정보", "상위메뉴"};
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	public static void printIntro() {
		
		Output.subMenuStart("병원 기본 정보");
		System.out.println("  [소개글] 안녕하세요, 바른치과입니다.");
		System.out.println("  [내용] 믿을 수 있는 의료진, 믿을 수 있는 장비,");
		System.out.println("        환자의 안전을 최우선으로 생각하는 바른치과!");
		System.out.println("  [위치] 서울 강남구 테헤란로 132");
		System.out.println("  [전화번호] 02-3482-4632");
		Output.subMenuEnd();
	}
	
	
	public static void review() {
		
		Output.subMenuStart("진료 후기");
		String[] menu = { "진료 후기 조회", "진료 후기 작성", "상위메뉴" };
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	public static void pause() {

		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시 정지
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭에 걸림 = 일시정지
		
	}
	


}
