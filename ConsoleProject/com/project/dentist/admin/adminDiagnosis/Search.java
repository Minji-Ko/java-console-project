package com.project.dentist.admin.adminDiagnosis;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.Data;
import com.project.dentist.Output;
import com.project.dentist.Patient;

public class Search {

	private Scanner scan; 
	
	
	
	public Search() {
		this.scan = new Scanner(System.in);
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
