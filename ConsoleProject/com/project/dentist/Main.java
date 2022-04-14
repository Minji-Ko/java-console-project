package com.project.dentist;

import java.util.Scanner;
import com.project.dentist.admin.AdminMain;

public class Main {

	public static void main(String[] args) { //로고 및 회원가입 로그인 화면

		

		Login login = new Login();
		Sign sign = new Sign();
		AdminMain aaa = new AdminMain();

		boolean loop = true;

		while (loop) {
			System.out.println("============바른 치과=============");
			System.out.println("  1.회원가입");
			System.out.println("  2.로그인");
			System.out.println("==================================");
			
			Scanner scan = new Scanner(System.in);
			System.out.print(" ✎ > ");
			String input = scan.nextLine();

			if (input.equals("1")) {
				aaa.main();
				//login.login();
			} else if (input.equals("2")) {
				sign.sign();
			} else {
				loop = false;
			}
			
			
		}

	}

}
