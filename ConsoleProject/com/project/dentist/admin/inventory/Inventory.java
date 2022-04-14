package com.project.dentist.admin.inventory;

import java.util.Scanner;
import com.project.dentist.Datainven;
import com.project.dentist.Output;

public class Inventory {
	
	public void main() {
		
		Datainven.load();
		
		List l = new List();
		Output o = new Output();
		String[] con = { "수량 확인", "주문 하기", "상위메뉴" };
		
		boolean loop = true;
		
		while (loop) {
			o.subMenuStart("재고 확인");
			o.subMenuContent(con);
			o.subMenuEnd();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("번호 입력: ");
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				l.list();
			} else if (input.equals("2")) {
				l.auto();
			} else if (input.equals("0")) {
				loop = false;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
			
			
		}
		
		Datainven.save();
		
	}

}
