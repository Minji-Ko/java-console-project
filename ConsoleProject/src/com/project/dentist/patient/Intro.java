package com.project.dentist.patient;

import java.util.Scanner;
import com.project.dentist.Output;

public class Intro {

	private Scanner scan;
	
	public Intro() {
		this.scan = new Scanner(System.in);
	}
	
	public static void printIntro() {
		
		Output.subMenuStart("병원 기본 정보");
		System.out.println("  [소개글] 안녕하세요, 바른치과입니다.");
		System.out.println("  [내용] 믿을 수 있는 의료진, 믿을 수 있는 장비,");
		System.out.println("        환자의 안전을 최우선으로 생각하는 바른치과!");
		System.out.println("  [위치] 서울 강남구 테헤란로 132");
		System.out.println("  [전화번호] 02-3482-4632");
		Output.subMenuEnd();
	}
	

	
}
