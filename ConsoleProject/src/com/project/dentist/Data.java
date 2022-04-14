package com.project.dentist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data {
   
   public static ArrayList<Patient> plist = new ArrayList<Patient>();
   public static ArrayList<Appointment> alist = new ArrayList<Appointment>();
   public static ArrayList<DiagnosisInfo> dglist = new ArrayList<DiagnosisInfo>();
   public static ArrayList<DiagnosisDocument> ddlist = new ArrayList<DiagnosisDocument>();


   
   
   public static void load() {
      
      
      try {
         
         BufferedReader reader = new BufferedReader(new FileReader(DataPath.환자));

         String line = null;

         while ((line = reader.readLine()) != null) {
            
            //1,u3CzUhF5,o24n6kJy,박규민,남,1992-05-22,부산시 남구 대치동 5번지
            //번호,아이디,비밀번호,이름,성별,생년월일,주소
            String[] temp = line.split(",");
            
            Patient p = new Patient(temp[0], temp[1], temp[2], temp[3], temp[4],temp[5],temp[6], temp[7]);
            
            plist.add(p);
            
         }

         reader.close();
         
         
         reader = new BufferedReader(new FileReader(DataPath.진료정보));

         line = null;

         while ((line = reader.readLine()) != null) {
            
        	 //1,1,1,2022-02-03,2,3,1,1
            //진료번호,환자번호,의사번호,내원날짜,
            String[] temp = line.split(",");
            
            
            
            
            
         }

         reader.close();
         
         
         
         
      } catch (Exception e) {
         System.out.println("Data.load");
         e.printStackTrace();
      }
      
      
   }
   
   public static void save() {
      try {
         
         
         BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.환자));

                  
         
         
      } catch (Exception e) {
         System.out.println("Data.save");
         e.printStackTrace();
      }
   }
   
   

}