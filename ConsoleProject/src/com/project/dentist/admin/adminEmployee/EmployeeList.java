package com.project.dentist.admin.adminEmployee;

import java.util.Scanner;
import com.project.dentist.Output;

public class EmployeeList {
	
	public void main() {
		
		Data.load();
		
		List l = new List();
		Output o = new Output();
		String[] con = { "직원 목록", "직원 추가", "직원 삭제", "상위메뉴" };
		
		boolean loop = true;
		
		while (loop) {
		
		o.subMenuStart("직원 정보");
		o.subMenuContent(con); 
		o.subMenuEnd();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("번호 입력: ");
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			l.list();
			List.pause();
		} else if (input.equals("2")) {
			EmployeeAdd.add();
		} else if (input.equals("3")) {
			EmployeeAdd.delete();
		} else if (input.equals("0")) {
			loop = false;
		} else {
			System.out.println("잘못된 번호입니다.");
		}
		
		}
		
		Data.save();

	}

}
