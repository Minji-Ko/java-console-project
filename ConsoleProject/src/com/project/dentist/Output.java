package com.project.dentist;

import java.util.Scanner;

public class Output {
	
	public static void subMenuStart(String title) {
		
		System.out.printf("╭────────────── %8s ──────────────╮\n", title);
		
	}
	
	public static void subMenuContent(String[] title) {
		if(title.length <= 3) {
			
			for(int i=1; i<=title.length; i++) {
				if(title[i-1].contains("상위메뉴") || title[i-1].contains("취소") ) {
					System.out.printf("  0. %s\n", title[i-1]);
				} else {
					System.out.printf("  %d. %s\n", i, title[i-1]);
				}
			}
			
		} else {
			
			for(int i=1; i<=title.length; i++) {
				
				if(title[i-1].contains("상위메뉴") || title[i-1].contains("취소") ) {
					System.out.printf("  0. %s", title[i-1]);
				} else {
					System.out.printf("  %d. %s", i, title[i-1]);
				}
				
				
				if(i % 2 == 0 || i == title.length) {
					System.out.println();
				} else {
					if(title[i-1].length() < 5) {
						System.out.print("\t\t");
					} else {
						System.out.print("\t");
					}
				}
			}
		}		
	}

	public static void subMenuEnd() {
		System.out.println("╰─────────────────────────────────────────╯");
	}
	
	public static void pause() {
		
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시정지
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭.. == 일시 정지
	}

}
