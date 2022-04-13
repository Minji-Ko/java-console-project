package com.project.dentist.patient;

import java.util.Scanner;
import com.project.dentist.Data;


public class Main {

   public static void main(String[] args) {
 
      boolean loop = true;

      while (loop) {

         // 그림

         System.out.println("============");
         System.out.println("**회원 모드**");
         System.out.println("============");


         System.out.println("1. 병원 소개\r\n" + "2. 내 진료 정보\r\n" + "3. 진료 예약\r\n" + "4. 진료 상담\r\n"
               + "5. 진료 후기\r\n" + "0. 로그아웃\r\n");



         Data.load();

         // 현재 로그인되어 있는 아이디(사용자가 로그인할 때 입력한 아이디 변수) = 회원정보.txt의 아이디 >

         String id = "fj0yfE6Z0";
         String name = "";

         for (int i = 0; i < Data.plist.size(); i++) {

            if (Data.plist.get(i).getId().equals(id)) {

               name = Data.plist.get(i).getName();

            }
         }

         System.out.printf("%s님 검진일까지 XX일 남았습니다!\n", name);
         System.out.println();


         // “XXX”님 검진일까지 “XX”일 남았습니다!!
         // 예약된 시간 “XX”시 내 대기 인원 N명


         Scanner scan = new Scanner(System.in);

         Work work = new Work();
         System.out.print("번호 입력: ");
         String input = scan.nextLine();
         System.out.println();

         
         if (input.equals("1")) {
            // 병원소개
        	 
             boolean subLoop = true;
             while (subLoop) {

	        	 patientOutput.introduce();
	        	 
	        	 System.out.print("확인할 정보 번호를 입력하세요. ✎");
	        	 String subInput = scan.nextLine();
	        	 System.out.println();
	        	 
	        	 if (subInput.equals("1")) {
	        		 
	        		 work.printIntro();
	        		 patientOutput.pause();
	        		 
	        	 } else if (subInput.equals("2")) {
	        		 
	        		 patientOutput.drList();
	        		 patientOutput.pause();
	        		 
	        		 
	        	 } else if (subInput.equals("0")) {
	        		 subLoop = false;
	        	 } else {
	        		System.out.println("0~2의 번호를 입력하세요.");
	        	 }
             }

             
             
             
             
             
         } else if (input.equals("2")) {
            // 내 진료 정보
            
         } else if (input.equals("3")) {
            // 진료 예약
         } else if (input.equals("4")) {
            // 진료 상담
         } else if (input.equals("5")) {
            // 진료 후기
         } else if (input.equals("0")) {
            // 초기 메인 화면
         } else {
            loop = false;
         }
      }



   }// main

}