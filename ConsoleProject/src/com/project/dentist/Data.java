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
<<<<<<< HEAD


=======
   public static ArrayList<OnlineQuestion> olist = new ArrayList<OnlineQuestion>();
   
>>>>>>> 33895c63346bbfc227f5c4cc4d63e4c010a1d2fd
   
   
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
         
         
         
         reader = new BufferedReader(new FileReader(DataPath.온라인상담질문));


			// 번호,아이디,날짜시간,카테고리,제목,내용
			// 1,p1234,2022-03-01 22:30:55,충치,차가운 것을 먹으면 이가 시려요,차가운 물이나 아이스크림을 먹으면 어금니가 아파요

			line = null;

			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");


				OnlineQuestion o =
						new OnlineQuestion(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);

				olist.add(o);



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
   
   
   public static boolean questionSave() {

		try {

			// 온라인질문

			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.온라인상담질문));


			for (OnlineQuestion s : olist) {


				// 번호,아이디,날짜시간,카테고리,제목,내용

				String line = String.format("%s,%s,%s,%s,%s,%s\n", s.getSeq(), s.getId(),
						s.getDate(), s.getCategory(), s.getTitle(), s.getContent());



				writer.write(line);

			}

			writer.close();


			return true;



		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();


			return false;
		}

	}
   
   

}