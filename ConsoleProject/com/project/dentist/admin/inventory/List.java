package com.project.dentist.admin.inventory;

import java.util.Scanner;
import com.project.dentist.Datainven;
import com.project.dentist.Item;

public class List {
	
	public void list() {
		System.out.println();
		System.out.println("==================[수량 확인]==================");
		System.out.println();
		System.out.println("[번호]\t [이름(사용처)]    [단가]\t  [잔여수량]");
		
		for (Item i : Datainven.ilist) {
			System.out.printf("%3s\t%10s\t%4s원\t    %3d\n"
					, i.getSeq()
					, i.getIname()
					, i.getPrice()
					, i.getAmount());
		}
		
		System.out.println();
		
	}
	
	public void auto() {
		System.out.println();
		System.out.println("==================[주문 하기]==================");
		System.out.println();
		System.out.println("[번호]\t [이름(사용처)]    [단가]\t  [잔여수량]\t[자동 주문]");
		
		for (Item i : Datainven.ilist) {
			System.out.printf("%3s\t%10s\t%4s원\t    %3d\t\t%5d\n"
					, i.getSeq()
					, i.getIname()
					, i.getPrice()
					, i.getAmount()
					, i.getAuto());
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("자동 주문 수량을 변경할 재고의 번호를 입력하세요. > ");
		String input = scan.nextLine();
		
		Item result = null;
		
		for (Item i : Datainven.ilist) {
			if(i.getSeq().equals(input)) {
				result = i;
				break;
			}
		}
		
		if(result != null) {
			
			System.out.print("[변경 전 자동 주문 수량] : " + result.getAuto() + "[변경 후] : ");
			String auto = scan.nextLine();
			
			if (!auto.equals("")) {
				for (int i = 0; i < auto.length(); i++) {
					if (auto.charAt(i) < '0' || auto.charAt(i) > '9') {
						System.out.println("0~9의 숫자로 입력해주세요.");
						auto();
					} else {
						result.setAuto(Integer.parseInt(auto));
						System.out.println("변경이 완료되었습니다.");
						pause();
						break;
					}
				}
			}
		}
						
	}//save
	
	public static void pause() {
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시 정지
		
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭.. == 일시 정지
	}
	
}
