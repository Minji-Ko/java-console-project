package com.project.dentist.admin.adminDiagnosis;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.Data;
import com.project.dentist.Output;
import com.project.dentist.Patient;

public class AdminDiagnosis {
	
private Scanner scan; 
	
	public AdminDiagnosis() {
		this.scan = new Scanner(System.in);
	}
	
	
	public void work() {
		
		DiagnosisSearch search = new DiagnosisSearch();
		DiagnosisWrite write = new DiagnosisWrite();
		
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
	
	public Patient findPatient() {
		
		ArrayList<Patient> patients = new ArrayList<Patient>(); //검색한 이름에 맞는 환자번호 저장 
		Patient thePatient = null;   //검색하고 싶은 바로 그 환자

		
		Output.subMenuStart("진료 정보 검색");
		
		System.out.print("이름: ✎");
		String input = scan.nextLine(); 
		
		
		for(Patient p : Data.plist) {   //환자정보 ArrayList
			if(p.getName().equals(input)) {
				patients.add(p);
			}
		}
		
		
		if(patients.size() == 0) {
			System.out.println("등록된 환자명을 입력해주세요."); //TODO 이름 검색루프로 돌아가기
		} else if (patients.size() == 1) {
			thePatient = patients.get(0);
		} else {
			
			System.out.println("-------------------------------");
			
			for(int i=0; i<patients.size(); i++) {
			
				System.out.printf("%d. %s(%s, %s, %s)\n"
						, i+1
						, patients.get(i).getName()
						, patients.get(i).getBirthday()
						, patients.get(i).getGender().equals("1") ? "남자" : "여자"
						, patients.get(i).getAddress());
			}
			System.out.println();
			
			System.out.print("번호: ✎");
			int inputNum = scan.nextInt(); 
			
			if(1 <= inputNum || inputNum <= patients.size()) {
				thePatient = patients.get(inputNum - 1);
			} else {
				System.out.println("알맞은 번호를 입력해주세요."); //TODO 번호검색 루프로 돌아가기
			}
		}
		
		Output.subMenuEnd();
		
		return thePatient;
	}
	
}

//1. Scanner로 번호 입력받기
//2. 내진료정보 루프 만들기
//3. 루프 내부 업무 메소드 만들기
