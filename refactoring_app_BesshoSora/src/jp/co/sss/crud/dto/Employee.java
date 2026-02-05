package jp.co.sss.crud.dto;

public class Employee {
	private int empId;
	private String empName;
	private int gender;
	private String birthday;
	private Department department;

	public Employee() {
		department = new Department();
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getGender() {
		//性別の文字化
		String genderString = "";
		if (this.gender == 0) {
			genderString = "回答なし";
		} else if (this.gender == 1) {
			genderString = "男性";
		} else if (this.gender == 2) {
			genderString = "女性";
		} else if (this.gender == 9) {
			genderString = "その他";
		} else {
			genderString = "不明";
		}
		return genderString;
	}

	public String getBirthday() {
		return birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		//性別の文字化
		String genderString;
		if (this.gender == 0) {
			genderString = "回答なし";
		} else if (this.gender == 1) {
			genderString = "男性";
		} else if (this.gender == 2) {
			genderString = "女性";
		} else if (this.gender == 9) {
			genderString = "その他";
		} else {
			genderString = "エラー（想定外の数字orNull）";
		}

		return empId + "\t" + empName + "\t" + genderString + "\t" + birthday + "\t" + department.getDeptName();
	}
}
