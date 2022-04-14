package com.project.dentist;

public class DiagnosisDocument {
	
	private String seq;
	private String patientNum;
	private String diagnosisNum;
	private String opinion;
	
	public DiagnosisDocument(String seq, String patientNum, String diagnosisNum, String opinion) {
		this.seq = seq;
		this.patientNum = patientNum;
		this.diagnosisNum = diagnosisNum;
		this.opinion = opinion;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(String patientNum) {
		this.patientNum = patientNum;
	}
	public String getDiagnosisNum() {
		return diagnosisNum;
	}
	public void setDiagnosisNum(String diagnosisNum) {
		this.diagnosisNum = diagnosisNum;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	@Override
	public String toString() {
		return String.format(
				"DiagnosisDocument [seq=%s, patientNum=%s, diagnosisNum=%s, opinion=%s]", seq,
				patientNum, diagnosisNum, opinion);
	}
	
	
	
}
