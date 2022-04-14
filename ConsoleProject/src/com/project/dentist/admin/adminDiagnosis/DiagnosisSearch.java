package com.project.dentist.admin.adminDiagnosis;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.Data;
import com.project.dentist.DiagnosisInfo;
import com.project.dentist.Output;
import com.project.dentist.Patient;

public class DiagnosisSearch extends AdminDiagnosis {

	private Scanner scan; 
	
	public DiagnosisSearch() {
		this.scan = new Scanner(System.in);
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public void work() {


		Patient thePatient = findPatient();		
		
		ArrayList<DiagnosisInfo> records = new ArrayList<DiagnosisInfo>();

		Output.subMenuStart("진료 상세기록");
		Output.line();
		System.out.printf("[이름] %s", thePatient.getName());
		Output.line();
		System.out.println("[내원날짜]\t\t[증상]\t[시술 내용]");
		
		//TODO 진료정보 불러와서 출력
		for(DiagnosisInfo d : Data.dglist) { //dglist 진료정보 ArrayList 
			if(d.getPatientNum().equals(thePatient.getSeq())) { //환자번호와 진료정보의 환자번호가 같으면
				System.out.printf("%s\t%s\t%s\n"
										, d.getDate()
										, d.getSymptomNum() //TODO 증상번호 > 증상명
										, d.getTreatmentNum()); //TODO 시술번호 > 시술내용)
				records.add(d);
			}
		}
		
		Output.subMenuEnd();
		
		boolean loop = true;
		
		while(loop) {

			System.out.print("진단서를 확인하시겠습니까? (Y/N): ✎");
			String input = scan.nextLine();
			
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

	

	private void listRecord(ArrayList<DiagnosisInfo> documentrecords) {
		
		boolean loop = true;
			
		while (loop) {
			
			Output.subMenuStart("환자 진단서 확인");
			for(int i=0; i<documentrecords.size(); i++) {
				System.out.printf("%d. %s\n", i+1, documentrecords.get(i).getDate());
			}
			Output.subMenuEnd();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("번호: ✎");
			int input = scan.nextInt();
			
			if(0 <= input && input <= documentrecords.size()) {
				DiagnosisInfo theDate = documentrecords.get(input-1);
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