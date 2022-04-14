package com.project.dentist.admin.adminEmployee;

import java.util.Scanner;
import com.project.dentist.Dataemp;
import com.project.dentist.Doctor;
import com.project.dentist.Nurse;

public class List {
	
	public void list() {
		System.out.println();
		System.out.println("===============================[의사]===============================");
		System.out.println();
		System.out.println("[번호]\t[이름]\t[성별]    [생년월일]\t  [전화번호]\t   [입사일]");
		
		for (Doctor d : Dataemp.dlist) {
			System.out.printf("%3s\t%s\t %s\t%s\t%s\t %s\n"
					, d.getSeq()
					, d.getName()
					, d.getGender().equals("1") ? "남자" : "여자"
					, d.getBirth()
					, d.getTel()
					, d.getEntry());
		}
		
		System.out.println();
		System.out.println("===============================[간호사]===============================");
		System.out.println();
		System.out.println("[번호]\t[이름]\t[성별]    [생년월일]\t  [전화번호]\t   [입사일]");
		
		for (Nurse n : Dataemp.nlist) {
			System.out.printf("%3s\t%s\t %s\t%s\t%s\t %s\n"
					, n.getSeq()
					, n.getName()
					, n.getGender().equals("1") ? "남자" : "여자"
					, n.getBirth()
					, n.getTel()
					, n.getEntry());
		}
		System.out.println();
	}
	
	public static void pause() {
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시 정지
		
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭.. == 일시 정지
	}

}
