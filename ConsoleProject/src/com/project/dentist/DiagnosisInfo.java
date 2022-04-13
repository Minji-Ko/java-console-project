package com.project.dentist;

import java.util.Calendar;

public class DiagnosisInfo {
	
	private String Num;
	private String PatientNum;
	private String DoctorNum;

	private Calendar dateTime;  //TODO date + time 하나로 **
	private String SymptomNum; //증상번호
	private String treatmentNum; //시술번호
	private String resevationNum; //예약번호
	
	
	public DiagnosisInfo(String num, String patientNum, String doctorNum, String date, String time, 
			String symptomNum, String treatmentNum, String resevationNum) {
		
		this.Num = num;
		this.PatientNum = patientNum;
		this.DoctorNum = doctorNum;
		this.SymptomNum = symptomNum;
		this.treatmentNum = treatmentNum;
		this.resevationNum = resevationNum;
		
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(date.split("-")[0])
				, Integer.parseInt(date.split("-")[1])
				, Integer.parseInt(date.split("-")[2])
				, Integer.parseInt(time.split(":")[0])
				, Integer.parseInt(time.split(":")[1]));
		
		this.dateTime = c;
	}
	
	
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getPatientNum() {
		return PatientNum;
	}
	public void setPatientNum(String patientNum) {
		PatientNum = patientNum;
	}
	public String getDoctorNum() {
		return DoctorNum;
	}
	public void setDoctorNum(String doctorNum) {
		DoctorNum = doctorNum;
	}
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar date) {
		this.dateTime = date;
	}
	public String getSymptomNum() {
		return SymptomNum;
	}
	public void setSymptomNum(String symptomNum) {
		SymptomNum = symptomNum;
	}
	public String getTreatmentNum() {
		return treatmentNum;
	}
	public void setTreatmentNum(String treatmentNum) {
		this.treatmentNum = treatmentNum;
	}
	public String getResevationNum() {
		return resevationNum;
	}
	public void setResevationNum(String resevationNum) {
		this.resevationNum = resevationNum;
	}


	@Override
	public String toString() {
		return String.format(
				"DiagnosisInfo [Num=%s, PatientNum=%s, DoctorNum=%s, dateTime=%s, SymptomNum=%s, treatmentNum=%s, resevationNum=%s]",
				Num, PatientNum, DoctorNum, dateTime, SymptomNum, treatmentNum, resevationNum);
	}
	
	
	
}
