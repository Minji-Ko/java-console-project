package com.project.dentist;

public class Patient {
   
   //1,u3CzUhF5,o24n6kJy,박규민,남,1992-05-22,부산시 남구 대치동 5번지
   
   private String seq;
   private String id;
   private String password;
   private String name;
   private String gender;
   private String birthday;
   private String address;
   private String phoneNum;
   
   public Patient(String seq, String id, String password, String name, String gender, String birthday,
			String address, String phoneNum) {
		super();
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phoneNum = phoneNum;
	}
   
   public String getSeq() {
      return seq;
   }
   public void setSeq(String seq) {
      this.seq = seq;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getBirthday() {
      return birthday;
   }
   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   
   public String getPhoneNum() {
	return phoneNum;
   }

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

@Override
   public String toString() {
      return String.format(
            "Patient [seq=%s, id=%s, password=%s, name=%s, gender=%s, birthday=%s, address=%s, phoneNum=%s]",
            seq, id, password, name, gender, birthday, address, phoneNum);
   }

   
   
   
   

}