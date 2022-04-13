package com.project.dentist.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.DataPath;
import com.project.dentist.Output;

public class counsel {


	// private static Scanner scan;

	public counsel() {


		// this.scan = new Scanner(System.in); // 생성자에 처음부터 스캐너 생성해놓기

	}


	public static void menuStart(String title) {

		System.out.println(title);
		System.out.println("╭───────────────────────────╮");

	}

	public static void menuEnd() {

		System.out.println("╰───────────────────────────╯");

	}



	public static void counsel() {

		Output.subMenuStart("진료상담");
		String[] menu = {"FAQ", "온라인 상담", "상위메뉴"};
		Output.subMenuContent(menu);
		Output.subMenuEnd();


		Scanner scan = new Scanner(System.in);

		System.out.print("번호 입력: ");

		String input = scan.nextLine();


		if (input.equals("1")) {

			Output.subMenuStart("FAQ");
			String[] menu2 = {"치아교정", "치아미백", "충치치료", "임플란트", "라미네이트", "치아잇몸성형", "상위메뉴"};
			Output.subMenuContent(menu2);
			Output.subMenuEnd();



			System.out.println("번호입력:");
			input = scan.nextLine();


			if (input.equals("1")) {

				faq(DataPath.FAQ질문_치아교정, DataPath.FAQ답변_치아교정);

			} else if (input.equals("2")) {
				faq(DataPath.FAQ질문_치아미백, DataPath.FAQ답변_치아미백);

			} else if (input.equals("3")) {

				faq(DataPath.FAQ질문_충치치료, DataPath.FAQ답변_충치치료);
			} else if (input.equals("4")) {
				faq(DataPath.FAQ질문_임플란트, DataPath.FAQ답변_임플란트);

			} else if (input.equals("5")) {
				faq(DataPath.FAQ질문_라미네이트, DataPath.FAQ답변_라미네이트);

			} else if (input.equals("6")) {
				faq(DataPath.FAQ질문_치아잇몸성형, DataPath.FAQ답변_치아잇몸성형);

			} else if (input.equals("0")) {


			} else {

				System.out.println("번호를 올바르게 입력하세요.");
			}



		} else if (input.equals("2")) {



		} else if (input.equals("0")) {



		} else {

			System.out.println("번호를 올바르게 입력하세요.");

		}



	}


	public static void faq(String q, String a) {

		Scanner scan = new Scanner(System.in);
		String input;
		String question = "";

		try {

			BufferedReader reader = new BufferedReader(new FileReader(q));

			ArrayList<String> list = new ArrayList<String>();

			String line = null;

			while ((line = reader.readLine()) != null) {

				System.out.println(line);
				list.add(line);


			}


			// while()



			System.out.println("번호입력:");
			input = scan.nextLine();

			BufferedReader reader2 = new BufferedReader(new FileReader(a));
			reader = new BufferedReader(new FileReader(q));

			System.out.println("╭─────────────────────────────────────────────╮");


			for (String s : list) {

				String[] temp2 = s.split(",");

				if (input.toUpperCase().equals(temp2[0])) {

					System.out.println(s);
				}

			}

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");


				if (temp[1].equals(input.toUpperCase())) {



					System.out.println("----------------------------------");
					System.out.println("▶" + line.substring(6));


				}


			}

			System.out.println("╰─────────────────────────────────────────────╯");


		} catch (Exception e) {
			System.out.println("상담.counsel");
			e.printStackTrace();
		}
	}



}
