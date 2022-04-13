package com.project.dentist.admin.adminEmployee;

public class AddCheck {
	
	//성별 체크
	static boolean isGender(String gender) {
		if (gender.equals("1") || gender.equals("2")) {
			return true;
		}
		System.out.println("남자는 \"1\" 여자는 \"2\"를 입력하세요.");
		return false;
	}

	//이름 체크
	static boolean isName(String name) {
		if (name.length() < 2 || name.length() > 5) {
			System.out.println("이름은 2~4글자만 입력 가능합니다.");
			return false;
			}
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			
			if (c < '가' || c > '힣') {
				System.out.println("이름은 한글로만 입력 가능합니다.");
				return false;
			}
		} 
		return true;
	}

	//생일 및 입사일 체크
	public static boolean isBirth(String birth) {
		if (birth.length() < 9 || birth.length() > 10) {
			System.out.println("예)2022-04-13 형식으로 입력해주세요.");
			return false;
		}
			return true;
	}

	//전화번호 체크
	public static boolean isTel(String tel) {
		if (tel.length() < 12 || tel.length() > 13) {
			System.out.println("예)010-0000-0000 형식으로 입력해주세요.");
			return false;
		}
		return true;
	}

	//자기소개서 경로 체크
	public static boolean isPath(String path) {
		int index = path.lastIndexOf(".");
		String extension = path.substring(index);
		
		if (extension.equals(".txt")) {
			return true;
		}
		
		return false;
	}

}
