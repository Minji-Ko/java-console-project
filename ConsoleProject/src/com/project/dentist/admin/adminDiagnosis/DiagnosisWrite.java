package com.project.dentist.admin.adminDiagnosis;

import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.Stream;
import com.project.dentist.Appointment;
import com.project.dentist.Data;
import com.project.dentist.DataPath;
import com.project.dentist.DiagnosisDocument;
import com.project.dentist.DiagnosisInfo;
import com.project.dentist.Output;
import com.project.dentist.Patient;

public class DiagnosisWrite extends AdminDiagnosis {

	public Scanner scan;

	
	
	public DiagnosisWrite() {
		this.scan = new Scanner(System.in);
	}

	public void work() {
	
		
		Patient thePatient = findPatient();
		
		Appointment recentDiagnosis = findRecentDiagnosis(thePatient);
		
		if(recentDiagnosis != null) {
		
			Output.subMenuStart("진료 정보 작성");
			Output.line();
			System.out.printf("이름: %s\n" , thePatient.getName());
			System.out.printf("생년월일: %s\n", thePatient.getBirthday());
			System.out.printf("주소: %s\n", thePatient.getAddress());
			System.out.printf("번호: %s\n", thePatient.getPhoneNum());
			System.out.println();
				
			System.out.println("▶ 시술 선택 ─────────────────────────"); //시술에 따른 증상을 set
			
			listTreatmemt();
			
			System.out.print("시술: ✎"); //TODO 항목에 맞지 않는 정보 입력시 루프
			String treatment = scan.nextLine(); //TODO 번호 입력받아서 시술내용으로 변환
			
			System.out.println("▶ 의사 소견 작성 ─────────────────────────");
			
			System.out.print("의사 소견: ✎"); //TODO ""을 반환시 루프
			String opinion = scan.nextLine(); 
			
			Output.subMenuEnd();
			
			
	
			boolean loop = true;
			
			while(loop) {
	
				System.out.print("작성하신 진료 정보를 저장하시겠습니까? (Y/N): ✎");
				String input = scan.nextLine();
				System.out.println();
				
				if (input.toUpperCase().equals("Y")) {
					saveRecord(thePatient, recentDiagnosis, treatment, opinion);
					setReservation();
					loop = false;
					
				} else if (input.toUpperCase().equals("N")) {
					loop = false;
				} else {
					System.out.println("입력이 올바르지 않습니다. Y 또는 N을 입력해주세요.");
					System.out.println();
				}
				
			}
			
		} else {
			System.out.println("작성할 진료 내역이 없습니다.");
		}
	
		Output.pause();

	}	

	private void setReservation() {
		
		while(true) {

			System.out.println("다음 진료 날짜를 입력하시겠습니까? (Y/N): ✎");
			String input = scan.nextLine();
			System.out.println();
			
			if (input.toUpperCase().equals("Y")) {
				//TODO 예약하기 화면으로 이동
				return;
			} else if (input.toUpperCase().equals("N")) {
				return;
			} else {
				System.out.println("입력이 올바르지 않습니다. Y 또는 N을 입력해주세요.");
				System.out.println();
			}
			
		}
	
	}

	private void saveRecord(Patient thePatient, Appointment recentDiagnosis, String treatment, String opinion) {

		//진료기록 저장
		String diagnosisNum = findMaxSeq();
		
		DiagnosisInfo dg
				= new DiagnosisInfo(diagnosisNum, treatment, recentDiagnosis); 
		
		Data.dglist.add(dg);
		
		
		//진단서 저장
		DiagnosisDocument dd
				= new DiagnosisDocument(findMaxSeq2(), thePatient.getSeq(), diagnosisNum, opinion);
		
		Data.ddlist.add(dd);
		
		System.out.println("작성하신 진료 정보가 저장되었습니다.");
		System.out.println();
	}

	private String findMaxSeq() {
		
		int max = 0;
		
		for(DiagnosisInfo d : Data.dglist) {
			if(Integer.parseInt(d.getSeq()) > max) { 
				max = Integer.parseInt(d.getSeq());
			}
		}
		
		return "" + (max + 1);
		
	}
	
	private String findMaxSeq2() {  //이거 위에꺼랑 합칠 수 없나? TODO
		
		int max = 0;
		
		for(DiagnosisDocument d : Data.ddlist) {
			if(Integer.parseInt(d.getSeq()) > max) { 
				max = Integer.parseInt(d.getSeq());
			}
		}
		
		return "" + (max + 1);
		
	}
	
	private Appointment findRecentDiagnosis(Patient thePatient) {
		
		Calendar now = Calendar.getInstance();
		
		Data.alist.sort((a1, a2) -> {
			return a2.getDateTime().compareTo(a1.getDateTime());
		}); //날짜 내림차순 정렬
		
		for (Appointment a : Data.alist) {
			if(thePatient.getSeq().equals(a.getPatientNum())) {
				if(a.getDateTime().compareTo(now) < 0) {
					
					for(DiagnosisInfo d : Data.dglist) {
						if(!a.getSeq().equals(d.getAppointmentNum())) {
							return a;	
						}
					}
				}
			}
		}
		return null;
	
	}

	private void listTreatmemt() {
		//시술list출력 메소드 TODO
	
	}

	private void listSymptom() {
		//증상list출력 메소드 TODO
		
	}
}

/*
	1. 환자정보 출력하기
		1.1 이름, 생년월일, 주소
		1.2 전화번호
 	2. 가장 최근 내원날짜 불러오기
 		2.1 환자번호 > 예약날짜 중 현재시간 이전의 가장 최근 날짜의 예약 정보를 불러오기
 		2.2 그 날짜의 예약번호가 진료정보에 있는지 확인하기
 		2.3 있으면 "작성할 진료 내역이 없습니다."
 		2.4 없으면
 			- 진료번호 max+1 저장
 			- 환자번호, 의사번호, 내원날짜(최근날짜), 진료시간, 예약번호를 예약정보에서 불러와서 저장
 	3. 증상번호 입력받기 >
 			- 증상 목록 출력하기
 			- 증상 번호 입력받기
 			- 증상 번호 저장
 	4. 시술내용 입력받기
 			- 시술내용(시술명) 시술파일 이용하여 출력
 			- 번호 입력받기
 			- 시술 번호 불러와서 저장  > 진료정보 ArrayList에 업데이트
 	5. 의사 소견 입력받기
 			- 진단서 번호 max +1
 			- 환자번호, 진료번호 위에서 불러오기
 			- 입력받아서 저장
 	6. 저장하기

*/