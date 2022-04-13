package com.project.dentist.admin.adminDiagnosis;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.Data;
import com.project.dentist.DiagnosisInfo;
import com.project.dentist.Output;
import com.project.dentist.Patient;

public class Search {

	public void work() {
		
		Scanner scan = new Scanner(System.in);

		ArrayList<Patient> patients = new ArrayList<Patient>(); //검색한 이름에 맞는 환자번호 저장 
		Patient thePatient;   //검색하고 싶은 바로 그 환자
		
		
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

		
		
		ArrayList<DiagnosisInfo> records = new ArrayList<DiagnosisInfo>();

		Output.subMenuStart("진료 상세기록");
		System.out.println("-------------------------------");
		System.out.printf("[이름] %s", thePatient.getName());
		System.out.println("-------------------------------");
		System.out.println("[내원날짜]\t[증상]\t[시술 내용]");
		
		//TODO 진료정보 불러와서 출력
		for(DiagnosisInfo d : dglist) { //dglist 진료정보 ArrayList 
			if(d.getPatientNum().equals(thePatient.getSeq())) { //환자번호와 진료정보의 환자번호가 같으면
				System.out.printf("%tF\t%s\t%s\n"
										, d.getDateTime()
										, //증상번호 > 증상명
										, //시술번호 > 시술내용);
				records.add(d);
			}
		}
		
		Output.subMenuEnd();
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.print("진단서를 확인하시겠습니까? (Y/N): ✎");
			input = scan.nextLine();
			
			if (input.toUpperCase().equals("Y")) {
				listRecord(records);
				loop = false;
			} else if (input.toUpperCase().equals("N")) {
				loop = false;
			} else {
				System.out.println("입력이 올바르지 않습니다. Y 또는 N을 입력해주세요.");
				System.out.println();
			}
		}
		
		Output.pause();
		scan.close();
		records.clear();
		
	}

	private void listRecord(ArrayList<DiagnosisInfo> records) {
		
		boolean loop = true;
			
		while (loop) {
			
			Output.subMenuStart("환자 진단서 확인");
			for(int i=0; i<records.size(); i++) {
				System.out.printf("%d. %tF\n", i+1, records.get(i).getDateTime());
			}
			Output.subMenuEnd();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("번호: ✎");
			int input = scan.nextInt();
			
			if(0 <= input && input <= records.size()) {
				DiagnosisInfo theDate = records.get(input-1);
				viewRecord(theDate); //TODO 진단서 출력 > 출력후 Pause하고 여기로 돌아옴
			} else {
				System.out.println("올바른 번호를 입력해주세요.");  //TODO 번호입력 다시받기 반복
				System.out.println();
			}

//		scan.close; ?????
		}
	}

	private void viewRecord(DiagnosisInfo theDate) {
		// TODO Auto-generated method stub
		
	}
	
	

}

//1.환자이름검색 
//	1.1 Scanner로 이름 입력받기
//	1.2 회원정보 ArrayList에서 회원정보 검색
// 		- 회원 저장
//	1.4 동명이인 처리
//		- 번호. 홍길동(23세, 남, 서울) 출력
//		- 번호입력받기
//2. 환자 진료 상세기록
//	2.1 표 출력
//		- 회원번호 > 진료정보 
//		- 이름
//		- 내원날짜, 증상, 시술 내용
//3. "진단서를 확인하시겠습니까?" 
//	3.1 Y > 진단서메뉴
//	3.2 N > 상위메뉴