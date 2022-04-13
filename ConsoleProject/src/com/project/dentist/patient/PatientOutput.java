package com.project.dentist.patient;

import java.util.Scanner;
import com.project.dentist.Output;

public class patientOutput {

	
	public static void introduce() {
		
		Output.subMenuStart("병원 소개");
		String[] menu = { "기본 정보", "의료진 정보", "상위 메뉴"};
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	
	public static void pause() {

		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시 정지
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭에 걸림 = 일시정지
		
	}
	
	public static void drList() {
		
		Output.subMenuStart("의료진 정보");
		String[] menu;
//		for ( String name : Data.dlist ) {
//			Data.dlist.getName() }; 수정 중
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	

}
