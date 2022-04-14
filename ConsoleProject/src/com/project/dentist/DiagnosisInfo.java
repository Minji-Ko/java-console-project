package com.project.dentist;

import java.util.Calendar;

public class DiagnosisInfo {
	
	private String seq;
	private String treatmentNum; //시술번호
	private String appointmentNum;
	private String patientNum;
	private String doctorNum;
	private String date;
	private String time;
	private String symptomNum;
	private String classficationNum;
	
	
	public DiagnosisInfo(String seq, String treatmentNum, Appointment appointment) { //진단서 작성시 사용
		
		this.seq = seq;
		this.treatmentNum = treatmentNum;
		this.appointmentNum = appointment.getSeq();
		this.patientNum = appointment.getPatientNum();
		this.doctorNum = appointment.getDoctorNum();
		this.date = appointment.getDate();
		this.time = appointment.getTime() + "\b\b" + String.format("%02d",(int)(Math.random() * 60));
		this.symptomNum = appointment.getSymptomNum(); //TODO 시술에 맞춰서 증상 저장
		this.classficationNum = appointment.getClassficationNum();
	}
	
	public DiagnosisInfo(String seq, String treatmentNum, String appointmentNum, String patientNum,
			String doctorNum, String date, String time, String symptomNum,
			String classficationNum) {

		this.seq = seq;
		this.treatmentNum = treatmentNum;
		this.appointmentNum = appointmentNum;
		this.patientNum = patientNum;
		this.doctorNum = doctorNum;
		this.date = date;
		this.time = time;
		this.symptomNum = symptomNum;
		this.classficationNum = classficationNum;
	}

	public String getSeq() {
		return seq;
	}

	public String getTreatmentNum() {
		return treatmentNum;
	}

	public String getAppointmentNum() {
		return appointmentNum;
	}

	public String getPatientNum() {
		return patientNum;
	}

	public String getDoctorNum() {
		return doctorNum;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getSymptomNum() {
		return symptomNum;
	}

	public String getClassficationNum() {
		return classficationNum;
	}

	@Override
	public String toString() {
		return String.format(
				"DiagnosisInfo [seq=%s, treatmentNum=%s, appointmentNum=%s, patientNum=%s, doctorNum=%s, date=%s, time=%s, symptomNum=%s, classficationNum=%s]",
				seq, treatmentNum, appointmentNum, patientNum, doctorNum, date, time, symptomNum,
				classficationNum);
	}

	
	

	
	
	
}
