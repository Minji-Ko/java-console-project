package com.project.dentist.admin.adminEmployee;

import java.util.Scanner;

public class EmployeeAdd {

	//직원 추가하기
	public static void add() {

		boolean loop = true;

		while (loop) {

			Scanner scan = new Scanner(System.in);

			System.out.println();
			System.out.println("================직원 추가===============");
			System.out.println("1. 의사 추가\t2. 간호사 추가\t 0. 취소하기");
			System.out.print("번호 입력✎ >");
			String emp = scan.nextLine();

			if (emp.equals("1") || emp.equals("2")) {
				
				System.out.print("이름 : ");
				String name = scan.nextLine();
				
				if(AddCheck.isName(name)) {
				} else {
					continue;
				}

				System.out.print("성별(1.남자, 2.여자) : ");
				String gender = scan.nextLine();
				
				if (AddCheck.isGender(gender)) {
				} else {
					continue;
				}

				System.out.print("생년월일(YYYY-MM-DD) : ");
				String birth = scan.nextLine();
				
				if (AddCheck.isBirth(birth)) {
				} else {
					continue;
				}

				System.out.print("전화번호(010-XXXX-XXXX) : ");
				String tel = scan.nextLine();
				
				if (AddCheck.isTel(tel)) {
				} else {
					continue;
				}

				System.out.print("입사일 : ");
				String entry = scan.nextLine();
				
				if (AddCheck.isBirth(entry)) {
				} else {
					continue;
				}

				if (emp.equals("1")) {
					System.out.print("자기소개서 path : ");
					String path = scan.nextLine();
					
					if (AddCheck.isPath(path)) {
						
					} else {
						continue;
					}

					String seq = getdSeq();

					System.out.println("입력한 정보 : " + seq + " " + name + " " + gender + " " + birth + " " + tel + " " + entry + " " + path);

					Dentist d = new Dentist(seq,name,gender,birth,tel,entry,path);

					Data.dlist.add(d);
					System.out.println("직원 추가가 완료되었습니다.");
					loop = false;
				} else if (emp.equals("2")) {
					String seq = getnSeq();
					System.out.println("입력한 정보 : " + seq + " " + name + " " + gender + " " + birth + " " + tel + " " + entry);

					Nurse n = new Nurse(seq, name, gender, birth, tel, entry);
					Data.nlist.add(n);
					System.out.println("직원 추가가 완료되었습니다.");
					loop = false;
				}
			} else if (emp.equals("0")){
				loop = false;
			} else {
				System.out.println("1, 2, 0 중 올바른 숫자를 입력하세요.");
			}
		}

		pause();
	}

	
	//의사 번호 부여
	private static String getdSeq() {
		int dmax = 0;
		for (Dentist d : Data.dlist) {
			int seq = Integer.parseInt(d.getSeq());
			if (seq > dmax) {
				dmax = seq;
			}
		}
		return (dmax + 1) + "";
	}

	//간호사 번호 부여
	private static String getnSeq() {
		int nmax = 0;
		for (Nurse n : Data.nlist) {
			int seq = Integer.parseInt(n.getSeq());
			if (seq > nmax) {
				nmax = seq;
			}
		}
		return (nmax + 1) + "";
	}

	
	//회원 삭제하기
	public static void delete() {

		boolean loop = true;

		while (loop) {

			Scanner scan = new Scanner(System.in);
			System.out.print("1. 의사\t2. 간호사\t0. 취소 : ✎__");
			String chose = scan.nextLine();
			
			if (chose.equals("1") || chose.equals("2") || chose.equals("0")) {

				if (chose.equals("1")) {

					System.out.print("삭제하실 의사 이름을 입력하세요. ✎__ ");

					String input = scan.nextLine();

					Dentist result = null;

					for (Dentist d : Data.dlist) {
						if (d.getName().equals(input)) {
							result = d;
							break;
						}
					}

					if (result != null) {
						Data.dlist.remove(result);
						System.out.println("삭제가 완료되었습니다.");
					} else {
						System.out.println("입력하신 이름이 존재하지 않습니다.");
					}

					pause();

				} else if (chose.equals("2")){

					scan = new Scanner(System.in);
					System.out.print("삭제하실 간호사 이름을 입력하세요. ✎__ ");

					String input = scan.nextLine();

					Nurse result = null;

					for (Nurse n : Data.nlist) {
						if (n.getName().equals(input)) {
							result = n;
							break;
						}
					}

					if (result != null) {
						Data.nlist.remove(result);
						System.out.println("삭제가 완료되었습니다.");
						loop = false;
					} else {
						System.out.println("입력하신 이름이 존재하지 않습니다.");
					}

					pause();
				} else {
					loop = false;
				}

			} else {
				System.out.println("번호를 다시 확인해 주세요.");
			}

		}

	}//delete


	public static void pause() {
		System.out.println("계속하시려면 [엔터]를 입력하세요.");

		//프로그램 일시 정지

		Scanner scan = new Scanner(System.in);

		scan.nextLine(); //블럭.. == 일시 정지
	}

}
