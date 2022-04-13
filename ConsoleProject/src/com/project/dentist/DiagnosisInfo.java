package com.project.dentist;

import java.util.Calendar;

public class DiagnosisInfo {
	
	private String seq;
	private Appointment appointment;
	private String treatmentNum; //시술번호
	
	public DiagnosisInfo(String seq, Appointment appointment, String treatmentNum) {
		this.seq = seq;
		this.appointment = appointment;
		this.treatmentNum = treatmentNum;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
	
	public String getAppointmentNum() {
		return seq;
	}
	public String getPatientNum() {
		return appointment.getSeq();
	}
	
	public String getDoctorNum() {
		return appointment.getDoctorNum();
	}

	public Calendar getDateTime() {
		return appointment.getDateTime();
	}
	
	public String getSymptomNum() {
		return appointment.getSymptomNum();
	}

	public String getClassficationNum() {
		return appointment.getClassficationNum();
	}
	
	public String getTreatmentNum() {
		return treatmentNum;
	}

	public void setTreatmentNum(String treatmentNum) {
		this.treatmentNum = treatmentNum;
	}

	@Override
	public String toString() {
		return String.format("DiagnosisInfo [seq=%s, appointment=%s, treatmentNum=%s]", seq,
				appointment, treatmentNum);
	}
	
	

	
	
	
}
